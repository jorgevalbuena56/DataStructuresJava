/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selection.n;

/**
 * Quickselect is a selection algorithm to find the kth smallest element in an
 * unordered list. Like quicksort, it is efficient in practice and has good
 * average-case performance, but has poor worst-case performance. Quickselect
 * and variants is the selection algorithm most often used in efficient
 * real-world implementations.
 *
 * Quickselect uses the same overall approach as quicksort, choosing one element
 * as a pivot and partitioning the data in two based on the pivot, accordingly
 * as less than or greater than the pivot. However, instead of recursing into
 * both sides, as in quicksort, quickselect only recurses into one side – the
 * side with the element it is searching for. This reduces the average
 * complexity from O(n log n) (in quicksort) to O(n) (in quickselect).
 *
 * As with quicksort, quickselect is generally implemented as an in-place
 * algorithm, and beyond selecting the kth element, it also partially sorts the
 * data. See selection algorithm for further discussion of the connection with
 * sorting.
 *
 * @author valgood
 */
public final class QuickSelectImpl {

     //reference to the array
    private int array[];
    private int nElements;

    public QuickSelectImpl(int size) {
        array = new int[size];
        nElements = 0;
    }

    /*
    + Insert a new element in the array - Takes O(1)
     */
    public void insert(int element) {
        if (nElements == array.length) {
            System.out.println("Can't insert. Array is Full");
            return;
        }
        array[nElements] = element;
        nElements++;
    }

    public void display() {
        if (nElements == 0) {
            System.err.println("Array is Empty");
        } else {
            for (int i = 0; i < nElements; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.print("\n");
        }

    }
    /**
     * Note the resemblance to quicksort: just as the minimum-based selection
     * algorithm is a partial selection sort, this is a partial quicksort,
     * generating and partitioning only O(log n) of its O(n) partitions. This
     * simple procedure has expected linear performance, and, like quicksort,
     * has quite good performance in practice. It is also an in-place algorithm,
     * requiring only constant memory overhead, since the tail recursion can be
     * eliminated with a loop like this
     */
    // Returns the n-th smallest element of list within left..right inclusive
    // (i.e. left <= n <= right).
    // The size of the list is not changing with each recursion.
    // Thus, n does not need to be updated with each round.
    public int quickSelect(int left, int right, int n) {
        if (left == right) { // If the list contains only one element,
            return array[left]; // return that element
        }
        // select a pivotIndex between left and right. IN this case we take the 
        // right index
        int pivotIndex = right;
        pivotIndex = partition(array, left, right, pivotIndex);
        // The pivot is in its final sorted position
        if (n == pivotIndex) {
            return array[n];
        } else if (n < pivotIndex) {
            return quickSelect(left, pivotIndex - 1, n);
        } else {
            return quickSelect(pivotIndex + 1, right, n);
        }
    }
    
    /**
     * In quicksort, there is a subprocedure called partition that can, in
     * linear time, group a list (ranging from indices left to right) into two
     * parts, those less than a certain element, and those greater than or equal
     * to the element. Here is pseudocode that performs a partition about the
     * element list[pivotIndex]
     */
    private static int partition(int[] array, int left, int right, int pivotIndex) {
        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right); // move pivot to end
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (array[i] < pivotValue) {
                swap(array, storeIndex, i);
                storeIndex++;
            }
        }
        swap(array, right, storeIndex); // Move pivot to its final place
        return storeIndex;
    }

    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}

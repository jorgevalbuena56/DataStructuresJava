/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting.nlogn;

/**
 * The heart of the mergesort algorithm is the merging of two already-sorted
 * arrays. Merging two sorted arrays A and B creates a third array, C, that
 * contains all the elements of A and B, also arranged in sorted order.
 *
 * The idea in the mergesort is to divide an array in half, sort each half, and
 * then use the merge() method to merge the two halves into a single sorted
 * array.
 *
 * We’ve seen that generally something is reduced in size each time a recursive
 * method calls itself, and built back up again each time the method returns. In
 * mergeSort() the range is divided in half each time this method calls itself,
 * and each time it returns it merges two smaller ranges into a larger one.
 *
 * @author valgood
 */
public class MergeSortImpl {

    //reference to the array
    private long arr[];
    private long auxArr[];
    private int nElements;

    public MergeSortImpl(int size) {
        arr = new long[size];
        auxArr = new long[size];
        nElements = 0;
    }

    /*
    + Insert a new element in the array - Takes O(1)
     */
    public void insert(long element) {
        if (nElements == arr.length) {
            System.out.println("Can't insert. Array is Full");
            return;
        }
        arr[nElements] = element;
        nElements++;
    }

    public void display() {
        if (nElements == 0) {
            System.err.println("Array is Empty");
        } else {
            for (int i = 0; i < nElements; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");
        }

    }

    public void mergeSort(int low, int high) {
        if (low == high) // if range is 1,
        {
            return; // no sorting needed
        } else { // find midpoint
            int mid = low + (high - low) / 2;
            // sort low half
            mergeSort(low, mid);
            // sort high half
            mergeSort(mid + 1, high);
            // merge them
            merge(low, mid, high);
        } // end else
    } // end recMergeSort()

    /**
     * As mergeSort() returns from finding two arrays of one element each, it
     * merges them into a sorted array of two elements. Each pair of resulting
     * 2-element arrays is then merged into a 4-element array. This process
     * continues with larger and larger arrays until the entire array is sorted.
     *
     * @param low
     * @param middle
     * @param high
     */
    private void merge(int low, int middle, int high) {
        //Copy both part into the auxiliary array 
        for (int i = low; i <= high; i++) {
            auxArr[i] = arr[i];
        }

        int halfPlusOne = middle + 1;
        int k = low;

        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (low <= middle && halfPlusOne <= high) {
            if (auxArr[low] <= auxArr[halfPlusOne]) {
                arr[k++] = auxArr[low++];
            } else {
                arr[k++] = auxArr[halfPlusOne++];
            }
        }
        // Copy the rest of the left side of the array into the target array
        while (low <= middle) {
            arr[k++] = auxArr[low++];
        }
    } // end merge()
}

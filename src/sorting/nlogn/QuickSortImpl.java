/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting.nlogn;

/**
 * Quicksort is undoubtedly the most popular sorting algorithm, and for good 
 * reason: In the majority of situations, it’s the fastest, operating in O(N*logN) time.
 * 
 * Basically, the quicksort algorithm operates by partitioning an array into 
 * two subarrays and then calling itself recursively to quicksort each of these 
 * subarrays.
 * 
 * To partition data is to divide it into two groups, so that all the items 
 * with a key value higher than a specified amount are in one group, and all 
 * the items with a lower key value are in another.
 * 
 * @author valgood
 */
public class QuickSortImpl {
    private long arr[]; //reference to the array
    private int nElements;

    public QuickSortImpl(int size) {
        arr = new long[size];
        nElements = 0;
    }
    
    /*
    + Insert a new element in the array - Takes O(1)
    */
    public void insert(long element){
        if(nElements == arr.length){
            System.out.println("Can't insert. Array is Full");
            return;
        }
        arr[nElements] = element;
        nElements ++;
    }
    
    public void display(){
        
        if(nElements == 0){
            System.err.println("Array is Empty");
        }else{
            for(int i=0;i<nElements;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");
        }
        
    }

    public void quickSort(int left, int right) {
        if (right - left <= 0) // if size <= 1,
        {
            return; // already sorted
        } else // size is 2 or larger
        {
            long pivot = arr[right]; // rightmost item is used as a Pivot
            int partition = partitionIt(left, right, pivot);
            quickSort(left, partition - 1); // sort left side
            quickSort(partition + 1, right); // sort right side
        }
    } // end quickSort()
    
    /**
     * the pivot’s key value is used to partition the array, following 
     * the partition the left subarray holds items smaller than the pivot, 
     * and the right subarray holds items larger. The pivot starts out 
     * on the right, but if it could somehow be placed between these 
     * two subarrays, it would be in the correct place—that is, in its 
     * final sorted position
     * 
     * To simplify inserting the pivot in its proper place, we can simply swap 
     * the pivot and the left item in the right subarray. This swap places the 
     * pivot in its proper position between the left and right groups. 
     * The left value is switched to the right end, but because it remains in 
     * the right (larger) group, the partitioning is undisturbed.
     * 
     * @param left
     * @param right
     * @param pivot
     * @return 
     */
    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1; // left (after ++)
        int rightPtr = right; // right-1 (after --)
        while (true) { 
            // find bigger item
            while (arr[++leftPtr] < pivot)
                ; // (nop)
            // find smaller item
            while (rightPtr > 0 && arr[--rightPtr] > pivot)
                ; // (nop)
            if (leftPtr >= rightPtr) // if pointers cross,
            {
                break; // partition done
            } else // not crossed, so
            {
                swap(leftPtr, rightPtr); // swap elements
            }
        } // end while(true)
        swap(leftPtr, right); // restore pivot to middle of the partitions
        return leftPtr; // return pivot location
    } // end partitionIt()

    public void swap(int dex1, int dex2) // swap two elements
    {
        long temp = arr[dex1]; // A into temp
        arr[dex1] = arr[dex2]; // B into A
        arr[dex2] = temp; // temp into B
    } // end swap(
}

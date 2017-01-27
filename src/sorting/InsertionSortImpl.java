/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 * Insertion Sort
 * 
 * Best of the elementary sorts. It still executes in O(N2) time, but it is about twice as fast as 
 * the bubble sort and somewhat faster than the selection sort in normal situations. It's also not too
 * complex, although it's slightly more involved than the bubble and selections sorts. It's often used
 * as the final stage of more sophisticated sorts, such as quicksort.
 * 
 * For data that is already sorted or almost sorted, the insertion sort does much better. 
 * When data is order, the condition in the while loop is never true, si it becomes a simple statement
 * in the outer loop. which executes N - 1 time. In this case, the algorithm runs in O(N) time.
 * 
 * If data is almost sorted, insertion sort runs in almost O(N) time, which makes it a simple and efficient
 * way to order a file that is only slightly out of order.
 * 
 * For data arranged in reverse order, every possible comparison and shift is carried out,
 * so the insertion sort runs no faster than the bubble sort. 
 * 
 * 
 * 
 * TAKES O(N2) SQUARE
 * 
 * @author George
 */
public class InsertionSortImpl {
    
    private long arr[]; //reference to the array
    private int nElements;

    public InsertionSortImpl(int size) {
        
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

    public void insertionSort(){
        int in;
        int out;
        
        for(out = 1; out < nElements; out ++){      //out is dividing line
            long temp = arr[out];                   //remove marked item
            in = out;                               //start shifts at out
            while(in > 0 && arr[in - 1] >= temp){   //until one is smaller
                arr[in] = arr[in - 1];              //shift item right
                --in;                               //go left one position
            }
            arr[in] = temp;
        }
    }
}

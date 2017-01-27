/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 * Bubble Sorting
 * 
 * This algorithm is notoriously slow but it is conceptually the simplest of the sorting algorithms
 * 
 * 1. - Compare two items
 * 2. - If the one on the left is taller, swap them
 * 3. - Move one position right
 * 
 * As the algorithm progresses, the biggest items "bubble up" to the top end of the array.
 * 
 * TAKES O(N2) SQUARE
 * 
 * @author George
 */
public class BubbleSortImpl {
    
    private long arr[]; //reference to the array
    private int nElements;

    public BubbleSortImpl(int size) {
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
    
    public void bubbleSort(){
        int out;
        int in;
        
        for(out = nElements - 1; out > 1; out--){  //outer loop backward
            for(in = 0; in < out; in++){           //inner loop forward
                if(arr[in] > arr[in + 1]){         // out of order?
                    swap(in, in + 1);              //swap them
                }
            }
        }
    }
    
    private void swap(int one, int two){
        long temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 * Selection Sort
 * 
 * Improves on the bubble sort by reducing the number of swaps necessary from O(N2) to O(N).
 * Unfortunately, the number of comparisons remains O(N2).
 * 
 * It might be useful when the amount of data is small and swapping data items is very time-consuming
 * compare with comparing them.
 * 
 * It looks for the minimun and swap in order to keeps the lower elements on the left.
 * 
 * This algoritm is unquestionably faster because there are so few swaps. For smaller values of N
 * it may in fact be considerably faster, especially if the swap times are much larger than the comparison
 * times.
 * 
 * 
 * TAKES O(N2) SQUARE
 * 
 * @author George
 */
public class SelectionSortImpl {
       
    private long arr[]; //reference to the array
    private int nElements;

    public SelectionSortImpl(int size) {        
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
    
    public void selectionSort(){
        int in;
        int out;
        int min;
        
        for(out = 0; out < nElements - 1; out++){    //outer loop
            min = out;                               //minimum
            
            for(in = out + 1; in < nElements; in++){ //inner loop
                if(arr[in] < arr[min]){              //if min greater
                    min = in;                        //we have a new min
                }
            }
            swap(out, min);                         //swap them
        }
    }
    
    private void swap(int one, int two){
        long temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}

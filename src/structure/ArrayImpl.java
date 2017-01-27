/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

/**
 *
 * @author George Valbuena
 */
public class ArrayImpl {
    
    private long arr[]; //reference to the array
    private int nElements;

    public ArrayImpl(int size) {
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
    
    /*
    * TAKES O(N)
    */
    public void insertInOrder(long element) {

        int i;
        if (nElements == arr.length) {
            System.out.println("Can't insert. Array is Full");
            return;
        }
        for (i = 0; i < nElements; i++) {
            if (arr[i] > element) {
                break;
            }
        }

        //Shift the elements begining in the back
        int j;
        int startPos;

        if (nElements + 1 == arr.length) {
            startPos = nElements;
        } else {
            startPos = nElements + 1;
        }
        for (j = startPos; j > i; j--) {
            arr[j] = arr[j - 1];
        }

        arr[j] = element;
        nElements++;
    }
    
    /*
    * TAKES O(N)
    */
    public boolean delete(long element){
        
        //Search the element position first.
        int i;
        for(i=0; i<nElements;i++){
            if(arr[i] == element){
                break;
            }
        }
        
        //If I reached the end of the array or the array was empty
        //then return false
        if(i == nElements){
            return false;
        }else{
            //Found the element, start to shift the elements from the position of the element to delete
            for(int j=i;j<nElements-1;j++){
                arr[j] = arr[j+1];
            }
            //One element less
            nElements --;
            return true;
        }
    }
    
    /*
    * Linear Search: TAKES O(N)
    */
    public boolean find(long element){
        
        int i;
        
        for(i = 0; i<arr.length;i++){
            if(arr[i] == element){
                break;
            }
        }
        
        return i != nElements;
    }
    
    /*
     * Binary Search: 
    *  
    *  Remember that this kind of search only makes sense with ordered arrays
    * 
    *  TAKES O(LOG N)
    */
    public int findBinary(long element){
        
        int lowerBound = 0;
        int upperBound = nElements - 1;
        int curIn;
        
        while (true){
            curIn = (lowerBound + upperBound) / 2;
            if(arr[curIn] == element){
                return curIn;
            }else{
                if(arr[curIn] < element){
                    //It's in the upper half
                    lowerBound = curIn + 1; 
                }else{
                    //It's in the lower half
                    upperBound = curIn - 1;
                }
            }
        }
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
    
    
}

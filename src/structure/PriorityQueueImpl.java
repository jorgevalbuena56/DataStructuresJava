/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

/**
 *  Implementation of a PriorityQueue using array
 * @author GeorgeLocal
 */
public class PriorityQueueImpl {
    //array in sorter order, from max at 0 to min at size - 1
    private int maxSize;
    
    private double[] queArray;
    private int nItems;

    public PriorityQueueImpl(int size) {
        maxSize = size;
        queArray = new double[maxSize];
        nItems = 0;
    }
    
    /**
     * In Priority Queue Insert runs in O(N) due to the shiftings. It can be improved with HEAPS
     * @param item 
     */
    public void insert(double item){
        
        int j = 0;
        
        if(nItems == 0){
            queArray[nItems++] = item;      //If no items, insert at 0
        }else{
            //open space for the new element
            for(j = nItems - 1;j>=0;j--){   //start at the end
                if(item > queArray[j]){     //if new item
                    queArray[j + 1] = queArray[j];   //shift upward
                }else{                      //if smaller, donw shifting
                    break;
                }                
            }
            queArray[j+1] = item;           //insert it
            nItems++;
        }
    }
    
    public double remove(){                 //remove minimun item
        return queArray[--nItems];
    }
    
    public double peekMin(){                //peek at minimum item
        return queArray[nItems - 1];        
    }
    
    public boolean isEmpty(){
        return (nItems == 0);
    }
    
    public boolean isFull(){
        return (nItems == maxSize);
    }
}

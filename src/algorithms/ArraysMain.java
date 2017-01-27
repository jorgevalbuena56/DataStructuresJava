/*
 * Demostration of the use of arrays and included Algorithms to search: Binary, 
 */
package algorithms;

import impl.ArrayImpl;
import sorting.BubbleSortImpl;
import sorting.InsertionSortImpl;
import sorting.SelectionSortImpl;

/**
 * 
 * @author GeorgeLocal
 */
public class ArraysMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //ArrayImpl arr = new ArrayImpl(10);
        //BubbleSortImpl arr = new BubbleSortImpl(10);
        //InsertionSortImpl arr = new InsertionSortImpl(10);
        SelectionSortImpl arr = new SelectionSortImpl(10);
        
        
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        
        
        /*
        arr.insertInOrder(77);
        arr.insertInOrder(99);
        arr.insertInOrder(44);
        arr.insertInOrder(55);
        arr.insertInOrder(22);
        arr.insertInOrder(88);
        arr.insertInOrder(11);
        arr.insertInOrder(00);
        arr.insertInOrder(66);
        arr.insertInOrder(33);
        */
        arr.display();
        
        //arr.delete(100);
        //arr.insertInOrder(-1);
        //arr.bubbleSort();
        //arr.insertionSort();
        arr.selectionSort();
        
        arr.display();
        
        //arr.insertInOrder(100);
        //arr.insertInOrder(45);
        //arr.display();
        /*
        long searchKey = 35;
        
        if(arr.find(searchKey)){
            System.out.println("\nFound key: " + searchKey);
        }else{
            System.out.println("\nCan't Found key: " + searchKey);
        }
        
        arr.delete(00);
        arr.delete(55);
        arr.delete(99);
        */        
        //arr.display();
    }
    
}

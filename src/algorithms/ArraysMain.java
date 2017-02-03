/*
 * Demostration of the use of arrays and included Algorithms to search: Binary, 
 */
package algorithms;

import impl.ArrayImpl;
import selection.n.QuickSelectImpl;
import sorting.n2.BubbleSortImpl;
import sorting.n2.InsertionSortImpl;
import sorting.n2.SelectionSortImpl;
import sorting.nlogn.MergeSortImpl;
import sorting.nlogn.QuickSortImpl;

/**
 * Main Class to test the different algorithms implemented in the other classes
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
        //SelectionSortImpl arr = new SelectionSortImpl(10);
        //MergeSortImpl arr = new MergeSortImpl(11);
        //QuickSortImpl arr = new QuickSortImpl(11);
        QuickSelectImpl arr = new QuickSelectImpl(3);
        
        arr.insert(2);
        arr.insert(6);
        arr.insert(1);
//        arr.insert(4);
//        arr.insert(2);
//        arr.insert(1);
//        
        System.out.println("nth value is: " + arr.quickSelect(0, 2, 1));
//        arr.insert(99);
//        arr.insert(77);      
//        arr.insert(44);
//        arr.insert(55);
//        arr.insert(22);
//        arr.insert(88);
//        arr.insert(11);
//        arr.insert(00);
//        arr.insert(66);
//        arr.insert(33);
//        arr.insert(4);
        
        
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
        //arr.selectionSort();
        //arr.mergeSort(0, 10); //Num Elements - 1
        //arr.quickSort(0, 10); //Num Elements - 1
        
        
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

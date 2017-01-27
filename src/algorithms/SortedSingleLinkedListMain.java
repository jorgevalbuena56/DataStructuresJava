/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import structure.SingleLinkedList;
import structure.SortedSingleLinkedListImpl;
import structure.node.Link;

/**
 * 
 * @author GeorgeLocal
 */
public class SortedSingleLinkedListMain {
    
    public static void main(String[] args){
        
        SortedSingleLinkedListImpl list = new SortedSingleLinkedListImpl();
        
        list.insert(20, 2.99);
        list.insert(40, 4.99);
        
        list.displayList();
                
        list.insert(10, 6.99);
        list.insert(30, 8.99);
        list.insert(50, 8.99);
        
        list.displayList();
        
        list.remove();
        
        list.displayList();
    }
}

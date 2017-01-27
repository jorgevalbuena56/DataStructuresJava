/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import structure.FirstLastLinkedList;

/**
 * 
 * @author GeorgeLocal
 */
public class FirstLastLinkedListMain {
    
    public static void main(String[] args){
        
        FirstLastLinkedList list = new FirstLastLinkedList();
        
        list.insertFirst(22, 2.99);
        list.insertFirst(44, 4.99);
        list.insertFirst(66, 6.99);
        
        list.insertLast(11, 8.99);
        list.insertLast(33, 10.99);
        list.insertLast(55, 12.99);
        
        list.displayList();
        
        list.deleteFirst();
        list.deleteFirst();
        
        list.displayList();
    }
}

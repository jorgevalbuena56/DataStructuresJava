/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import structure.DoubleLinkedList;
import structure.SingleLinkedList;
import structure.node.Link;

/**
 * 
 * @author GeorgeLocal
 */
public class DoubleLinkedListMain {
    
    public static void main(String[] args){
        
        DoubleLinkedList list = new DoubleLinkedList();
        
        list.insertFirst(22);
        list.insertFirst(44);
        list.insertFirst(66);
        
        list.insertLast(11);
        list.insertLast(33);
        list.insertLast(55);
        
        list.displayForward();
        list.displayBackward();
        
        list.deleteFirst();
        list.deleteLast();
        list.deleteKey(11);
        
        list.displayForward();
        
        list.insertAfter(22, 77);
        list.insertAfter(33, 88);
        
        list.displayForward();
        
    }
}

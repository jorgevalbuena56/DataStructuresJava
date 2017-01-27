/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import structure.SingleLinkedList;
import structure.node.Link;

/**
 * 
 * @author GeorgeLocal
 */
public class SingleLinkedListMain {
    
    public static void main(String[] args){
        
        SingleLinkedList list = new SingleLinkedList();
        
        list.insertFirst(22, 2.99);
        list.insertFirst(44, 4.99);
        list.insertFirst(66, 6.99);
        list.insertFirst(88, 8.99);
        
        list.displayList();
        
        Link f = list.find(44);
        
        if(f != null){
            System.out.println("Found link with key " + f.iData);
        }else{
            System.out.println("Can´t find link");
        }
        
        Link d = list.delete(66);
        if(d != null){
            System.out.println("Deleted link with key " + d.iData);
        }else{
            System.out.println("Can´t delete link");
        }
        
        /*
        while(!list.isEmpty()){
            DoubleLinkedList link = list.deleteFirst();
            System.out.print("Deleted ");
            link.displayLink();
            System.out.println("");
        }
        */
        list.displayList();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import structure.LinkedStackImpl;
import structure.SingleLinkedList;
import structure.node.Link;

/**
 * 
 * @author GeorgeLocal
 */
public class LinkedStacktMain {
    
    public static void main(String[] args){
        
        LinkedStackImpl stack = new LinkedStackImpl();
        
        stack.push(20, 2.99);
        stack.push(40, 4.99);
        
        stack.displayStack();
        
        stack.peek();
        
        stack.push(60, 6.99);
        stack.push(80, 8.99);

        stack.peek();
        
        stack.displayStack();
        
        stack.pop();
        stack.pop();
        
        stack.displayStack();
    }
}

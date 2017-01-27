/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import structure.LinkedQueueImpl;

/**
 * 
 * @author GeorgeLocal
 */
public class LinkedQueuetMain {
    
    public static void main(String[] args){
        
        LinkedQueueImpl stack = new LinkedQueueImpl();
        
        stack.insert(20, 2.99);
        stack.insert(40, 4.99);
        
        stack.displayQueue();
        
        stack.insert(60, 6.99);
        stack.insert(80, 8.99);

        
        stack.displayQueue();
        
        stack.remove();
        stack.remove();
        
        stack.displayQueue();
    }
}

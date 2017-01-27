/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import structure.QueueImpl;

/**
 *
 * @author GeorgeLocal
 */
public class QueueMain {
    
    public static void main(String args[]){

        QueueImpl queue = new QueueImpl(5);
        
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        
        queue.remove();
        queue.remove();
        queue.remove();
        
        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.insert(80);
        
        while(!queue.isEmpty()){
            int n = queue.remove();
            System.out.print(n);
            System.out.print(" ");
        }
        
        System.out.println(" ");
        

    }
    
}

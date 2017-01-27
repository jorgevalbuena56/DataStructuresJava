/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import structure.PriorityQueueImpl;

/**
 *
 * @author GeorgeLocal
 */
public class PriorityQueueMain {
    
    
    public static void main (String args[]){

        PriorityQueueImpl pq = new PriorityQueueImpl(5);
    
        pq.insert(30);
        pq.insert(50);
        pq.insert(10);
        pq.insert(40);
        pq.insert(20);
        
        while(!pq.isEmpty()){
            double item = pq.remove();
            System.out.print(item + " ");
        }
        System.out.println(" ");
    }
}

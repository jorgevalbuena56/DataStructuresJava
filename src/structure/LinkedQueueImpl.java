/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import structure.node.Link;

/**
 *  Implementation for a Queue using a Linked List
 * 
 *  The front and rear pointers assume certain positions when the queue is full, 
 *  but they can assume exact same positions when the queue is empty. 
 *  
 *  The queue can then appear to be full and empty at the same time.
 *  This problem can be solved making the array one cell larger then the
 *  maximum number of items that will be place in it.
 *  
 *  
 * @author GeorgeLocal
 */
public class LinkedQueueImpl {
    private FirstLastLinkedList theList;

    public LinkedQueueImpl() {
       theList = new FirstLastLinkedList();
    }
    
    public void insert(int j, double dData){
        theList.insertLast(j, dData);
    }
    
    public Link remove(){
        Link link = theList.deleteFirst();
        return link;
    }
    
    public boolean isEmpty(){
        return theList.isEmpty();
    }

    public void displayQueue(){
        System.out.println("Queue (front-->rear): ");
        theList.displayList();
    }
 
}

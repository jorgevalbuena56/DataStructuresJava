
package structure;

import structure.node.Link;

/**
 * Implementation of a Double Link List.
 * 
 * @author George
 */
public class FirstLastLinkedList {
    
    public Link first;      
    public Link last;    

    public FirstLastLinkedList() {
        this.first = null;
        this.last = null;
    }
    
    public boolean isEmpty(){           //true if no links
        return first == null;
    }
    
    // Insert at front of the list
    public void insertFirst(int idData, double dData){
        Link newLink = new Link(idData, dData);
        
        if(isEmpty()){
            last = newLink;             //newLink <-- last
        }
        
        newLink.next = first;           //newLink,next --> old first
        first = newLink;                //first --> newLink
    }
    
    // Insert at end of the list
    public void insertLast(int idData, double dData){
        Link newLink = new Link(idData, dData);
        
        if(isEmpty()){
            first = newLink;             //first --> newLink
        }else{
            last.next = newLink;        //old last --> newLink
        }
        
        last = newLink;                //last --> newLink
    }
    
    // Delete first link
    public Link deleteFirst(){
        
        Link tmp = null;
                
        if(!isEmpty()){
            tmp = first;
            if(first.next == null){
                last = null;
            }
            first = first.next;
        }else{
            System.out.println("Can´t delete, List is Empty");
        }
        
        return tmp;
    }
    
    public void displayList(){
        System.out.print("List (first --> last): ");
        Link current = first;           //start at the begining
        
        while (current != null){
            current.displayLink();      //print data
            current = current.next;     //move to the next link
        }
        System.out.println("");
    }
}

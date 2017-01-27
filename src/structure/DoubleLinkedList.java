package structure;

import structure.node.DoubleLink;
import structure.node.Link;

/**
 * Implementation of a Double Linked List
 * @author George
 */
public class DoubleLinkedList {
    
    private DoubleLink first;             //ref to the first item
    private DoubleLink last;              //ref to the last item

    public DoubleLinkedList() {
        first = null;              //no items on the list yet
        last = null;
    }
    
    public boolean isEmpty(){
        return (first == null);
    }
    
    public void insertFirst(int id){     //insert at front of list
        DoubleLink newLink = new DoubleLink(id);
        if(isEmpty()){
            last = newLink;
        }else{
            first.previous = newLink;
        }
        newLink.next = first;                      //newLink --> old first
        first = newLink;                           //first --> newLink
    }
    
    public void insertLast(int id){     //insert at end of list
        DoubleLink newLink = new DoubleLink(id);
        if(isEmpty()){
            last = newLink;
        }else{
            last.next = newLink;
            newLink.previous = last;               //newLink --> old last
        }
        
        last = newLink;                           //last --> newLink
    }
        
    public DoubleLink deleteFirst(){              //delete first link
        if(!isEmpty()){
            DoubleLink temp = first;              //save reference to link
            if(first.next == null)                //if only one item  
                last = null;    
            else
                first.next.previous = null;       //old next null
            first = first.next;                   //delete it: first --> old next
            return temp;
        }else{
            System.out.println("List empty. Can not delete");
        }
        
        return null;
    }
    
    public DoubleLink deleteLast(){              //delete last link
        if(!isEmpty()){
            DoubleLink temp = last;              //save reference to last
            if(first.next == null)                //if only one item  
                first = null;    
            else
                last.previous.next = null;       //old previous null
            last = last.previous;                   //delete it: last --> old previous
            return temp;
        }else{
            System.out.println("List empty. Can not delete");
        }
        
        return null;
    }
    
    //Insert dd just after key
    public boolean insertAfter(double key, double dd){
        
        if(!isEmpty()){
            DoubleLink current = first;     //start at the begining
            while(current.dData != key){
                current = current.next;
                if(current == null)
                    return false;
            }
            
            DoubleLink newLink = new DoubleLink(dd);
            
            //if its the last link
            if(current == last){
                newLink.next = null;
                last = newLink;
            }else{
                newLink.next = current.next;
                current.next.previous = newLink;
            }
            
            newLink.previous = current;
            current.next = newLink;
            
        }else{
            System.out.println("Can't insert after. List empty");
        }
        
        return true;
    }
    
    //delete item with the given key
    public DoubleLink deleteKey(double key){
        
        DoubleLink current = null;
        
        if(!isEmpty()){
            current = first;
            
            while(current.dData != key){
                current = current.next;
                if(current == null){
                    return null;
                }
            }
            
            if(current == first){
                first = current.next;
            }else{
                current.previous.next = current.next;
            }
            
            if(current == last){
                last = current.previous;
            }else{
                current.next.previous = current.previous;
            }
                        
        }else{
            System.out.println("Can't delete. List is empty");
        }
        
        return current;
            
    }
    
    public void displayForward(){
        System.out.print("List (first -->last): ");
        DoubleLink current = first;                        //start at the begining of list
        while(current != null){                     //until end of list
            current.displayLink();                  //print data
            current = current.next;                 //move to next link
        }
        System.out.println("");
    }

    public void displayBackward(){
        System.out.print("List (last -->first): ");
        DoubleLink current = last;                  //start at the end of list
        while(current != null){                     //until begining of list
            current.displayLink();                  //print data
            current = current.previous;             //move to previous link
        }
        System.out.println("");
    }
}

package structure;

import structure.node.Link;

/**
 * Implementation of a Sorted Single Linked List
 * 
 * Insertion and deletion of arbitrary items in the sorted linked list require O(N) comparisons
 * (N/2 on average) because the appropiate location must be found by stepping through the list.
 * 
 * However, the minimum value can be found, or deleted, in O(1) time because it's at the beginning
 * of the list. if an application frequently accesses the minimum item and fast insertion isn't critical
 * then a sorted linked list is an effective chioce.
 * 
 * @author George
 */
public class SortedSingleLinkedListImpl {
    
    private Link first;             //ref to the first link on list

    public SortedSingleLinkedListImpl() {
        first = null;              //no items on the list yet
    }
    
    public boolean isEmpty(){
        return (first == null);
    }
    
    public void insert(int id, double dd){     //insert in order
        Link newLink = new Link(id, dd);       // make a new link 
        Link previous = null;                  
        Link current = first;                    
        
        //until end of list or id > current
        while (current != null && id > current.iData){
            previous = current;
            current = current.next;
        }
        
        //at the begining of the list
        if(previous == null){
            first = newLink;
        }else{
            previous.next = newLink;
        }
        
        newLink.next = current;
    }
    
    public Link remove(){                    //return && delete first link
        if(!isEmpty()){
            Link temp = first;                        //save reference to link
            first = first.next;                       //delete it: first --> old next
            return temp;                              //return deleted link            
        }else{
            System.out.println("List empty. Can not delete");
        }
        
        return null;
    }
    
    public void displayList(){
        System.out.print("List (first -->last): ");
        Link current = first;                        //start at the begining of list
        while(current != null){                     //until end of list
            current.displayLink();                  //print data
            current = current.next;                 //move to next link
        }
        System.out.println("");
    }
    /**
     * Find link with given key
     * @param key
     * @return 
     */
    public Link find(int key){
        Link current = first;
        
        if(current == null){                //verify that the list is not empty
            return null;
        }
        
        while(current.iData != key){        //while not match
            if(current.next == null)        //if end of the list, didnt find it
                return null;
            else                            //not end of the list, go next
                current = current.next;            
        }
        return current;                    //found it
    }
    
    public Link delete(int key){
               
        Link current = first;
        Link previous = first;
        
        if(current == null){                //verify that the list is not empty
            return null;
        }
        
        while(current.iData != key){        //while not match
            if(current.next == null)        //if end of the list, didnt find it
                return null;
            else{                            //not end of the list, go next
                previous = current;
                current = current.next;                            
            }
        }
        
        if(current == first){               //if first link
            first = first.next;             //change first
        }else{
            previous.next = current.next;   //bypass ot
        }
        
        return current;                    
    }
    
    public Link getFirstItem(){
        return first;
    }
}

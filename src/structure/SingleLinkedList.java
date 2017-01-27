package structure;

import structure.node.Link;

/**
 * Implementation of a Single Linked List
 * @author George
 */
public class SingleLinkedList {
    
    private Link first;             //ref to the first link on list

    public SingleLinkedList() {
        first = null;              //no items on the list yet
    }
    
    public boolean isEmpty(){
        return (first == null);
    }
    
    public void insertFirst(int id, double dd){     //insert at the start of the list
        Link newLink = new Link(id, dd);
        newLink.next = first;                      //newLink --> old first
        first = newLink;                           //first --> newLink
    }
    
    public Link deleteFirst(){                    //delete first item
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

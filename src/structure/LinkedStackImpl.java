package structure;

import structure.node.Link;

/**
 * Implementation of the Stack Data structure with a Single Linked List
 * @author GeorgeLocal
 */
public class LinkedStackImpl {
    
    private SingleLinkedList list;

    public LinkedStackImpl() {
        list = new SingleLinkedList();
    }
    
    public void push(int data, double element){     //put item on top of the stack
        list.insertFirst(data, element);
    }
    
    public Link pop(){                  //take item from top of stack
        return list.deleteFirst();
    }
        
    public void peek(){
        Link first = list.getFirstItem();
        if(first == null){
          System.out.println("Stack is Empty");
        }else{
            System.out.println("Peek: {"  + first.iData +  "}");
        }
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public void displayStack(){
        System.out.println("Stack (top-->bottom): ");
        list.displayList();
    }
}

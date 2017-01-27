package structure;

/**
 * Implementation of the Stack Data structure with Array
 * @author GeorgeLocal
 */
public class StackImpl {
    
    private int maxSize;         //size of the stack array
    private long[] stackArray;
    private int top;            //top of stack

    public StackImpl(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new long[maxSize];
        top = -1;                // not items yet
    }
    
    public void push(long element){     //put item on top of the stack
        stackArray[++top] = element;    // increment top, insert item
    }
    
    public long pop(){                  //take item from top of stack
        return stackArray[top--];       //access item, decrement top
    }
    
    public long peek(){
        return stackArray[top];         //peek at top of the stack
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
    
    public boolean isFull(){
        return top == maxSize - 1;
    }
}

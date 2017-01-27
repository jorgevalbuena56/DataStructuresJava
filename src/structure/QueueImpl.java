/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

/**
 *  Implementation fo a Queue
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
public class QueueImpl {
    private int maxSize;
    private int[] array;
    private int front;
    private int rear;

    public QueueImpl(int size) {
        this.maxSize = size + 1;   //array is 1 cell larger than requested
        array = new int[maxSize];
        front = 0;
        rear = -1;
    }
    
    public void insert(int j){
        if(rear == maxSize - 1){
            rear = -1;
        }
        array[++rear] = j;
    }
    
    public int remove(){
        int temp = array[front++];
        if(front == maxSize){
            front = 0;
        }
        return temp;
    }
    
    public int peek(){  //peek at front of the queue
        return array[front];
    }
    
    public boolean isEmpty(){
        return (rear + 1 == front) || (front + maxSize -1 == rear);
    }
    
    public boolean isFull(){
        return (rear + 2 == front) || (front + maxSize -2 == rear);
    }
    
    public int size(){          //asume queue not empty
        if(rear >= front){      //contiguous sequence
            return rear - front + 1;
        }else{                  //broken sequence
            return (maxSize - front) + (rear + 1);
        }
    }
}

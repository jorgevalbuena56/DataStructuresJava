/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.node;

/**
 * Node used in the Linked List Implementation
 * 
 * @author George
 */
public class Link {
    public int iData;       //data
    public double dData;    //data
    public Link next;   //reference to the next item

    public Link(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }
    
    public void displayLink(){
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}

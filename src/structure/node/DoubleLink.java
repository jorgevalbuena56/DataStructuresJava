/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.node;

/**
 * Node used in the DoubleLinked List Implementation
 * 
 * @author George
 */
public class DoubleLink {
    public double dData;    //data
    public DoubleLink next;       //reference to the next in the list
    public DoubleLink previous;   //reference to the previous in the list

    public DoubleLink(double dData) {
        this.dData = dData;
    }
    
    public void displayLink(){
        System.out.print("{" + dData + ", " + dData + "} ");
    }
}

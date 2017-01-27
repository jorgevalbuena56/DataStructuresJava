/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import structure.StackImpl;

/**
 *
 * @author GeorgeLocal
 */
public class StackMain {
    
    public static void main(String[] args){
        StackImpl stack = new StackImpl(10);
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);
        
        while (!stack.isEmpty()) {
            long element = stack.pop();
            System.out.print(element);
            System.out.print(" ");            
        }
        
        System.out.println("");
    }
}

package algorithms;

import structure.StackImpl;

/**
 * Using the stack implementation to reverse a word
 * @author GeorgeLocal
 */
public class ReverseWordStack {
    
    public static void main(String[] args){
        String input = "onomatopeya";
        StackImpl stack = new StackImpl(input.length());
        
        System.out.println("Original word: " + input);
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            //Push every char in the stack in reverse order
            stack.push(c);
        }
        
        System.out.print("Reverse word: ");
        while(!stack.isEmpty()){
            System.out.print((char)stack.pop());
        }
        System.out.println("");
    }
}

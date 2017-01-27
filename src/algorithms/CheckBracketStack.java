/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import structure.StackImpl;

/**
 * Algoritm to check delimiters in a string
 *
 * Examples:
 *
 * c[d] correct a{b[c]d}e correct a[b{c}d]e} incorrect a{b(c) incorrect
 *
 * @author GeorgeLocal
 */
public class CheckBracketStack {

    public static void main(String[] args) {
        String input = "a{b(c]d}e";
        StackImpl stack = new StackImpl(input.length());

        System.out.println("Original word: " + input);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':           // opening symbols
                case '[':
                case '(':
                    stack.push(ch);  //  push them
                    break;
                case '}':            // closing symbols
                case ']':
                case ')':

                    if (!stack.isEmpty()) {
                        char chx = (char) stack.pop();
                        if ((chx == '}' && chx != '{')
                                || (chx == ']' && chx != '[')
                                || (chx == ')' && chx != '(')) {
                            System.out.println("Error: " + ch + " at " + i);
                        } else {
                            //prematurely empty
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        // at this point, all characters have been processed
        if(!stack.isEmpty()){
            System.out.println("Error: missing right delimiter");
        }
    }
}

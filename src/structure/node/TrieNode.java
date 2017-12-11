/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure.node;

import java.util.*;
/**
 *
 * @author valgood
 */
public class TrieNode {
    public char content; 
    public TrieNode parent;       
    //keep word sorted alphabetically
    public TreeMap<Character, TrieNode> children; 
    public boolean isEnd;

    /* Constructor */
    public TrieNode(char c) {
        children = new TreeMap<>();
        isEnd = false;
        content = c;       
    }  
}
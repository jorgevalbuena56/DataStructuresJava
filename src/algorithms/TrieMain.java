/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import structure.TrieImpl;

/**
 *
 * @author valgood
 */
public class TrieMain {
    public static void main(String[] args) {
        TrieImpl trie = new TrieImpl();
        trie.insert("hello");
        trie.insert("House");
        trie.insert("bear");
        trie.insert("automobile");
        trie.insert("airplane");
        trie.insert("allocate");
        trie.insert("allure");
        trie.insert("kotlin");
        trie.insert("quantum");
        trie.insert("zebra");
        trie.insert("xerox");
                      
        System.out.println("Searching prefix: " + trie.searchPrefix("a"));
        trie.delete("airplane");
        System.out.println("Searching prefix: " + trie.searchPrefix(""));                     
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import structure.node.TrieNode;

/**
 * This is a Java Program to implement Trie. 
 * 
 * A trie is an ordered tree data structure that is used to store a dynamic set 
 * or associative array where the keys are usually strings. 
 * Unlike a binary search tree, no node in the tree stores the key associated 
 * with that node, instead, its position in the tree defines the key with which
 * it is associated. 
 * 
 * All the descendants of a node have a common prefix of the string associated 
 * with that node, and the root is associated with the empty string. 
 * Values are normally not associated with every node, only with leaves and 
 * some inner nodes that correspond to keys of interest.
 * 
 * @author valgood
 */
public class TrieImpl {
    private final TrieNode root;

     /* Constructor */
    public TrieImpl() {
        root = new TrieNode(' '); 
    }
    
     /* Function to insert word */
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;
        TrieNode nodeParent;
        nodeParent = root;

        //cur children parent = root
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode t;
            if(children.containsKey(c)){
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                t.parent = nodeParent;
                children.put(c, t);
            }

            children = t.children;
            nodeParent = t;

            //set leaf node
            if(i == word.length() - 1) {
                t.isEnd = true;
            }
        }
    }

    /* Function to search for word. Returns true or false depending if the word
       was found or not
    */
    public boolean search(String word) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else{
                return false;
            }
        }

        return true;
    }

    /**
     * Search for the root node of the word and return a pointer to it. 
     * If the word is not there, return null
     * 
     * @param word
     * @return 
     */
    public TrieNode searchAndGetRoot(String word) {
       Map<Character, TrieNode> children = root.children;
       TrieNode t = null;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else{
                return null;
            }
        }

        return t;
    }

    /**
     * Entry point for search words that match a prefix
     * @param prefix
     * @return 
     */
    public List<String> searchPrefix(String prefix) {
        TrieNode tn = searchAndGetRoot(prefix);
        ArrayList<String> result = new ArrayList<>();
        if (tn != null) {
            return searchPrefix(tn, prefix, result);
        } else {
            return searchPrefix(root, prefix, result);
        }
    }
    
    /**
     * Recursive method to find all the words matching an specific prefix
     * 
     * @param node
     * @param prefix
     * @param currentWords
     * @return 
     */
    private ArrayList<String> searchPrefix(TrieNode node, 
                                          String prefix,
                                          ArrayList<String> currentWords) {
        if(node.isEnd) {
            TrieNode altair;
            altair = node;
            Stack<String> hstack = new Stack<>();

            while(altair != root) {
                hstack.push( Character.toString(altair.content) );
                altair = altair.parent;
            }

            StringBuilder wrd = new StringBuilder();
            while(!hstack.empty()) {
                wrd.append(hstack.pop());
            }

            currentWords.add(wrd.toString());
        }

        Set<Character> kset = node.children.keySet();
        Iterator itr = kset.iterator();
        ArrayList<Character> aloc = new ArrayList<>();

        while(itr.hasNext()) {
            Character ch = (Character)itr.next();
            aloc.add(ch);
        }

        for( int i=0;i<aloc.size();i++) {
            searchPrefix(node.children.get(aloc.get(i)), prefix, currentWords);
        }

        return currentWords;
    }
    
        /**
     * Delete word from trie.
     * @param word
     */
    public void delete(String word) {
        delete(root, word, 0);
    }

    /**
     * Returns true if parent should delete the mapping
     */
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.isEnd) {
                return false;
            }
            current.isEnd = false;
            //if current has no other mapping then return true
            return current.children.isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trienode 
        //reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.isEmpty();
        }
        return false;
    }
}
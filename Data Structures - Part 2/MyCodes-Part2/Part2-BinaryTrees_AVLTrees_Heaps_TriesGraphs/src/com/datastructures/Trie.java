package com.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private class Node{
        private char value;
        //private Node[] children = new Node[ALPHABET_SIZE];
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
        public Node[] getChildren(){
                return children.values().toArray(new Node[0]);

        }
        public Node getChild(char ch) {
            return children.get(ch);
        }

        public boolean hasChildren(){
            return !children.isEmpty();
        }

        public void removeChild(char ch){
            children.remove(ch);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word){

        var current = root;
        for (var ch : word.toCharArray()){
            //var index = ch-'a';
            if (current.children.get(ch) == null)
                current.children.put(ch, new Node(ch));
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word){
        if (word==null)
            return false;

        var current = root;
        for (var ch : word.toCharArray()){
            if (current.children.get(ch) == null)
                return false;
            current = current.children.get(ch);
        }
        return current.isEndOfWord;
    }


    public void traverse(){
        traverse(root);
    }


    private void traverse(Node root){
        //visit the root first
        //Pre-order: visit each child of the root node
        for (var child : root.getChildren())
            traverse(child);

        System.out.println(root.value);

    }

    public void remove(String word){
        if(word==null)
            return;

        remove(root, word, 0);
    }

    public void remove(Node root, String word, int index){
        //Base condition
        if(index==word.length()){
            root.isEndOfWord = false;
            return;
        }

        var ch=word.charAt(index);
        var child=root.getChild(ch);
        if (child == null)
            return;

        remove(child, word, index+1);

        if(!child.hasChildren() && !child.isEndOfWord)
            root.removeChild(ch);
    }

    public List<String> findWords(String prefix){
        List<String> words = new ArrayList<>();
        var lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, words);

        return words;

    }

    private void findWords(Node root, String prefix, List<String> words){
        if (root == null)
            return;

        if(root.isEndOfWord)
            words.add(prefix);

        for (var child : root.getChildren())
            findWords(child, prefix + child.value, words);
    }

    private Node findLastNodeOf(String prefix){
        if (prefix==null)
            return null;

        var current=root;
        for (var ch : prefix.toCharArray()){
            var child = current.getChild(ch);
            if (child==null)
                return null;
            current = child;
        }
        return current;
    }

    /*private boolean containsRecursive(Node root, String word, int index){
        //Base condition
        if (index==word.length())
            return root.isEndOfWord;

        if (root==null)
            return false;

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child==null);
            return false;

        return containsRecursive(child, word, index+1);
    }*/

    private int countWords(Node root){
        var total=0;
        if(root.isEndOfWord)
            total++;
        for (var child:root.getChildren())
            total += countWords(child);
        return total;
    }

    public static String longestCommonPrefix(String[] words){
        if (words==null)
            return "";

        var trie = new Trie();
        for (var word : words)
            trie.insert(word);

        var prefix = new StringBuffer();
        var maxChars = getShortest(words).length();
        var current= trie.root;
        while(prefix.length() < maxChars){
            var children = current.getChildren();
            if(children.length != 1)
                break;
            current = children[0];
            prefix.append(current.value);
        }

        return prefix.toString();
    }

    private static String getShortest(String[] words){
        if(words == null || words.length==0)
            return "";

        var shortest = words[0];
        for (var i = 1; i< words.length; i++){
            if (words[i].length() < shortest.length())
                shortest = words[i];
        }

        return shortest;
    }



}

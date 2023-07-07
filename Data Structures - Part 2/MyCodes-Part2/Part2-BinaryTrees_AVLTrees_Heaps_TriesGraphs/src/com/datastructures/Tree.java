package com.datastructures;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;

public class Tree {
    private class Node{
        // insert(value)
        // find(value):boolean

        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString(){
            return "Node=" + value;
        }
    }

    // Field
    private Node root;

    public void insert(int value){

        if (root==null) {
            root = new Node(value);
            return;
        }

        var current = root;

        while(true){
            if (current.value > value){
                if (current.leftChild == null){
                    current.leftChild = new Node(value);
                    break;
                }
                current = current.leftChild;
            }

            else{
                if (current.rightChild == null){
                    current.rightChild = new Node(value);
                    break;
                }
                current = current.rightChild;
            }

        }


    }

    public boolean find(int value){
        var current = root;


        while (current!=null){
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else
                return true;

        }
        return false;

    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root){
        if (root == null)
            return;

        // Root - Left - Right
        System.out.println(root);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder(){ traverseInOrder(root); }
    private void traverseInOrder(Node root){
        if (root==null)
            return; //move forward

        //Left - Root - Right
        traverseInOrder(root.leftChild);
        System.out.println(root);
        traverseInOrder(root.rightChild);

    }

    public void traversePostOrder(){traversePostOrder(root);}
    public void traversePostOrder(Node root){
        if (root==null)
            return;
        //Left - Right - Root
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root);
    }

    public int height(){ return height(root); }
    private int height(Node root){
        if (root==null)
            return -1;

        if (root.leftChild == null && root.rightChild == null)
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    // Find the minimum value in a binary search tree.
    // O(log n) because we are narrowing down our search.
    public int min(){
        if (root==null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    // O(n) because we have to traverse every node to find the min value.
    // Find the minimum value in a binary tree
    private int min(Node root){
        if (root.leftChild == null && root.rightChild == null) //isLeaf
            return root.value; //when we get to a leaf node we return the value of that node itself.

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public boolean equals(Tree other){
        if (other == null)
            return false;
        return equals(root, other.root);
    }
    private boolean equals(Node first, Node second){
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.value == second.value                     //pre order traversal: root left right
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);

        return false;
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void  swapRoot(){
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    private boolean isBinarySearchTree(Node root, int min, int max){
        //traverse the tree and check if the values are in the good range
        if(root==null)
            return true;
        if(root.value<min || root.value>max) //out of range
            return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1)
             && isBinarySearchTree(root.rightChild, root.value + 1 , max);


    }

    public ArrayList<Integer> getNodesAtDistance (int distance){
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);
        return list;

    }
    private void getNodesAtDistance (Node root, int distance, ArrayList<Integer> list){
        if (root==null)
            return;

        if (distance==0){
            list.add(root.value);
            return;
        }
        // Recursively traverse the tree by looking at the left and right child
        getNodesAtDistance(root.leftChild, distance-1, list);
        getNodesAtDistance(root.rightChild, distance-1, list);

    }

    //Once we get the height of the tree, we can print each node at each level

    public ArrayList<Integer> traverseLevelOrder(){
        ArrayList<Integer> result = new ArrayList<>();

        for (var i=0; i<=height(root); i++){
            var list = getNodesAtDistance(i);
            for (var value : list)
                result.add(value);
        }
        return result;
    }

    public int size(){
        return size(root);
    }
    private int size(Node root){
        if (root==null)
            return 0;
        if (root.leftChild == null && root.rightChild == null) //isLeaf
            return 1;
        return 1 + size(root.leftChild) + size(root.rightChild);

    }


    public int countLeaves(){
          return countLeaves(root);
    }
    private int countLeaves(Node root){
        if (root.leftChild == null && root.rightChild == null) //isLeaf
            return 1;
        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public int max(){return max(root);}
    private int max(Node root){
        // As it is a binary search tree, the rightmost element of the tree is the maximum.
        if (root.rightChild==null)
            return root.value;
        return max(root.rightChild);
    }

    public boolean contains(int value){
        return contains(value, root);
    }
    private boolean contains(int value, Node root){
     if (root==null)
         return false;

     if (root.value==value)
         return true;

     return contains(value, root.leftChild) || contains(value, root.rightChild);


    }

    public boolean areSibling(int first, int second){
        return areSibling(root, first, second);
    }
    private boolean areSibling(Node root, int first, int second){
        if (root==null)
            return false;

        var areSibling = false;
        if(root.leftChild != null && root.rightChild != null){
            areSibling = (root.leftChild.value == first && root.rightChild.value == second) ||
                    (root.rightChild.value == first && root.leftChild.value == second);
        }

        return areSibling ||
                areSibling(root.leftChild, first, second) ||
                areSibling(root.rightChild, first, second);

    }

    public ArrayList<Integer> getAncestors(int value){
        var list = new ArrayList<Integer>();
        getAncestors(root, value, list);
        return list;
    }
    private boolean getAncestors(Node root, int value, ArrayList<Integer> list){

        if (root==null)
            return false;
        if (root.value == value)
            return true;

        if (getAncestors(root.leftChild, value, list) || getAncestors(root.rightChild, value, list)){
           list.add(root.value);
            return true;
        }
        return false;
    }


    private boolean isBalanced(Node root){
        if (root == null)
            return true;

        var balanceFactor = height(root.leftChild) - height(root.rightChild);

        if (Math.abs(balanceFactor) <= 1 && isBalanced(root.leftChild)&& isBalanced(root.rightChild))
            return true;
        return false;
    }

    // number of nodes in function of the height = 2^(h+1)-1.
    public boolean isPerfect(){
        return size() == (Math.pow(2, height() + 1) - 1);
    }

}

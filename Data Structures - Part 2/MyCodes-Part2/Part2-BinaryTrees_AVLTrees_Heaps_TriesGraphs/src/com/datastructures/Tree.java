package com.datastructures;

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


}

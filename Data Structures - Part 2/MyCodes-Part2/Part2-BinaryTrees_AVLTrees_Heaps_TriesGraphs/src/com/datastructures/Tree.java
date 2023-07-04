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



}

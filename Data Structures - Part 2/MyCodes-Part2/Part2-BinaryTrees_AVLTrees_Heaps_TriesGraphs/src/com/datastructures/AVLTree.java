package com.datastructures;

import javax.management.ValueExp;

public class AVLTree {
    private class AVLNode{
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int height;

        public AVLNode(int value){this.value = value;}

        @Override
        public String toString(){
            return "Value=" + this.value;
        }

    }

    private AVLNode root;

    public void insert(int value){
        root = insert(root, value);
    }
    private AVLNode insert(AVLNode root, int value){
        if (root==null)
            return new AVLNode(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);

        setHeight(root);

        // balanceFactor = height(L) - height(R)
        // >1 => left heavy
        // <1 => right heavy
        root = balance(root);

        return root;
    }

    private AVLNode rotateLeft(AVLNode root){
        var newRoot = root.rightChild;
        //perform the rotation
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        //reset the height of the root and the newRoot
        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root){
        var newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node){
        root.height = Math.max(
                height(root.leftChild),
                height(root.rightChild)) + 1;
    }



    private AVLNode balance (AVLNode root){
        if (isLeftHeavy(root)){
            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        }

        else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root.leftChild);
        }
        return root;

    }

    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node){
        return (balanceFactor(node) < -1);
    }

    private int balanceFactor(AVLNode node){
        return (node == null) ? -1 : node.height;
    }


    private int height(AVLNode node){
        if (node == null)
            return -1;
        return node.height;
    }








}

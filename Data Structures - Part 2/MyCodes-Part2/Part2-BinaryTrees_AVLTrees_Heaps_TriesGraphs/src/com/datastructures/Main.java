package com.datastructures;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {

        // Building a Tree

        /*Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        tree.find(10);

        Tree tree2 = new Tree();
        tree2.insert(7);
        tree2.insert(4);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        tree2.find(10);*/

        // Tree Traversals
         /*Breadth First (Level order traversal)
         Depth First
           - Pre-order: Root, Left, Right
           - In-order:  Left, Root, Right
           - Post-order:Left, Right, Root*/

        // n! = n x (n-1)!
        //System.out.println(factorial(4));

            // f(3)
            //   3 x f(2)
            //         2 x f(1)
            //               1 x f(0)


        /*public static int factorial(int n){
            // Base condition
            if (n==0)
                return 1;

            return n * factorial(n-1);
        }*/

        // Tree traversals
        // tree.traversePreOrder();
        // tree.traverseInOrder();
        //tree.traversePostOrder();
        //System.out.println(tree.height());
        //System.out.println(tree.min());

        // Interview question
        //System.out.println(tree.equals(null));
        //tree.swapRoot();
        //System.out.println(tree.isBinarySearchTree());

        // Interview question - Print the nodes at a K distance from the root.
        // Break the problem down such that eventually the distance becomes 0
        //var list = tree.getNodesAtDistance(1);
        //System.out.println(list);
        //System.out.println(tree.traverseLevelOrder());
        /*System.out.println(tree.size());
        System.out.println(tree.countLeaves());
        System.out.println(tree.contains(-1));
        System.out.println(tree.getAncestors(8));*/

        // AVL Trees
        /*var tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);*/

        var heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
        System.out.println(heap.remove());
        System.out.println("Done");



    }




}
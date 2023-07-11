package com.datastructures;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

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
        /*heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);
        System.out.println(heap.remove());
        System.out.println("Done");*/
        // Heap Sort
        int[] numbers = {5, 3, 8, 4, 1, 2};
        /*for (var number: numbers)
            heap.insert(number);
        // for (var i=0; i<numbers.length; i++)   //sorts the array in descending order.
        for (var i=numbers.length -1 ; i>= 0; i--) //sorts the array in ascending order.
            numbers[i] = heap.remove();
        System.out.println(Arrays.toString(numbers));*/


        //Priority queues

        // Heapify = transforming an array to an heap in place
        //loop main loop
        // if a number is less than equal to one of its children, I bubble it down.

        //MaxHeap.heapify(numbers);
        //System.out.println(Arrays.toString(numbers));*/

        // Kth Largest Item
        //System.out.println(MaxHeap.getKthLargest(numbers,3));
        //System.out.println(Heap.isMaxHeap(numbers));

        // Tries
        /*var trie = new Trie();
        trie.insert("car");
        trie.insert("care");
        trie.insert("card");
        trie.insert("careful");
        trie.insert("egg");
        //System.out.println(trie.contains(null));
        System.out.println(trie.contains("car"));
        System.out.println(trie.contains(""care"));
        System.out.println(trie.findWords("care"));
        String str = "car";
        System.out.println();*/

        var graph = new Graph();
        /*graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.addEdge("A", "C");
        graph.traverseBreadthFirst("C");*/

        // Topological Sort
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("X");
        graph.addNode("P");
        graph.addEdge("X", "A");
        graph.addEdge("A", "P");
        graph.addEdge("X", "B");
        graph.addEdge("B", "P");
        graph.addEdge("A", "B");

        System.out.println(graph.hasCycle());





    }




}
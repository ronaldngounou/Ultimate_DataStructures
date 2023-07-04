package com.datastructures;

import java.util.*;
import java.util.Stack;

public class Main {
    public static void main( String[] args){

        /*int [] numbers = new int[3];
        numbers[0] = 10;
        int [] num = {3, 4, 7};

        System.out.println(Arrays.toString(numbers));
        System.out.println(num.length);*/
        // Linked Lists
        /*Array numbers = new Array(3);
        numbers.insert(10);
        numbers.insert(40);
        numbers.insert(50);
        numbers.insert(20);

        //System.out.println(numbers.indexOf(44));

        Array others = new Array(3);
        others.insert(10);
        others.insert(20);
        others.insert(30);

        Array common = new Array(3);
        common = numbers.intersect(others);
        common.print();

        //System.out.println("others");
        others.print();
        //System.out.println("others reversed");
        others.reverse();
        others.print();


        // LinkedList
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);

//        System.out.println(list.indexOf(30));
//        System.out.println(list.contains(55));
//        System.out.println(list.size());
//        list.removeFisrt();
//        System.out.println(list.size());
        //list.reverse();
        System.out.println("middle of the list:");
        list.printMiddle();
        var array = list.toArray();
        System.out.println(Arrays.toString(array));

        // Find the Kth node from the end of linked list in one pass.
        // [10 -> 20 -> 30 -> 40 -> 50]
        //               *           *
        // K = 1 (50)
        // K = 2 (40)
        // K = 3 (30)  (distance = 2) = k-1
        System.out.println(list.getKthFromTheEnd(2));

        System.out.println(list.hasLoop());*/

        // Stacks
        /*Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        var top = stack.pop(); //removes the item on the top
        System.out.println(stack);
        top = stack.peek();
        System.out.println(top);*/

        // Write a code to reverse this string. Stacks are useful when I have to do something in reverse or going back.


        // StringReverser reverser = new StringReverser();
        /*var result = reverser.reverse(null);
        System.out.println(result);*/

        // Check if an expression is balanced.
        /*String str = "(1+3]";
         Edge cases
         (
         (()
         ) (
        Expression expression = new Expression();
        System.out.println((expression.isBalanced(str)));*/

        /*Stack stack = new Stack();
        stack.push(5);
        stack.push(45);
        stack.push(35);
        stack.push(55);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);*/

        // TwoStacks

        /*TwoStacks twostacks = new TwoStacks(9);
        twostacks.push1(1);
        twostacks.push1(2);
        twostacks.push1(3);
        twostacks.push2(7);
        twostacks.push2(8);
        twostacks.push2(9);


        //System.out.println(twostacks.pop1());
        System.out.println(twostacks.pop2());
        System.out.println(twostacks.pop2());
        System.out.println(twostacks.isEmpty2());
        System.out.println(twostacks);*/

        // MinStack

        /*MinStack minstack = new MinStack();
        minstack.push(3);
        minstack.push(6);
        minstack.push(9);

        System.out.println(minstack);*/

        // Intro queues
        /* Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30); */
        // Reversing a queue - Popular interview question.

        /*Queues.reverse(queue);
        System.out.println(queue);*/

        // Popular interview question - Implement a queue using an array to store the items.
        /*ArrayQueue queue = new ArrayQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        System.out.println(queue);
        queue.dequeue();
        queue.enqueue(80);
        queue.enqueue(90);*/

        // Building a queue using two stacks

        /* QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.dequeue();
        var first = queue.dequeue();
        System.out.println(first);*/

        /*PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(5);
        queue.add(1);
        queue.add(3);
        queue.add(2);
        while (!queue.isEmpty())
            System.out.println(queue.remove());*/

        // Building a priority queue using an array
        /*PriorityQueue pQueue = new PriorityQueue();
        pQueue.add(5);
        pQueue.add(3);
        pQueue.add(8);
        pQueue.add(1);
        pQueue.add(4);
        System.out.println(pQueue);

        while(!pQueue.isEmpty())
            System.out.println(pQueue.remove()); //remove the items by their priority order

    }*/

        // QueueReverser
        /*Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        QueueReverser.reverse(queue,3);
        System.out.println(queue);*/

        //StacksWithTwoQueues
        /* StackWithTwoQueues stack = new StackWithTwoQueues();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.peek()); */

        // Working with HashMaps
        // Key: Employee Number (Integer)
        // Value: Name (String)
        /* Map<Integer, String> map = new HashMap<>(); //Map is an interface and HashMap is an implementation of that interface
        map.put(1, "John");
        map.put(2, "Marie");
        map.put(3, "Luc");
        map.put(3, "Marianne");
        map.put(null, null); // INTERVIEW: They often ask if hashmaps allow both null key value pairs - the answer is yes.
        map.remove(null);
        var value = map.get(3);
        map.containsKey(3); // O(1) because the hashmap can rely on his hash function to loop up to the item.
        map.containsValue("Luc");

        for (var item : map.keySet()) // keySet and entrySet returns a list of K V
            System.out.println(map.get(item));*/

        // Popular interview question - First Non-repeated Character
        /* String str = "a green apple";
        CharFinder charFinder = new CharFinder();
        System.out.println(charFinder.findFirstNonRepeatingChar(str)); */

        // Maps: k -> v
        // Sets: k     Don't allow duplicates keys
        /*Set<Integer> set = new HashSet<>();
        int[] numbers = {1, 2, 2, 3, 3, 2, 1, 5, 4};
        for (var number : numbers)
            set.add(number);
        System.out.println(set);*/

        // Popular interview question - Find the first repeated character in a string
        /*CharFinder finder = new CharFinder();
        finder.findFirstRepeatedChar("a green apple");*/

        // Hash functions
        // items[1] = "Mosh"
        // 100
        // 0-99
        /*Map<String, String> map = new HashMap<>();
        map.put("123456-A", "Mosh");
        System.out.println(hash("123456-A"));*/

        // Implement a hash table to store key value pairs. Collisions should be solved using chaining.
        /*HashTable table = new HashTable();
        table.put(6,"A"); //remainder=1
        table.put(8, "B"); //remainder=3
        table.put(11, "C"); //remainder=11%5=1
        table.put(11, "C+");
        System.out.println(table.get(11));
        table.remove(16);
        System.out.println("Done");*/

        // Most Frequent Character in an array
        HashTableExercises hash = new HashTableExercises();
        int[] array = {2, 7, 11, 15};
        //System.out.println("The most frequent number is " + hash.mostFrequent(array));

        //System.out.println(hash.countPairsWithDiff(array, 2));
        int[] result = hash.twoSum(array, 9);

        System.out.println(Arrays.toString(result));

    }

}

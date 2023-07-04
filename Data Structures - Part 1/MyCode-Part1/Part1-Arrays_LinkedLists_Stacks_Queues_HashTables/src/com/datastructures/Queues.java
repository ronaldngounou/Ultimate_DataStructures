package com.datastructures;

import java.util.Queue;
import java.util.Stack;

public class Queues {

    public static void reverse(Queue<Integer> queue){
        // add
        // remove
        // isEmpty

        // Q [10, 20, 30]
        // S [10, 20, 30]

        //1. Remove the items at the front of the queue and add them in a stack
        //2. Pop the elements in the stack and add them in the same queue.

        Stack<Integer> stack = new Stack<>();

        while(!queue.isEmpty())
            stack.push(queue.remove());

        while(!stack.isEmpty())
            queue.add(stack.pop());

    }


}

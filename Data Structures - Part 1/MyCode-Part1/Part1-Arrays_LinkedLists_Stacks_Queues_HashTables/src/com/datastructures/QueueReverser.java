package com.datastructures;

import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

    public static void reverse(Queue<Integer> queue, int K){
        // Q = [10, 20, 30, 40, 50], K = 3
        // loop over K, remove the item at the begin of the queue
        // S1 = [10, 20, 30]
        // while S1 is not empty, remove the items in S1 and add them in S2
        // S2 = [30, 20, 10]
        // push from K=4 in S4

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<K; i++)
            stack.push(queue.remove());


        while(!stack.isEmpty())
            queue.add(stack.pop());
            // I can add the elements in the same queue directly because we have 0 at the empty positions

        for (int i=0; i< queue.size() - K; i++)
            queue.add(queue.remove());
    }

}

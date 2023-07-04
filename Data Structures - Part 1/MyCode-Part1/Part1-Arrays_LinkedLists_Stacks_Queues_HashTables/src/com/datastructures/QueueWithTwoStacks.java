package com.datastructures;

import java.util.Stack;


public class QueueWithTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    // O(1)
    public void enqueue(int item){
        stack1.push(item);
    }

    // O(n)
    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException();

        if (stack2.empty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        return stack2.pop();
    }

    public boolean isEmpty(){
        return stack1.empty() && stack2.empty();
    }

    public int peek(){
        if (isEmpty())
            throw new IllegalStateException();

        if (stack2.empty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        return stack2.peek();
    }


}

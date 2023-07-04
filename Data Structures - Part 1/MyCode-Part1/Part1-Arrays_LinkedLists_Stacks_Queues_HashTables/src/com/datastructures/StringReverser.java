package com.datastructures;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input){
        if (input==null)
            throw new IllegalArgumentException();

        //1. Create a stack to hold each character
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray())
            stack.push(ch);

        //2. Pop each character. They will come in reverse order.
        StringBuffer reversed = new StringBuffer();
        while (!stack.empty())
            reversed.append(stack.pop());

        return reversed.toString();

    }
}

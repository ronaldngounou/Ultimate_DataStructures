package com.datastructures;

import java.util.Arrays;

public class TwoStacks {
    private int count1;
    private int count2;
    private int[] items;

    public TwoStacks(int capacity){
        if (capacity<=0)
            throw new IllegalArgumentException("Capacity must be 1 or greater.");

        items = new int[capacity];
        count1 = -1;
        count2 = capacity;
    }

    public void push1(int item){
        if (isFull1())
            throw new IllegalStateException("Stack1 is full.");
        //count1++;
        items[++count1] = item;
    }

    public void push2(int item){
        if (isFull2())
            throw new IllegalStateException("Stack2 is full.");

        items[--count2] = item;
    }

    public int pop1(){
        if (isEmpty1())
            throw new IllegalStateException();
        return items[count1--];
    }

    public int pop2(){
        if (isEmpty2())
            throw new IllegalStateException();
        return items[count2++];
    }

    public boolean isEmpty1(){
        if (count1 != -1)
            return false;
        return true;
    }

    public boolean isEmpty2(){
        if (count2!=items.length)
            return false;
        return true;
    }

    public boolean isFull1(){
        return count1+1 == count2;
    }

    public boolean isFull2(){
        return count2-1 == count1;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

}

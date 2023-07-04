package com.datastructures;

import java.util.Arrays;

public class PriorityQueue {
    // insert (2)
    // [1, 3, 5, 7]
    //  0  1  2  3
    //           ^
    // iterate from the back.
    // items[i+1] = items[i]

    private int[] items = new int[5];
    private int count; //number of items in the queue

    public void add(int item){
        if (count==items.length)
            throw new IllegalStateException();

        //Shifting items
        int i;
        for(i=count-1; i>=0; i--){ //Tip: iterate the array fron the end so we don't loose elements.
            if (items[i] > item)
                items[i+1] = items[i];
            else
                break;
        }
        items[i+1] = item;
        count++;
    }

    public int remove(){
        if (isEmpty())
            throw new IllegalStateException();

        return items[--count];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }


}

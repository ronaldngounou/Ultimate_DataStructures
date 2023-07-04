package com.datastructures;

import java.util.Arrays;

public class ArrayQueue {
    //enqueue
    //dequeue
    //peek
    //isEmpty
    //isFull
    // [10, 20, 30, 40, 50]
    //  F

    private int[] items = new int[5];
    /*public ArrayQueue(int capacity){
        items = new int[capacity];
    }*/

    private int count = 0; //keep track number of items in the queue.
    private int front = 0;
    private int rear = 0;

    public void enqueue(int item){
        if (isFull())
            throw new IllegalStateException("Queue is full.");
        items[rear] = item;
        rear = (rear+1) % items.length;
        count++;
    }

    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException("Queue is empty.");
        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count --;
        return item;
    }

    public int peek(){
        if (isEmpty())
            throw new IllegalStateException("Queue is empty.");
        return items[front];
    }

    private boolean isEmpty(){
        return count==0;
    }

    private boolean isFull(){
        return count == items.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);

    }

    // Circular Arrays
    // We have some space at the front of the queue becaue we removed items.
    // 5 -> 0
    // 6 -> 1
    // 7 -> 2
    // 8 -> 3
    // 9 -> 4
    //10 -> 0
    //11 -> 1
    // (rear + 1) % length

}

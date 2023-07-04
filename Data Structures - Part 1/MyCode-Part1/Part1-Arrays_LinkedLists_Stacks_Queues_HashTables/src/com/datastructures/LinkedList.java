package com.datastructures;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    // Fields
    private Node head;
    private Node tail;
    private int size;

    public void addLast(int item){
        var node = new Node(item);

        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;

    }

    public void addFirst(int item){
        var node = new Node(item);

        if (head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head = node;
        }
        size++;
    }

    public int indexOf(int item){
        int index = 0;
        var current = head;
        while(current!=null){
            if (current.value == item)
                return index;
            else{
                current = current.next;
                index++;
            }
        }
        return -1;
    }

    public boolean contains(int item){
        var current = head;
        while(current!=null){
            if (current.value == item)
                return true;
            current = current.next;
        }
        return false;
    }

    public void removeFisrt(){
        //[10 -> 20 -> 30]
        if (head == null)
            throw new NoSuchElementException();

        if (head == tail){
            head = tail = null;
            return;
        }
        var second = head.next; //create a second variable to point to the second node
        head.next = null; //set the node after the head to be null
        head = second;

        size --;
    }

    public void removeLast(){
        // [10 -> 20 -> 30]
        if (head==null)
            throw new NoSuchElementException();

        if (head==tail){
            head = null;
            tail = null;
        }else{
            var previous = getPrevious(tail);
            tail = previous;
            tail.next = null;
        }
        size--;

    }

    private Node getPrevious(Node node){
        var current = head;
        while (current != null){
            if (current.next == tail) break;
            current = current.next;
        }
        return null;
    }

    private int count =1 ;
    public int size(){
        var current = head;

        while (current.next != null){
            count ++;
            current = current.next;
        }
        return count;
    }

    public int[] toArray(){
        int[] array = new int[size];
        var current = head;
        var index = 0;
        while(current != null){
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse(){
        // [10 -> 20 -> 30]
        // p  <-  c     n
        // [10 <- 20 <- 30]

        var previous = head;
        var current = head.next;

        while(current !=null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        tail = head;
        tail.next = null;
        head = previous;

    }

    public int getKthFromTheEnd( int k){
        // 1. Move the second pointer forward until it is at the right distance from the first pointer
        // 2. Move both of them forward until the second pointer is at the end of the linked list
        // 3. Return the value of the first pointer.

        if (head==null) // If the list is empty
            throw new IllegalStateException();

        var first_pointer = head;
        var second_pointer = head;

        for (int i=0; i<k-1; i++) {//k-1 because the pointers are separated k-1 number of nodes.
            second_pointer = second_pointer.next;
            if (second_pointer == null){
                throw new IllegalArgumentException();
            }
        }
        while(second_pointer != tail){ //move both pointers until the second pointer reaches the last node.
            first_pointer = first_pointer.next;
            second_pointer = second_pointer.next;
        }
        return first_pointer.value;

    }

    public void printMiddle(){
        var first_pointer = head;
        var second_pointer = head;

        if (head==null)
            throw new IllegalStateException();

        while(second_pointer != tail && second_pointer.next != tail){
            second_pointer = second_pointer.next.next;
            first_pointer = first_pointer.next;
        }
        if (second_pointer == tail)
            System.out.println(first_pointer.value);
        else
            System.out.println(first_pointer.value + "," + first_pointer.next.value);
    }

    public boolean hasLoop(){
        var slow = head;
        var fast = head;

        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }




}

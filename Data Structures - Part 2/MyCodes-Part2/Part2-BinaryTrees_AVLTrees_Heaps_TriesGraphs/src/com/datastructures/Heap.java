package com.datastructures;

import javax.xml.xpath.XPathEvaluationResult;
import java.util.ArrayList;

public class Heap {
    private int[] items = new int[10];
    private int size;

    public static boolean isMaxHeap(int[] array){ return isMaxHeap(array,0);}

    private static boolean isMaxHeap(int[] array, int index){
        //All leaf nodes are valid
        var lastParentIndex = (array.length - 2)/2;
        if (index>lastParentIndex)
            return true;

        var leftChildIndex = index * 2 +1;
        var rightChildIndex = index *2+2;

        /*var isValidParent=false;
        if(array[index] >= array[leftChildIndex] && array[index] >= array[rightChildIndex])
            isValidParent = true;
        if(isValidParent && isMaxHeap(array, leftChildIndex) && isMaxHeap(array, rightChildIndex))
            return true;

        return false;*/

        var isValidParent =
                array[index] >= array[leftChildIndex] &&
                array[index] >= array[rightChildIndex];

        return isValidParent &&
                isMaxHeap(array, leftChildIndex) &&
                isMaxHeap(array, rightChildIndex);
    }

    public int max(){
        if (size==0)
            throw new IllegalStateException();

        return items[0];
    }

    public void insert(int value){
        if(size == items.length)
            throw new IllegalStateException();

        items[size++] = value;

        //Bubble up: newItem > parent
        bubbleUp();

    }

    public int remove(){
        if (isEmpty())
            throw new IllegalStateException();

        var root = items[0];
        items[0] = items[--size];

        // item(root) < children
        bubbleDown();

        return root;

    }

    public boolean isEmpty(){ return (size==0);}

    private void bubbleDown(){
        var index = 0;
        while (index <=size && !isValidParent(index)) {
            var largerChildIndex = largerChildindex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private boolean hasLeftChild(int index){
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index){
        return rightChildIndex(index) <= size;
    }

    private int largerChildindex(int index){
        if (!hasLeftChild(index))
            return index;
        if(!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index) > rightChild(index)) ?
                leftChildIndex(index) :
                rightChildIndex(index);

    }

    private boolean isValidParent(int index){
        if(!hasLeftChild(index))
            return true;

        if(!hasRightChild(index))
            return items[index] >= leftChild(index);


        return items[index] >= leftChild(index)  &&
                items[index] >= rightChild(index);
    }

    private int rightChild(int index){return items[rightChildIndex(index)];}

    private int leftChild(int index){return items[leftChildIndex(index)];}

    private int leftChildIndex(int index){ return index * 2 + 1;}

    private int rightChildIndex(int index){ return index * 2 + 2;}

    private void bubbleUp(){
        var index = size - 1;
        while(index > 0 && items[index] > items[parent(index)]){
            swap(index, parent(index));
            index=parent(index);
        }
    }

    private int parent(int index){
        return (index-1)/2;
    }

    private void swap(int first, int second){
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }
}

package com.datastructures;

public class MaxHeap {

    public static void heapify(int[] array){
        var lastParentIndex = array.length / 2 - 1;
        for (var i=lastParentIndex; i >=0; i--)
            heapify(array, i);

    }

    private static void heapify(int[] array, int index){
        //check if an item is larger than its children. If it's larger, swap it with its larger child.
        var largerIndex = index;

        var leftIndex = index * 2 + 1;

        if (leftIndex < array.length &&
                array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;


        var rightIndex = index * 2 + 2;
        if (rightIndex < array.length &&
                array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;


        if (index == largerIndex)
            return;

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void swap(int[] array, int first, int second){
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    // In a max heap, the root node is the maximum value. To find the largest value, we have to
    // remove the root node twice and this will give us the largest value.

    public static int getKthLargest(int[] array, int K){
        if (K<1 || K>array.length)
            throw new IllegalStateException();

        var heap = new Heap();
        for (var number : array)
            heap.insert(number);

        for (var i=0; i<K-1; i++)
            heap.remove();

        return heap.max();
    }

}

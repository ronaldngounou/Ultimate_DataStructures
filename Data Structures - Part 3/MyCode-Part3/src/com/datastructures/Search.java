package com.datastructures;

import java.util.Arrays;

public class Search {
    public int linearSearch(int[] array, int target){

        for (int i=0; i < array.length; i++)
            if (array[i] == target)
                return i;

        return -1;
    }

    public int binarySearchRec(int[] array, int target){
        return binarySearchRec(array, target, 0, array.length - 1);
    }

    //the array should already be sorted.
    private int binarySearchRec(int[] array, int target, int left, int right){
        //Base condition
        if (right < left)
            return -1;

        var middle = (left + right) / 2;
        if (array[middle] == target)
            return middle;

        if (target < array[middle])
            return binarySearchRec(array, target, left, middle - 1);
        else
            return binarySearchRec(array, target, middle + 1, right);
    }

    public int binarySearch(int[] array, int target){
        var left = 0;
        var right = array.length - 1;

        while (left <= right){
            var middle = (left + right) / 2;

            if (array[middle] == target)
               return middle;

            if (target < array[middle])
                right = middle - 1;
            else
                left = middle + 1;
        }

        return -1;
    }

    public int ternarySearch(int[] array, int target){
        return ternarySearch(array, target, 0 , array.length - 1);
    }

    private int ternarySearch(int[] array, int target, int left, int right){

        int partitionSize = (right - left) / 3;
        int mid1 = left + partitionSize;
        int mid2 = right - partitionSize;

        //Base condition
        if (left > right)
            return -1;

        if (target == array[mid1])
            return mid1;

        if (target == array[mid2])
            return mid2;

        if (target < array[mid1])
            return ternarySearch(array, target, left, mid1 -1);

        if (target > array[mid2])
            return ternarySearch(array, target, mid2 + 1, right);


        return ternarySearch(array, target, mid1 + 1, mid2 - 1);

    }


    public int jumpSearch(int[] array, int target){
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = blockSize;

        while(array[next - 1] < target){
            start = next;
            if (start >= array.length)
                break;

            next += blockSize;
            if (next > array.length)
                next = array.length;
        }

        //linear search on the block
        for (int i = start; i < next; i++)
            if (array[i] == target)
                return i;

        return -1;

    }

    public int exponentialSearch(int[] array, int target){
        int bound = 1;

        while(bound <array.length && array[bound] < target)
            bound *= 2;

        int left = bound;
        int right = Math.min(bound, array.length);
        return binarySearchRec(array, target, left, right);
    }




}

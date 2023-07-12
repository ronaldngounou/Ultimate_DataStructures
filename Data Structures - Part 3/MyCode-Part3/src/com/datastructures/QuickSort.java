package com.datastructures;

public class QuickSort {
    public void sort(int[] array){
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end){
        //Base condition
        if(start >= end) //single item array
            return;
        // Partition
        var boundary = partition(array, start, end);
        // Sort left
        sort(array, start, boundary - 1);
        // Sort right
        sort(array, boundary + 1, end);
    }

    //return the index of the pivot after it is moved to the current position
    private int partition(int[] array, int start, int end) {
        var pivot = array[end];
        var boundary = start - 1;

        for (var i = start; i <= end; i++){
            if (array[i] <= pivot){
                boundary++;
                var temp = array[i];
                array[i] = array[boundary];
                array[boundary] = temp;
                
            }
        }

        return boundary;

    }

}

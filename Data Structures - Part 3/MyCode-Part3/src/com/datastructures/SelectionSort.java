package com.datastructures;

public class SelectionSort {
    public void sort(int[] array){
        for (var i = 0; i<array.length; i++){
            var minIndex = i;
            for (var j = i; j<array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }
            var temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

        }

    }
    
}



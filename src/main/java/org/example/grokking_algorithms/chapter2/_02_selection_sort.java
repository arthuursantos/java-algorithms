package org.example.grokking_algorithms.chapter2;

import java.util.Arrays;

public class _02_selection_sort {

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minElementIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            if (minElementIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minElementIndex];
                arr[minElementIndex] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {0, 23, 1, 5, 18, 71, 2};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

}

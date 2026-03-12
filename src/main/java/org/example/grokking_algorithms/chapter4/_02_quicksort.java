package org.example.grokking_algorithms.chapter4;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _02_quicksort {

    public static int[] quicksort(int[] arr) {
        if (arr.length <= 1) return arr;
        int pivot = arr[0];
        int[] greater = Arrays.stream(arr)
                .filter(n -> n > pivot)
                .toArray();
        int[] less = Arrays.stream(arr)
                .filter(n -> n < pivot)
                .toArray();
        return IntStream.concat(
                IntStream.concat(
                        Arrays.stream(quicksort(less)),
                        IntStream.of(pivot)),
                Arrays.stream(quicksort(greater))
        ).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {49, 2, 12, 44, 23, 1, 29, 98};
        System.out.println(Arrays.toString(quicksort(arr)));
    }

}

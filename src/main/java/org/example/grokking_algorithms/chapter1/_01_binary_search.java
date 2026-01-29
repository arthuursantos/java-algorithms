package org.example.grokking_algorithms.chapter1;

public class _01_binary_search {

    public static Integer binarySearch(int[] arr, int n) {
        int low  = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low+high) / 2;
            if (arr[mid] < n) {
                low = arr[mid] + 1;
            } else if (arr[mid] > n) {
                high = arr[mid] - 1;
            } else {
                return mid;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 10, 28, 29, 87, 92};
        System.out.println(binarySearch(arr, 28));
    }

}

// 1.1 Suppose you have a sorted list of 128 names, and you’re searching
// through it using binary search. What’s the maximum number of
// steps it would take?
// ... 7 steps. log2 128 = 7

// 1.2 Suppose you double the size of the list. What’s the maximum
// number of steps now?
// ... 8 steps
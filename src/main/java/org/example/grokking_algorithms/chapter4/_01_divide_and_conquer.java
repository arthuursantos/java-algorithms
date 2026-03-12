package org.example.grokking_algorithms.chapter4;

public class _01_divide_and_conquer {

    // 4.1 Write out the code for the earlier sum function.
    public static int recursiveSum(int[] arr, int i) {
        if (i == arr.length) return 0;
        return arr[i] + recursiveSum(arr, i + 1);
    }

    // 4.2 Write a recursive function to count the number of items in a
    // list.
    public static int recursiveCount(int[] arr, int i) {
        if (i == arr.length) return 0;
        return 1 + recursiveCount(arr, i + 1);
    }

    // 4.3 Write a recursive function to find the maximum number in a list.
    public static int recursiveFindBiggest(int[] arr, int i) {
        if (i == arr.length - 1) return arr[i];
        return Math.max(arr[i], recursiveFindBiggest(arr, i + 1));
    }

    // 4.4 Remember binary search from chapter 1? It’s a D&C algorithm,
    // too. Can you come up with the base case and recursive case for
    // binary search?
    public static int recursiveBinarySearch(int[] arr, int n, int high, int low) {
        int mid = (high + low) / 2;
        if (low>high) return -1;
        if (arr[mid] == n) return mid;
        if (arr[mid] > n) {
            high = mid - 1;
        } else low = mid + 1;
        return recursiveBinarySearch(arr, n, high, low);
    }


    public static void main(String[] args) {
        int[] arr = {3, 23, 28, 43, 87, 102};
        System.out.println(recursiveBinarySearch(arr, 87, arr.length - 1, 0));
    }

}

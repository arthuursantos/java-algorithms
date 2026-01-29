package org.example.leetcode.easy;

import java.util.Arrays;

public class p1480 {

//    public static int[] runningSum(int[] nums) {
//        int[] arraySum = new int [nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = 0; j <= i; j++) {
//                sum += nums[j];
//            }
//            arraySum[i] = sum;
//        }
//        return arraySum;
//    }

    public static int[] runningSum(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            output[i] = nums[i] + output[i-1];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] n = {3, 1, 2, 10, 1};
        Arrays.stream(runningSum(n))
                .forEach(System.out::println);
    }
}

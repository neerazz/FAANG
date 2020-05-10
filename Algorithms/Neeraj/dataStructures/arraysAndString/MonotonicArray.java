/*
    Created on:  May 09, 2020
 */

/**
 * Questions: https://www.algoexpert.io/questions/Monotonic%20Array
 * Monotonic Array
 * Write a function that takes in an array of integers and returns a boolean representing whether the array is monotonic.
 * An array is said to be monotonic if its elements, from left to right, are entirely non-increasing or entirely non-decreasing.
 * Sample Input
 * array = [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]
 * Sample Output
 * true
 */
public class MonotonicArray {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001}));
        System.out.println(isMonotonic_elegent(new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001}));
    }

//    Time: N, Space: 1
    public static boolean isMonotonic_elegent(int[] array) {
        if (array.length < 2) return true;
        boolean nonIncreasing = true, nonDecreasing = true;
        int pre = array[0];
        for (int i = 1; i < array.length; i++) {
            int cur = array[i];
            nonIncreasing = nonIncreasing && pre >= cur;
            nonDecreasing = nonDecreasing && cur >= pre;
            if (!nonIncreasing && !nonDecreasing) return false;
            pre = cur;
        }
        return true;
    }
    public static boolean isMonotonic(int[] A) {
        int len = A.length;
        if(len ==0) return true;
        boolean[] increasing = new boolean[len], decreasing = new boolean[len];
        increasing[0] = decreasing[0] = true;
        for(int i =1; i < len ; i++){
            int pre = A[i-1], cur = A[i];
            if(pre >= cur) decreasing[i] = decreasing[i-1];
            if(pre <= cur) increasing[i] = increasing[i-1];
        }
        return increasing[len-1] || decreasing[len-1];
    }
}

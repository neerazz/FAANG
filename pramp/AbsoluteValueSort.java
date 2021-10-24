/*
    Created on:  May 09, 2020
 */

import java.util.Arrays;

/**
 * Questions: https://www.pramp.com/challenge/4E4NW7NjbnHQEx1AxoXE
 * Given an array of integers arr, write a function absSort(arr), that sorts the array according to the absolute values of the numbers in arr.
 * If two numbers have the same absolute value, sort them according to sign, where the negative numbers come before the positive numbers.
 * Examples:
 * input:  arr = [2, -7, -2, -2, 0]
 * output: [0, -2, -2, 2, -7]
 */
public class AbsoluteValueSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(absSort(new int[]{-1, 0, 1, 2})));
        System.out.println(Arrays.toString(absSort(new int[]{1, 0, -1, 2})));
    }

    static int[] absSort(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted((v1, v2) -> Math.abs(v1) == Math.abs(v2) ? v1 - v2 : Math.abs(v1) - Math.abs(v2))
                .mapToInt(i -> i)
                .toArray();
    }
}

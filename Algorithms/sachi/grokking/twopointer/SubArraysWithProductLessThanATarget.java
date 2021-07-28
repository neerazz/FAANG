package grokking.twopointer;

/*
Given an array with positive numbers and a target number, find all of its contiguous subarrays whose
product is less than the target number.

Example 1:

Input: [2, 5, 3, 10], target=30
Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six contiguous subarrays whose product is less than the target.
Example 2:

Input: [8, 2, 6, 5], target=50
Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
Explanation: There are seven contiguous subarrays whose product is less than the target.
 */

import java.util.ArrayList;
import java.util.List;

public class SubArraysWithProductLessThanATarget {

    public static void main(String[] args) {
        int[] input = new int[]{2, 5, 3, 10};
        System.out.println(findSubarrays(input, 30));
    }

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        return sol;
    }
}

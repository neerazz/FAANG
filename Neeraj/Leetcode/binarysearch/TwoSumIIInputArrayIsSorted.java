package binarysearch;

import java.util.Arrays;

/*
https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1035/
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
Note:
Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        System.out.println("Answer is:" + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)) + " should be [1,2].");
        System.out.println("Answer is:" + Arrays.toString(twoSum(new int[]{-1, 0}, -1)) + " should be [1,2].");
        System.out.println("Answer is:" + Arrays.toString(twoSum(new int[]{-3, 3, 4, 90}, 0)) + " should be [1,2].");
    }

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) return new int[]{start + 1, end + 1};
            else if (sum < target) start++;
            else end--;
        }
        return new int[]{-1, -1};
    }
}

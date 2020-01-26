package problems.binarysearch;

import java.util.ArrayList;

/*
https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1039/
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
Example 1:
Input: [1,3,4,2,2]
Output: 2
Example 2:
Input: [3,1,3,4,2]
Output: 3
Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        System.out.println("Answer is " + findDuplicate(new int[]{1, 3, 4, 2, 2}) + " should be [2].");
        System.out.println("Answer is " + findDuplicate(new int[]{3, 1, 3, 4, 2}) + " should be [3].");
    }

    public static int findDuplicate(int[] nums) {
//        Approach 1: Space = O(N), Time = O(N).
        return findDuplicateApproach1(nums);
//        Approach 2: Space = O(), Time = O(NLogN).
//        return findDuplicateApproach2(nums);
    }

    private static int findDuplicateApproach2(int[] nums) {
        performMergeSort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) return nums[i];
        }
        return -1;
    }

    private static void performMergeSort(int[] nums) {
        if (nums.length == 0) return;
//        Split the array into two.
        int mid = (nums.length - 1) / 2;
        int[] left = new int[mid];
        System.arraycopy(nums, 0, left, 0, mid);
        int[] right = new int[nums.length - 1 - mid];
        System.arraycopy(nums, mid + 1, right, 0, nums.length - 1 - mid);
        performMergeSort(left);
        performMergeSort(right);
//        Sort an merge the array.
        nums = mergeArrays(left, right);
    }

    private static int[] mergeArrays(int[] left, int[] right) {
        int[] output = new int[left.length + right.length];
        int leftIndex = 0, rightIndex = 0, outputIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                output[outputIndex++] = left[leftIndex++];
            }
            if (left[leftIndex] >= right[rightIndex]) {
                output[outputIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            output[outputIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            output[outputIndex++] = left[rightIndex++];
        }
        return output;
    }

    private static int findDuplicateApproach1(int[] nums) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (integers.contains(current)) return current;
            integers.add(current);
        }
        return -1;
    }
}

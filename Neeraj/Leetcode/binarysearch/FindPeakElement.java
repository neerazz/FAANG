package binarysearch;

/*
https://leetcode.com/explore/learn/card/binary-search/126/template-ii/948/
A peak element is an element that is greater than its neighbors.
Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine. You may imagine that nums[-1] = nums[n] = -∞.
Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2,
             or index number 5 where the peak element is 6.
Note: Your solution should be in logarithmic complexity.
 */
public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println("Answer is:" + findPeakElement(new int[]{1, 2, 3, 1}) + " should be [2].");
        System.out.println("Answer is:" + findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}) + " should be [1 or 5].");
    }

    public static int findPeakElement(int[] nums) {
        return findPeakElementHelper(nums, 0, nums.length - 1);
    }

    private static int findPeakElementHelper(int[] nums, int start, int end) {
        if (end - start == 1) {
            if (nums[start] > nums[end]) return start;
            return -1;
        }
        int mid = start + (end - start) / 2;
        int midValue = nums[mid];
        int startValue = nums[start];
        int endValue = nums[end];
        if (startValue < midValue) {
            if (endValue > midValue)
                return findPeakElementHelper(nums, start, mid);
            return findPeakElementHelper(nums, mid, end);
        } else {
            if (midValue > endValue)
                return findPeakElementHelper(nums, start, mid);
            return findPeakElementHelper(nums, mid, end);
        }
    }
}

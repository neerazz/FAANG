package algo.blind75.arrays;

/*
https://leetcode.com/problems/maximum-subarray/
P

Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.
A subarray is a contiguous part of an array.

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Input: nums = [5,4,-1,7,8]
Output: 23
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(input));
    }


    //Insight - Reset when the value is negative
    public static int maxSubArray(int[] nums) {
        int sol = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            sum = Math.max(sum, num);
            sol = Math.max(sol, sum);
        }
        return sol;
    }

}

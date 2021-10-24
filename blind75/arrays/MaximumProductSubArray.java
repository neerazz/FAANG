package arrays;

/*
https://leetcode.com/problems/maximum-product-subarray/
FFP

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
and return the product. It is guaranteed that the answer will fit in a 32-bit integer.
A subarray is a contiguous subsequence of the array.

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 */
public class MaximumProductSubArray {

    //Insight - Keep Max and Min at each level
    //Get Max and Min at each level -> (min * num, max * num, num)
    //You cannot take just min or just max
    //Remember to use temp variable - Because max value will be overwritten
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums[0], max = nums[0], sol = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int temp = max;
            max = Math.max(Math.max(min * num, num), max * num);
            min = Math.min(Math.min(min * num, num), temp * num);
            sol = Math.max(sol, max);
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 3, -2, 4};
        System.out.println(maxProduct(input));
    }
}

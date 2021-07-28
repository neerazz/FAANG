package algo.blind75.arrays;

/*
https://leetcode.com/problems/maximum-product-subarray/
F

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
It is guaranteed that the answer will fit in a 32-bit integer.
A subarray is a contiguous subsequence of the array.
 */
public class MaximumProductSubArray {

    //Insight - Keep Max and Min at each level
    public int maxProduct(int[] nums) {
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
}

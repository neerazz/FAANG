package arrays;

/*
https://leetcode.com/problems/product-of-array-except-self/
F

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {


    //Insight -> Create 2 arrays [left] [Right]
    //[1, (i-1) * (curr-1)]
    //                    [(i+1) * (curr +1), 1]
    public int[] productExceptSelf(int[] nums) {
        int[] sol = new int[nums.length];
        int[] forw = new int[nums.length];
        int[] back = new int[nums.length];
        forw[0] = 1;
        back[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            forw[i] = forw[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            back[i] = back[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            sol[i] = forw[i] * back[i];
        }
        return sol;
    }
}

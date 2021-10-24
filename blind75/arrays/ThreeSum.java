package arrays;

import java.util.*;

/*
https://leetcode.com/problems/3sum/
F
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []
 */
public class ThreeSum {

    //Insight - Sort Array
    //Use two pointers - One from End, one from start - This is not Binary Search
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> sol = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    sol.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return new ArrayList<>(sol);
    }

    public static void main(String[] args) {
        List<List<Integer>> sol = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(sol);

    }

}

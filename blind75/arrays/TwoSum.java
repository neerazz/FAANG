package arrays;



import util.Util;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum/
P

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]

 */
public class TwoSum {

    public static void main(String[] args) {
        int[] input = new int[]{2, 7, 11, 15};
        Util.print(twoSum(input, 9));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (map.containsKey(comp)) {
                return new int[]{map.get(comp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}

package blind75.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/contains-duplicate/
P

Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.

Input: nums = [1,2,3,1]
Output: true

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

 */
public class ContainsDuplicate {

    public static boolean containsDuplicateSet(int[] nums) {
        //Set
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums) {
        //Sort
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 1};
        System.out.println(containsDuplicateSet(input));
        System.out.println(containsDuplicate(input));
    }


}

package hashtable;

import java.util.HashSet;

/*
https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1112/
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
Example 1:
Input: [1,2,3,1]
Output: true
Example 2:
Input: [1,2,3,4]
Output: false
Example 3:
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}) + " should be [true]");
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}) + " should be [false]");
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}) + " should be [true]");
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (hashSet.contains(current)) return true;
            hashSet.add(current);
        }
        return false;
    }
}

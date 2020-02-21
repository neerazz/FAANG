package ds.hashtable;

import java.util.HashMap;

/*
https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1176/
Given a non-empty array of integers, every element appears twice except for one. Find that single one.
Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Example 1:
Input: [2,2,1]
Output: 1
Example 2:
Input: [4,1,2,1,2]
Output: 4
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}) + " should be [1].");
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}) + " should be [4].");
        System.out.println(singleNumber_elegent(new int[]{2, 2, 1}) + " should be [1].");
        System.out.println(singleNumber_elegent(new int[]{4, 1, 2, 1, 2}) + " should be [4].");
    }

    public static int singleNumber_elegent(int[] nums) {
        int output = nums[0];
        for (int i = 1; i < nums.length; i++) {
            output ^= nums[i];
        }
        return output;
    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }
        return map.values().stream().filter(integer -> integer == 1).findAny().orElse(-1);
    }
}

import java.util.HashMap;

/*
https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1121/
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3) + " should be [true].");
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1) + " should be [true].");
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2) + " should be [false].");
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (map.containsKey(current) && Math.abs(map.get(current) - i) <= k) {
                return true;
            }
            map.put(current, i);
        }
        return false;
    }
}

package leetcode.v1.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,  return [0, 1].
 * <p>
 * https://leetcode.com/problems/two-sum/
 */

//Sol - Use a hashmap
//Can be done in O(n) and one pass.
public class TwoSum3 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.get(target - nums[i]) != null) {
                return new int[]{i, cache.get(target - nums[i])};
            } else {
                cache.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }
}


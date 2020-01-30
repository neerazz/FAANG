package topAmazonQuestions;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(cur)){
                return new int[]{map.get(cur), i};
            }else {
                int remaining = target - cur;
                map.put(remaining,i);
            }
        }
        return new int[]{-1, -1};
    }
}

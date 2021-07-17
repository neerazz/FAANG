package leetcode.v2.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Input: nums = [2,11,7,15], target = 9
 * Output: [0,2]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumBrute(new int[]{3, 2, 3}, 6)));
        System.out.println(Arrays.toString(twoSumBrute(new int[]{2, 11, 15, 7}, 9)));

        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 11, 15, 7}, 9)));
    }

    //Elegant
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
    // 2, 0
    //11, 1
    //[0,1]

    //Brute Force
    public static int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}

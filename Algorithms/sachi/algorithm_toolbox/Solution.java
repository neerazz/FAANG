package algorithm_toolbox;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // printArray(twoSum(new int[]{2,5,5,11},10));
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    private static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int complement = target - nums[j];
            if (map.containsKey(complement) && map.get(complement) != j) {
                return new int[]{j, map.get(complement)};
            }
        }
        return new int[]{-1};
    }

    private static void printArray(int[] a) {
        Arrays.stream(a).forEach(el -> System.out.print(el + " "));
    }
}
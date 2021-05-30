package biweekly.biweekly53;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  May 29, 2021
 * Questions: https://leetcode.com/problems/minimum-xor-sum-of-two-arrays/
 */

public class MinimumXORSumOfTwoArrays {

    public static void main(String[] args) {
        System.out.println(minimumXORSum(
                new int[]{65022, 4657711, 8572489, 3336640, 7744043, 8672352, 6861299, 5122697, 2857375, 7539481, 8907966, 3311170},
                new int[]{6030101, 8828015, 59043, 6529065, 9719816, 7144904, 6799001, 5637315, 9805075, 1136584, 8266168, 4154565}
        ) + " = 15088819");
        System.out.println(minimumXORSum_dp(
                new int[]{65022, 4657711, 8572489, 3336640, 7744043, 8672352, 6861299, 5122697, 2857375, 7539481, 8907966, 3311170},
                new int[]{6030101, 8828015, 59043, 6529065, 9719816, 7144904, 6799001, 5637315, 9805075, 1136584, 8266168, 4154565}
        ) + " = 15088819");
    }

    public static int minimumXORSum_dp(int[] nums1, int[] nums2) {
        int len = nums1.length;
        boolean[] taken = new boolean[len];
        Map<String, Integer> dp = new HashMap<>();
        return helper(nums1, nums2, 0, len, taken, dp);
    }

    private static int helper(int[] nums1, int[] nums2, int idx, int len, boolean[] taken, Map<String, Integer> dp) {
        if (idx == len) return 0;
        String key = Arrays.toString(taken);
        if (dp.containsKey(key)) return dp.get(key);
        int soFar = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (taken[i]) continue;
            taken[i] = true;
            int next = helper(nums1, nums2, idx + 1, len, taken, dp);
            int cur = nums1[idx] ^ nums2[i];
            soFar = Math.min(soFar, next + cur);
            taken[i] = false;
        }
        dp.put(key, soFar);
        return soFar;
    }

    public static int minimumXORSum(int[] nums1, int[] nums2) {
        int len = nums1.length;
        boolean[] taken = new boolean[len];
        return helper(nums1, nums2, 0, len, taken);
    }

    private static int helper(int[] nums1, int[] nums2, int idx, int len, boolean[] taken) {
        if (idx == len) return 0;
        int soFar = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (taken[i]) continue;
            taken[i] = true;
            int next = helper(nums1, nums2, idx + 1, len, taken);
            int cur = nums1[idx] ^ nums2[i];
            soFar = Math.min(soFar, cur + next);
            taken[i] = false;
        }
        return soFar;
    }
}

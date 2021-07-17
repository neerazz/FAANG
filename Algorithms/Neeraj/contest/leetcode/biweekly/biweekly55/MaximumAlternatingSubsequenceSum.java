package biweekly.biweekly55;

import java.util.Arrays;

/**
 * Created on:  Jun 26, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-55/problems/maximum-alternating-subsequence-sum/
 */

public class MaximumAlternatingSubsequenceSum {

    public static void main(String[] args) {

    }

    public static long maxAlternatingSum_2(int[] nums) {
        long odd = 0, even = 0;
        for (int a : nums) {
            even = Math.max(even, odd + a);
            odd = even - a;
        }
        return even;
    }

    public static long maxAlternatingSum(int[] nums) {
        int len = nums.length;
        long max = 0;
        Long[] dp = new Long[len];
        for (int i = 0; i < len; i++) {
            max = Math.max(max, helper(nums, i, len, dp));
        }
        System.out.println("dp = " + Arrays.toString(dp));
        return max;
//        return helper(nums, 0, len, dp);
    }

    private static long helper(int[] nums, int cur, int len, Long[] dp) {
        if (cur >= len) return 0;
        if (dp[cur] != null) return dp[cur];
        long max = nums[cur];
//        long max = Math.max(nums[cur], helper(nums, cur + 1, len, dp));
        for (int i = cur + 1; i < len; i++) {
            long curSum = nums[cur] - nums[i];
            long next = helper(nums, i + 1, len, dp);
            long curMax = Math.max(Math.max(curSum, curSum + next), next);
            max = Math.max(max, curMax);
        }
        return dp[cur] = max;
    }
}

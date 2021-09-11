/**
 * Created on:  Mar 18, 2021
 * Questions: https://leetcode.com/problems/wiggle-subsequence/
 */

public class WiggleSubsequence {

    public static void main(String[] args) {

    }

    public static int wiggleMaxLength_rev1(int[] nums) {
        int len = nums.length;
        int[] upper = new int[len], lower = new int[len];
//        upper will have max len of sequence that can be formed by array (0,i) when I is the upper value.
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                upper[i] = lower[i - 1] + 1;
                lower[i] = lower[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                lower[i] = upper[i - 1] + 1;
                upper[i] = upper[i - 1];
            } else {
                lower[i] = lower[i - 1];
                upper[i] = upper[i - 1];
            }
        }
        return Math.max(upper[len - 1], lower[len - 1]);
    }

    public static int wiggleMaxLength(int[] nums) {
        int len = nums.length, best = 0;
        Integer[][] dp = new Integer[len][2];
        for (int i = 0; i < len; i++) {
            int small = helper(nums, i + 1, nums[i], 0, dp);
            int big = helper(nums, i + 1, nums[i], 1, dp);
            best = Math.max(best, Math.max(small + 1, big + 1));
        }
        return best;
    }

    static int helper(int[] nums, int idx, int pre, int dir, Integer[][] dp) {
        if (idx >= nums.length) return 0;
        if (dp[idx] != null && dp[idx][dir] != null) return dp[idx][dir];
        if (dir == 0) {
            dp[idx][0] = 0;
//             the current value should be less then the pre
            for (int i = idx; i < nums.length; i++) {
                if (nums[i] < pre) {
                    dp[idx][0] = Math.max(dp[idx][0], helper(nums, i + 1, nums[i], dir ^ 1, dp) + 1);
                }
            }
        } else {
            dp[idx][1] = 0;
//             the current value should be greter then the pre
            for (int i = idx; i < nums.length; i++) {
                if (nums[i] > pre) {
                    dp[idx][1] = Math.max(dp[idx][1], helper(nums, i + 1, nums[i], dir ^ 1, dp) + 1);
                }
            }
        }
        return dp[idx][dir];
    }
}

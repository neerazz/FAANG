/**
 * Created on:  Sep 03, 2020
 * Questions: https://leetcode.com/problems/target-sum/
 */
public class TargetSum {
    public static void main(String[] args) {

    }

    public static int findTargetSumWays(int[] nums, int S) {
        Integer[][] dp = new Integer[nums.length][2001];
        return helper(nums, 0, 0, S, dp);
    }

    private static int helper(int[] nums, int i, int sum, int target, Integer[][] dp) {
        if (i == nums.length) {
            return target == sum ? 1 : 0;
        } else if (dp[i][sum + 1000] != null) {
            return dp[i][sum + 1000];
        } else {
            int add = helper(nums, i + 1, sum + nums[i], target, dp);
            int sub = helper(nums, i + 1, sum - nums[i], target, dp);
            return dp[i][sum + 1000] = add + sub;
        }
    }
}

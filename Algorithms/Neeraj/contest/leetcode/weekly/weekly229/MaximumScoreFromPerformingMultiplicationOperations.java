package weekly.weekly229;

/**
 * Created on:  Feb 20, 2021
 * Questions:
 */

public class MaximumScoreFromPerformingMultiplicationOperations {

    public static void main(String[] args) {
        System.out.println(maximumScore(new int[]{1, 2, 3}, new int[]{3, 2, 1}));
    }

    public static int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length, m = multipliers.length;
        Integer[][] dp = new Integer[n][m];
        return helper(nums, 0, n - 1, multipliers, 0, dp);
    }

    private static int helper(int[] nums, int s, int e, int[] muls, int i, Integer[][] dp) {
        if (s > e || i >= muls.length) return 0;
        if (dp[s][i] != null) return dp[s][i];
        dp[s][i] = 0;
        if (s == e) {
            if (i == muls.length - 1) {
                dp[s][i] = nums[s] * muls[i];
            }
        } else {
//            You have two options.
            int leftFun = helper(nums, s + 1, e, muls, i + 1, dp);
            int rightFun = helper(nums, s, e - 1, muls, i + 1, dp);
            int left = leftFun + (nums[s] * muls[i]);
            int right = rightFun + (nums[e] * muls[i]);
            dp[s][i] = Math.max(left, right);
        }
        return dp[s][i];
    }
}

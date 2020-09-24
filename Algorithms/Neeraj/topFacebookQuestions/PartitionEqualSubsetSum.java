/**
 * Created on:  Sep 20, 2020
 * Questions: https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {

    }

    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 == 1) return false;
        int len = nums.length;
        Boolean[][] dp = new Boolean[len + 1][total / 2];
        return helper(0, nums, 0, total / 2, dp);
    }

    private static boolean helper(int start, int[] nums, int sum, int tar, Boolean[][] dp) {
        if (sum > tar || start >= nums.length) return false;
        if (sum == tar) return true;
        if (dp[start][sum] != null) return dp[start][sum];
        for (int end = start; end < nums.length; end++) {
            if (helper(end + 1, nums, sum + nums[end], tar, dp)) return dp[start][sum] = true;
        }
        return dp[start][sum] = false;
    }
}

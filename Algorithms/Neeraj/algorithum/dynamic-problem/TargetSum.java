/**
 * Created on:  Sep 03, 2020
 * Questions: https://leetcode.com/problems/target-sum/
 */
public class TargetSum {
    public static void main(String[] args) {

    }

    static int numberOfWays = 0;
    public static int findTargetSumWays_rev(int[] nums, int S) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) {
            if (nums[0] == S || nums[0] * -1 == S) return 1;
            else return 0;
        }
        findNumberOfWays(nums, 0, 0, -1, S);
        findNumberOfWays(nums, 0, 0, +1, S);
        int output = numberOfWays;
        numberOfWays = 0;
        return output;
    }

    private static int findNumberOfWays(int[] nums, int index, int sum, int multiplicationFactor, int target) {
        if (index >= nums.length) return sum;
        sum += nums[index] * multiplicationFactor;
        int sumA = findNumberOfWays(nums, index + 1, sum, -1, target);
        int sumB = findNumberOfWays(nums, index + 1, sum, 1, target);
        if (index == nums.length - 1 && (sumA == target || sumB == target)) numberOfWays++;
        return sum;
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

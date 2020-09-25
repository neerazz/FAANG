import java.util.Arrays;

/**
 * Created on:  Sep 25, 2020
 * Questions: https://leetcode.com/problems/house-robber-ii/
 */
public class HouseRobberII {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{1, 2, 1, 0}));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        return Math.max(helper(Arrays.copyOfRange(nums, 0, len - 1)), helper(Arrays.copyOfRange(nums, 1, len)));
    }

    private static int helper(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], (i >= 2 ? dp[i - 2] : 0) + nums[i]);
        }
        return dp[len - 1];
    }
}

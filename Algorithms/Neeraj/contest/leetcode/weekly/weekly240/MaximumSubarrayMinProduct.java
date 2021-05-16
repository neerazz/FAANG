package weekly.weekly240;

/**
 * Created on:  May 08, 2021
 * Questions:
 */

public class MaximumSubarrayMinProduct {

    public static void main(String[] args) {
        System.out.println(maxSumMinProduct(new int[]{1, 2, 3, 2}) + " = 14");
        System.out.println(maxSumMinProduct(new int[]{1, 1, 3, 2, 2, 2, 1, 5, 1, 5}) + " = 25");
    }

    static long max;
    static long mod = 1_000_000_007;

    public static int maxSumMinProduct(int[] nums) {
        max = 0;
        int len = nums.length;
        long[] preSum = new long[len];
        long sum = 0;
        for (int i = 0; i < len; i++) {
            preSum[i] = sum += nums[i];
        }
        Long[][] dp = new Long[len][len];
        helper(nums, 0, len - 1, dp, preSum);
        return (int) (max % mod);
    }

    private static long helper(int[] nums, int start, int end, Long[][] dp, long[] preSum) {
        if (start > end) return Integer.MAX_VALUE;
        if (start == end) return nums[start];
        if (dp[start][end] != null) return dp[start][end];
        long min1 = helper(nums, start + 1, end - 1, dp, preSum);
        long min2 = helper(nums, start + 1, end, dp, preSum);
        long min3 = helper(nums, start, end - 1, dp, preSum);
        long min = min(min1, min2, min3, nums[start], nums[end]);
        long sum = sum(nums, preSum, start, end);
        return dp[start][end] = ((min * sum) % mod);
    }

    private static long sum(int[] nums, long[] preSum, int start, int end) {
        return preSum[end] - preSum[start] + nums[start];
    }


    private static long min(long v1, long v2, long v3, int v4, int v5) {
        return Math.min(Math.min(v1, v2), Math.min(v3, Math.min(v4, v5)));
    }
}

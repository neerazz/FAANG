/**
 * Created on:  Jan 14, 2021
 * Questions: https://aonecode.com/Amazon-Online-Assessment-Minimum-Total-Container-Size
 */

public class MinimumTotalContainerSize {

    public static void main(String[] args) {
        System.out.println(getMinimumTotalContainerSize(new int[]{10, 2, 20, 5, 15, 10, 1}, 3) + " = 31");
        System.out.println(getMinimumTotalContainerSize(new int[]{10, 2, 20, 5, 15, 10, 1}, 5) + " = 43");
        System.out.println(getMinimumTotalContainerSize(new int[]{5, 4, 2, 4, 3, 4, 5, 4}, 4) + " = 16");
        System.out.println(getMinimumTotalContainerSize(new int[]{22, 12, 1, 14, 17}, 2) + " = 39");
    }

    private static int getMinimumTotalContainerSize(int[] nums, int k) {
        Integer[][] dp = new Integer[nums.length][k + 1];
        int result = helper(nums, 0, k, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int helper(int[] jobs, int start, int days, Integer[][] dp) {
        if (jobs.length - start < days) return Integer.MAX_VALUE;
        if (days == 0) {
            if (start == jobs.length) return 0;
            return Integer.MAX_VALUE;
        }
        if (dp[start][days] != null) return dp[start][days];
        int cur = Integer.MAX_VALUE, max = 0;
        for (int i = start; i < jobs.length; i++) {
            max = Math.max(jobs[i], max);
            int next = helper(jobs, i + 1, days - 1, dp);
            if (next != Integer.MAX_VALUE) {
                cur = Math.min(cur, max + next);
            }
        }
        return dp[start][days] = cur;
    }
}

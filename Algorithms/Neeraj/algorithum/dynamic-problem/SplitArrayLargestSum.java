import java.util.Arrays;

class SplitArrayLargestSum {
    public static void main(String[] args) {

    }

    public static int splitArray_rev1(int[] nums, int m) {
        int len = nums.length;
        Integer[][] dp = new Integer[len][m + 1];
        if (m > len) return -1;
        return helper(nums, 0, m, dp);
    }

    static int helper(int[] nums, int start, int m, Integer[][] dp) {
        int len = nums.length;
        if (start == len) {
            return m == 0 ? 0 : Integer.MAX_VALUE;
        }
        if (m <= 0) return Integer.MAX_VALUE;
        if (dp[start][m] != null) return dp[start][m];
        long cur = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = start; i < len; i++) {
            sum += nums[i];
            int next = helper(nums, i + 1, m - 1, dp);
            if (next == Integer.MAX_VALUE) continue;
            long curMax = Math.max(sum, next);
            cur = Math.min(cur, curMax);
        }
        return dp[start][m] = (int) cur;
    }

    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] sums = new int[len + 1];
        int[][] dp = new int[m + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        // Loop through each element as cols and m as rows.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= len; j++) {
                // Find the best value at this point by comparing with the previous calculated values.
                for (int k = 0; k < i; k++) {
                    // Loop through till the elements and decide that can be splitted based on the values at that point and the new value.
                    // We are taking the mim of (maximum value of the sum of splits) with all the possibilities
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sums[i] - sums[k]));
                }
            }
        }
        return dp[m][len];
    }
}

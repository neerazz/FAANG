/**
 * Crated on:  Apr 08, 2020
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}) + " should be [4].");
        System.out.println(lengthOfLIS(new int[]{1}) + " should be [1].");
        System.out.println(lengthOfLIS(new int[]{2, 2}) + " should be [1].");
    }

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length, max = 1;
        if (len <= 1) return len;
        int[] dp = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}

import java.util.Arrays;

/**
 * Created on:  Jul 26, 2020
 * Questions:
 */
public class MaximumSumOf3NonOverlappingSubarrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2)));
    }

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        Integer[][][] dp = new Integer[nums.length + 1][4][4];
        Integer[] result = helper(nums, 0, 0, k, dp);
        return new int[]{result[1], result[2], result[3]};
    }

    private static Integer[] helper(int[] nums, int start, int rem, int k, Integer[][][] dp) {
        if (rem == 3) return new Integer[]{0, 0, 0, 0};
        if (dp[start][rem][0] != null) return dp[start][rem];
        int sum = 0, p2 = start, end = nums.length - (3 - rem) * k;
        Integer[] cur = new Integer[]{0, 0, 0, 0};
        for (int i = start; i <= end; i++) {
            while (p2 - i < k) {
                sum += nums[p2++];
            }
            Integer[] next = dp[i + k][rem + 1] = helper(nums, i + k, rem + 1, k, dp);
            if (next[0] + sum > cur[0]) {
                cur = Arrays.copyOf(next, 4);
                cur[0] = next[0] + sum;
                cur[rem + 1] = i;
            }
            sum -= nums[i];
        }
        return cur;
    }
}

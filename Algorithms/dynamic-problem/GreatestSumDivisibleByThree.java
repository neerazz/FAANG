import java.util.Arrays;

/**
 * Created on:  Mar 09, 2021
 * Questions: https://leetcode.com/problems/greatest-sum-divisible-by-three/
 */

public class GreatestSumDivisibleByThree {

    public static void main(String[] args) {

    }

    public static int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for (int num : nums) {
            for (int val : Arrays.copyOf(dp, dp.length)) {
                dp[(num + val) % 3] = Math.max(dp[(num + val) % 3], num + val);
            }
        }
        return dp[0];
    }
}

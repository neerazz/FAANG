/**
 * Created on:  Sep 16, 2021
 * Ref: https://leetcode.com/problems/longest-turbulent-subarray/
 */
public class LongestTurbulentSubarray {
    public static void main(String[] args) {

    }

    public static int maxTurbulenceSize_dp(int[] arr) {
        int len = arr.length;
//         0: less then, 1: greater
        int[][] dp = new int[len][2];
        dp[0][0] = dp[0][1] = 1;
        int max = 1, pre = arr[0];
        for (int i = 1; i < len; i++) {
            int cur = arr[i];
            if (pre < cur) {
                dp[i][0] = 1;
                dp[i][1] = dp[i - 1][0] + 1;
            } else if (pre > cur) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = 1;
            } else {
                dp[i][1] = dp[i][0] = 1;
            }
            max = Math.max(Math.max(dp[i][0], dp[i][1]), max);
            pre = cur;
        }
        // System.out.println(Arrays.deepToString(dp));
        return max;
    }

    public static int maxTurbulenceSize(int[] arr) {
        // size of the input array
        int n = arr.length;
        // keeps track of turbulent subarray size
        int maxTurbulence = 1, turbulence = 1;
        // keeps track of the next condition that must be met
        boolean shouldBeLessThan = true, shouldBeGreaterThan = true;

        for (int k = 0; k < n - 1; k++) {
            // check every element pair
            if (arr[k] < arr[k + 1]) {
                if (shouldBeLessThan) {
                    // required condition met
                    turbulence += 1;
                } else {
                    // reset size
                    // at least two elements are valid
                    turbulence = 2;
                }
                // next element pair must have >
                shouldBeLessThan = false;
                shouldBeGreaterThan = true;
            } else if (arr[k] > arr[k + 1]) {
                if (shouldBeGreaterThan) {
                    // required condition met
                    turbulence += 1;
                } else {
                    // reset size
                    // at least two elements are valid
                    turbulence = 2;
                }
                // next element pair must have <
                shouldBeLessThan = true;
                shouldBeGreaterThan = false;
            } else {
                // current element pair is invalid
                // reset size to minimum
                turbulence = 1;
                // next element pair can have < or >
                shouldBeLessThan = true;
                shouldBeGreaterThan = true;
            }
            // update maximum turbulent subarray size
            maxTurbulence = Math.max(maxTurbulence, turbulence);
        }

        return maxTurbulence;
    }
}

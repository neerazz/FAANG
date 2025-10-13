class Solution {
    public int climbStairs(int n) {
        // If there's only one step, there's only one way.
        // If there are two steps, there are two ways: 1 step + 1 step, or 2 steps.
        // The problem description implies n is a positive integer.
        if (n <= 2) {
            return n;
        }

        // This is a classic dynamic programming problem.
        // The number of ways to reach step 'i' is the sum of ways to reach step 'i-1' and 'i-2'.
        // This is the Fibonacci sequence.

        // We can optimize space by only storing the last two values.
        int one_step_before = 2; // Ways to reach step 2
        int two_steps_before = 1; // Ways to reach step 1
        int all_ways = 0;

        for (int i = 3; i <= n; i++) {
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }

        return all_ways;
    }

    // Standard tabulation approach with O(n) space
    public int climbStairs_with_array(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case
        dp[1] = 1; // Base case

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

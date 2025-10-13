import java.util.HashMap;
import java.util.Map;

class Solution {
    // Memoization cache
    private Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {
        // Base cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // Check cache
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Recursive step and store result in cache
        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);

        return result;
    }

    // An alternative bottom-up (tabulation) approach could also be used.
    public int fib_tabulation(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

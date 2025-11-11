# Dynamic Programming (DP)

Dynamic Programming is a method for solving a complex problem by breaking it down into a collection of simpler subproblems, solving each of those subproblems just once, and storing their solutions.

## Key Characteristics of DP Problems

1.  **Optimal Substructure:** A problem has optimal substructure if an optimal solution can be constructed from optimal solutions of its subproblems.
2.  **Overlapping Subproblems:** A problem has overlapping subproblems if it can be broken down into subproblems which are reused several times.

## Two Main Approaches to DP

### 1. Memoization (Top-Down)

In this approach, we write a recursive function that works from the top down. We store the results of expensive function calls in a cache (e.g., a hash map or an array) and return the cached result when the same inputs occur again.

#### Template: Memoization

```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    // A map to store results of expensive function calls.
    private Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        }
        // Check if the result is already in our cache
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Recursive step: compute the result and store it in the cache
        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);

        return result;
    }
}
```

**Example Problem:** [Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)
*(Solution file `FibonacciNumber.java` is in this directory)*

### 2. Tabulation (Bottom-Up)

In this approach, we solve the problem "bottom-up" by starting with the smallest subproblems and iteratively building up to the solution of the original problem. We typically use an array or a matrix (`dp` table) to store the results of subproblems.

#### Template: Tabulation

```java
class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        // dp[i] will store the number of ways to climb to the i-th step.
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
```

**Example Problem:** [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)
*(Solution file `ClimbingStairs.java` is in this directory)*

## When to use DP

Look for problems that ask for an "optimal" (e.g., min, max, longest, shortest) solution and have the characteristics of optimal substructure and overlapping subproblems.

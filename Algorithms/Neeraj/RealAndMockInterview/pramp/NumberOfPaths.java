import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created on:  May 25, 2020
 * Questions: https://www.pramp.com/challenge/N5LYMbYzyOtbpovQoY7X
 */
public class NumberOfPaths {
    static Map<Integer, Integer> memo;

    public static void main(String[] args) {
        System.out.println("***************************** Method 1 *****************************");
        System.out.println(numOfPathsToDest(1) + " should be [1]");
        System.out.println(numOfPathsToDest(2) + " should be [1]");
        System.out.println(numOfPathsToDest(3) + " should be [2]");
        System.out.println(numOfPathsToDest(4) + " should be [5]");
        System.out.println(numOfPathsToDest(6) + " should be [42]");
        System.out.println(numOfPathsToDest(17) + " should be [35357670]");
        System.out.println("***************************** Method 2 *****************************");
        System.out.println(numOfPathsToDest_rev1(1) + " should be [1]");
        System.out.println(numOfPathsToDest_rev1(2) + " should be [1]");
        System.out.println(numOfPathsToDest_rev1(3) + " should be [2]");
        System.out.println(numOfPathsToDest_rev1(4) + " should be [5]");
        System.out.println(numOfPathsToDest_rev1(6) + " should be [42]");
        System.out.println(numOfPathsToDest_rev1(17) + " should be [35357670]");
    }

    static int numOfPathsToDest_rev1(int n) {
        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                if (row + 1 < n) {
                    dp[row + 1][col] += dp[row][col];
                }
                if (col + 1 < n) {
                    dp[row][col + 1] += dp[row][col];
                }
            }
        }
        return dp[n - 1][n - 1];
    }

    static int numOfPathsToDest(int n) {
        if (n <= 0) return 0;
        memo = new HashMap<>();
        return helper(0, 0, n);
    }

    static int helper(int row, int col, int n) {
        if (col >= n || col < row) return 0;
        if (row == n - 1 && col == n - 1) return 1;
        int hash = row * 10000 + col;
        if (memo.containsKey(hash)) return memo.get(hash);
        int op = 0;
        op += helper(row + 1, col, n);
        op += helper(row, col + 1, n);
        memo.put(hash, op);
        return op;
    }
}

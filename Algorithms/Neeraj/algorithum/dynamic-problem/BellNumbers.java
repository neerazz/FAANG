import java.util.Arrays;

/**
 * Questions:
 * Given a set of n elements, find number of ways of partitioning it.
 * Examples:
 * Input:  n = 2
 * Output: Number of ways = 2
 * Explanation: Let the set be {1, 2}
 * { {1}, {2} }
 * { {1, 2} }
 * Input:  n = 3
 * Output: Number of ways = 5
 * Explanation: Let the set be {1, 2, 3}
 * { {1}, {2}, {3} }
 * { {1}, {2, 3} }
 * { {2}, {1, 3} }
 * { {3}, {1, 2} }
 * { {1, 2, 3} }.
 * Solution: https://youtu.be/oGYFJ9gSBKw?t=718
 */
public class BellNumbers {
    public static void main(String[] args) {
        System.out.println(nThBellNumber(3));
        System.out.println(nThBellNumber(5));
        System.out.println(nThBellNumber(50));
        System.out.println(nThBellNumber(100));
    }

    private static int nThBellNumber(int n) {
        long[][] dp = new long[n + 1][n + 1];
        dp[0][0] = 1;
        for (int row = 1; row <= n; row++) {
            for (int col = 0; col < row + 1; col++) {
                if (col == 0) {
//                    Take the last element of the previous row. For every row row, we are iterating only till row.
                    dp[row][col] = dp[row - 1][row - 1];
                } else {
//                    Else sum the left top value and left value.
                    dp[row][col] = dp[row - 1][col - 1] + dp[row][col - 1];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return (int) (dp[n][n] % 10e7);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/perfect-squares/
Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */
public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println("Answer is :" + numSquares(12) + " should be [3]");
        System.out.println("Answer is :" + numSquares(13) + " should be [2]");
    }

    public static int numSquares(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
//        d[i] = Numbers required to make i with valid squares.
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
//        Base case, you need 0 numbers to make a number 0.
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < squares.size(); j++) {
                int curSquare = squares.get(j);
//                If current square cannot be used to make number i, then break;
                if (i < curSquare) break;
//                Check if you can use this square to make the smallest i.
                dp[i] = Math.min(dp[i], dp[i - curSquare] + 1);
            }
        }
        return dp[n];
    }

    public int numSquares_optimal(int n) {
        int root = (int) Math.ceil(Math.sqrt(n));
        if (root * root == n) return 1;
        int a, b, c;
        int ans = 4;
        for (int i = root; i >= 1; i--) {
            a = i * i;
            for (int j = root; j >= 1; j--) {
                b = j * j;
                if (a + b == n) {
                    ans = Math.min(ans, 2);
                }
                for (int k = root; k >= 1; k--) {
                    c = k * k;
                    if (a + b + c == n) {
                        ans = Math.min(ans, 3);
                    }
                }
            }
        }
        return ans;
    }
}

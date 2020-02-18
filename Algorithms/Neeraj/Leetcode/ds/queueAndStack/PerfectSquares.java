package ds.queueAndStack;

import java.util.ArrayList;

/*
https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1371/
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
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        int[][] finalValues = new int[squares.size() + 1][n + 1];

//        Set the values of top most column to the i'th value.
        for (int i = 0; i <= n; i++) finalValues[0][i] = i;

        for (int i = 1; i <= squares.size(); i++) {
            Integer rowValue = squares.get(i - 1);
            for (int j = 1; j <= n; j++) {
                if (j < rowValue) {
                    finalValues[i][j] = finalValues[i - 1][j];
                } else {
                    finalValues[i][j] = Math.min(finalValues[i][j - rowValue] + 1, finalValues[i - 1][j]);
                }
            }
        }
//        Arrays.stream(finalValues).forEach(a -> System.out.println(Arrays.toString(a)));
        return finalValues[squares.size()][n];
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

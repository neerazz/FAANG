/**
 * Created on:  Feb 24, 2021
 * Questions:
 */

public class StaircaseTraversal {

    public static void main(String[] args) {

    }

    //    Time: O(n*k), Space: O(n)
    public static int staircaseTraversal(int height, int maxSteps) {
        int[] dp = new int[height + 1];
        dp[0] = 1;
        for (int i = 0; i <= height; i++) {
            for (int j = 1; j <= maxSteps && i + j <= height; j++) {
                dp[i + j] += dp[i];
            }
        }
        return dp[height];
    }

    //    TIme: O(n), Space: O(n)
    public static int staircaseTraversal_op2(int height, int maxSteps) {
        int[] dp = new int[height + 1];
        dp[0] = 1;
        int sum = 0;
        for (int i = 1; i <= height; i++) {
            int start = i - maxSteps - 1;
            int end = i - 1;
            sum -= start >= 0 ? dp[start] : 0;
            sum += end >= 0 ? dp[end] : 0;
            dp[i] = sum;
        }
        return dp[height];
    }
}

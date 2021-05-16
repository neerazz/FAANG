package biweekly.biweekly48;

/**
 * Created on:  Mar 20, 2021
 * Questions:
 */

public class MaximizeScoreAfterNOperations {

    public static void main(String[] args) {
        System.out.println("*************************** Solution 1 **************************");
        System.out.println(maxScore(new int[]{1, 2}) + " = 1");
        System.out.println(maxScore(new int[]{3, 4, 6, 8}) + " = 11");
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6}) + " = 14");
        System.out.println(maxScore(new int[]{109497, 983516, 698308, 409009, 310455, 528595, 524079, 18036, 341150, 641864, 913962, 421869, 943382, 295019}) + " = 527");
        System.out.println("*************************** Solution 2 **************************");
        System.out.println(maxScore_rev1(new int[]{1, 2}));
        System.out.println(maxScore_rev1(new int[]{3, 4, 6, 8}));
        System.out.println(maxScore_rev1(new int[]{1, 2, 3, 4, 5, 6}));
//        System.out.println(maxScore_rev1(new int[]{109497, 983516, 698308, 409009, 310455, 528595, 524079, 18036, 341150, 641864, 913962, 421869, 943382, 295019}) + " = 527");
    }

    public static int maxScore(int[] nums) {
        maxVal = 0;
        int len = nums.length, n = nums.length / 2;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                dp[i][j] = gcd(nums[i], nums[j]);
            }
        }
        boolean[] taken = new boolean[len];
        greedy(taken, dp, n, len, 0);
        return (int) maxVal;
    }

    private static void greedy(boolean[] taken, int[][] dp, int n, int len, long soFar) {
        if (n == 0) {
            maxVal = Math.max(maxVal, soFar);
        } else {
//            At each step take the maximum gcd that can be formed, if there are multiple maximum formed loop through all those maximums.
            int max = 0;
            for (int i = 0; i < len; i++) {
                if (!taken[i]) {
                    for (int j = 0; j < len; j++) {
                        if (!taken[j] && i != j) {
                            max = Math.max(max, dp[i][j]);
                        }
                    }
                }
            }
//            Loop through all the possible numbers that can be used to form a GCD, and if the value the gcd val is max then make a recursive call.
            for (int i = 0; i < len; i++) {
                if (!taken[i]) {
                    for (int j = 0; j < len; j++) {
                        if (!taken[j] && i != j && dp[i][j] == max) {
                            taken[i] = taken[j] = true;
                            long curVal = soFar + n * dp[i][j];
                            greedy(taken, dp, n - 1, len, curVal);
                            taken[i] = taken[j] = false;
                        }
                    }
                }
            }
        }
    }


    static long maxVal;

    public static int maxScore_rev1(int[] nums) {
        int len = nums.length, n = len / 2;
        maxVal = 0;
        boolean[] taken = new boolean[len];
        helper(nums, 1, n, taken, 0);
        return (int) maxVal;
    }

    private static void helper(int[] nums, int pairs, int total, boolean[] taken, long soFar) {
        if (pairs == total + 1) {
            maxVal = Math.max(maxVal, soFar);
        } else {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                if (!taken[i]) {
                    for (int j = 0; j < len; j++) {
                        if (!taken[j] && i != j) {
                            taken[i] = taken[j] = true;
                            long curVal = (long) pairs * gcd(nums[i], nums[j]);
//                            System.out.println("curVal = " + curVal + " i = " + i + " j =" + j);
                            helper(nums, pairs + 1, total, taken, soFar + curVal);
                            taken[i] = taken[j] = false;
                        }
                    }
                }
            }
        }
    }

    static int gcd(int a, int b) {
//        a should be greater then b.
        if (a < b) return gcd(b, a);
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

package y2020.RoundA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created on:  Jun 22, 2020
 * Questions: Dr. Patel has N stacks of plates. Each stack contains K plates. Each plate has a positive beauty value, describing how beautiful it looks.
 * <p>
 * Dr. Patel would like to take exactly P plates to use for dinner tonight. If he would like to take a plate in a stack, he must also take all of the plates above it in that stack as well.
 * <p>
 * Help Dr. Patel pick the P plates that would maximize the total sum of beauty values.
 * <p>
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a line containing the three integers N, K and P. Then, N lines follow. The i-th line contains K integers, describing the beauty values of each stack of plates from top to bottom.
 * <p>
 * Output
 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the maximum total sum of beauty values that Dr. Patel could pick.
 */
public class Plates {
    public static void main(String[] args) {
        Scanner sr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sr.nextInt();
        int[] result = new int[tests];
        for (int i = 0; i < tests; i++) {
            int n = sr.nextInt();
            int k = sr.nextInt();
            int required = sr.nextInt();
            int[][] stacks = new int[n][k];
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int m = 0; m < k; m++) {
                    int cur = sr.nextInt();
                    stacks[j][m] = sum += cur;
                }
            }
            result[i] = getValue(required, stacks, n, k);
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static int getValue(int required, int[][] stack, int n, int k) {
        Integer[][] dp = new Integer[n + 1][required + 1];
        return helper(stack, dp, n, k, required, 0, 0);
    }

    private static int helper(int[][] stack, Integer[][] dp, int n, int k, int req, int row, int taken) {
        if (req == taken) return 0;
        if (row >= n || req < taken) return Integer.MIN_VALUE;
        if (dp[row][taken] != null) return dp[row][taken];
        int max = Integer.MIN_VALUE;
//        Start it from zero, so that you start from not taking any element from this list till taking all teh elements from list.
        for (int i = 0; i <= k; i++) {
            int next = helper(stack, dp, n, k, req, row + 1, taken + i);
            if (next != Integer.MIN_VALUE) {
                max = Math.max(max, i == 0 ? next : stack[row][i - 1] + next);
            }
        }
        return dp[row][taken] = max;
    }
}

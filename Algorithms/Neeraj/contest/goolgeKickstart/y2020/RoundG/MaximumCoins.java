package y2020.RoundG;

import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 18, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/00000000001a0069/0000000000414a24
 */

public class MaximumCoins {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        int[] result = new int[tests];
        for (int i = 0; i < tests; i++) {
            int n = sc.nextInt();
            int[][] nums = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    nums[j][k] = sc.nextInt();
                }
            }
            result[i] = getMaxCoins(n, nums);
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static int getMaxCoins(int n, int[][] nums) {
        long[][] sum = new long[n + 1][n + 1];
        long max = 0;
//        Calculate the prefix sum
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i][j] + nums[i][j];
            }
        }
//        At each index get the value.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long top = sum[i + 1][j + 1];
                long bottom = getLastValue(sum, i, j, n) - sum[i + 1][j + 1] + nums[i][j];
                max = Math.max(max, Math.max(top, bottom));
            }
        }
        return (int) max;
    }

    private static long getLastValue(long[][] sum, int i, int j, int n) {
        if (i == j) return sum[n][n];
        else if (i < j) {
            return sum[n - j + i][n];
        }
        return sum[n][n - i + j];
    }
}

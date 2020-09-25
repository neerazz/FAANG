package contest1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created on:  Sep 24, 2020
 * Questions: https://codeforces.com/contest/1420/problem/C1
 */
public class PokemonArmy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int t = sc.nextInt();
        while (t-- > 0) {
            int len = sc.nextInt(), q = sc.nextInt();
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) nums[i] = sc.nextInt();
            System.out.println(getMaxStrength(len, q, nums));
        }
    }

    private static int getMaxStrength(int len, int q, int[] nums) {
        int[][] dp = new int[len + 1][2];
        for (int i = 1; i <= len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - nums[i - 1]);
        }
        return Math.max(dp[len][0], dp[len][1]);
    }
}

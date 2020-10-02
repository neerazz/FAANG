package contest1426;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created on:  Oct 01, 2020
 * Questions: https://codeforces.com/contest/1426/problem/E
 */
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        Map<String, int[]> memo = new HashMap<>();
        int n = sc.nextInt();
        int[] a = {sc.nextInt(), sc.nextInt(), sc.nextInt()}, b = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
//        int[] minMax = getMinMax(n, a, b, memo);
        int[] minMax = getMinMax_Optimal(n, a, b, memo);
        System.out.printf("%d %d%n", minMax[0], minMax[1]);
    }

    private static int[] getMinMax_Optimal(int n, int[] a, int[] b, Map<String, int[]> memo) {
//        If alica can win then, get minimum number of times this combination can occur.
        int maxTimeAlicaWins = Math.min(a[0], b[1]) + Math.min(a[1], b[2]) + Math.min(a[2], b[0]);
//        If bob lose then, get minimum number of times this combination can occur.
        int minTimeAlicaWins = Math.max(0, a[0] - b[0] - b[2]) + Math.max(0, a[1] - b[0] - b[1]) + Math.max(0, a[2] - b[1] - b[2]);

//        System.out.println("maxTimeAlicaWins = " + maxTimeAlicaWins);
//        System.out.println("minTimeAlicaWins = " + minTimeAlicaWins);
        return new int[]{minTimeAlicaWins, maxTimeAlicaWins};
    }

    private static int[] getMinMax(int n, int[] a, int[] b, Map<String, int[]> memo) {
//        System.out.println("n = " + n + ", a = " + Arrays.toString(a) + ", b = " + Arrays.toString(b) + ", memo = " + memo);
        if (n == 0) return new int[]{0, 0};
//        0 -> rock: 1- > scissors, 2 -> paper
        String key = getKey(a, b);
        if (memo.containsKey(key)) return memo.get(key);
//        0: min, 1 : max
        int[] cur = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i] <= 0 || b[j] <= 0) continue;
                a[i]--;
                b[j]--;
                int alicaScore = alicaCanWin(i, j) ? 1 : 0;
                int[] next = getMinMax(n - 1, a, b, memo);
//                System.out.println("next = " + Arrays.toString(next));
                cur[0] = Math.min(cur[0], next[0] + alicaScore);
                cur[1] = Math.max(cur[1], next[1] + alicaScore);
                a[i]++;
                b[j]++;
            }
        }
        memo.put(key, cur);
        return cur;
    }

    private static boolean bobCanWin(int a, int b) {
        return (b == 0 && a == 1) || (b == 1 && a == 2) || (b == 2 && a == 0);
    }

    private static boolean alicaCanWin(int a, int b) {
//        0 -> rock: 1- > scissors, 2 -> paper
        return (a == 0 && b == 1) || (a == 1 && b == 2) || (a == 2 && b == 0);
    }

    private static String getKey(int[] a, int[] b) {
        return a[0] + "-" + a[1] + "-" + a[2] + "&" + b[0] + "-" + b[1] + "-" + b[2];
    }
}

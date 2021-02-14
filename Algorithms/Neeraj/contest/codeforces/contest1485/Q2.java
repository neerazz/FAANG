package contest1485;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 12, 2021
 * Questions:
 */

public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = sc.nextInt(), q = sc.nextInt(), k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[][] queries = new int[q][2];
        for (int i = 0; i < q; i++) {
            queries[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }
        solve(n, nums, q, queries, k);
    }

    private static void solve(int n, int[] nums, int q, int[][] queries, int k) {
        int[] flex = new int[n];
        for (int i = 0; i < n; i++) {
            int start = i == 0 ? 0 : nums[i - 1];
            int end = i == n - 1 ? k + 1 : nums[i + 1];
            flex[i] = getNumbers(start, end);
        }
        int[] sTree = new int[4 * n];
        buildSTree(flex, 0, n - 1, 0, k + 1, sTree, 0);
        for (int[] query : queries) {
            int from = query[0], to = query[1];
            int result;
            if (from == to) {
                result = getNumbers(0, k + 1);
            } else if (from + 1 == to) {
                result = getNumbers(0, nums[to - 1]) + getNumbers(nums[from - 1], k + 1);
            } else {
                int val = query(sTree, from, to - 2, 0, n - 1, 0);
                result = getNumbers(0, nums[from]) + getNumbers(nums[to - 2], k + 1) + val;
            }
            System.out.println(result);
        }
    }

    private static int getNumbers(int s, int e) {
        return (e - 1) - (s + 1);
    }

    private static int query(int[] sTree, int qs, int qe, int s, int e, int i) {
        if (e < qs || s > qe) return 0;
        if (qs <= s && e <= qe) return sTree[i];
        int m = (s + e) / 2;
        return query(sTree, qs, qe, s, m, 2 * i + 1) + query(sTree, qs, qe, m + 1, e, 2 * i + 2);
    }

    private static void buildSTree(int[] nums, int s, int e, int min, int max, int[] sTree, int i) {
        if (s == e) {
            sTree[i] = nums[s];
        } else {
            int m = (s + e) / 2, l = 2 * i + 1, r = 2 * i + 2;
            buildSTree(nums, s, m, min, nums[m + 1], sTree, l);
            buildSTree(nums, m + 1, e, nums[m], max, sTree, r);
            sTree[i] = sTree[l] + sTree[r];
        }
    }
}

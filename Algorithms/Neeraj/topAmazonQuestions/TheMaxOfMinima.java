import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 15, 2021
 * Questions: https://aonecode.com/aplusplus/interviewctrl/getInterview/33873847596
 */

public class TheMaxOfMinima {

    public static void main(String[] args) {
        System.out.println(bestDay(8, new int[]{62, 64, 77, 75, 71, 60, 79, 75}, 4));
    }

    private static int bestDay(int n, int[] temps, int k) {
        int[] sTree = new int[4 * n];
        buildTree(temps, 0, n - 1, sTree, 0);
        int best = Integer.MIN_VALUE;
        for (int i = 0; i < n - k; i++) {
            best = Math.max(best, query(i, i + k - 1, sTree, 0, n - 1, 0));
        }
        return best;
    }

    private static int query(int qs, int qe, int[] sTree, int s, int e, int idx) {
        if (qe < s || qs > e) return Integer.MAX_VALUE;
        if (qs <= s && e <= qe) return sTree[idx];
        if (s == e) return sTree[idx];
        int mid = (s + e) / 2, left = 2 * idx + 1, right = 2 * idx + 2;
        return Math.min(query(qs, qe, sTree, s, mid, left), query(qs, qe, sTree, mid + 1, e, right));
    }

    private static void buildTree(int[] temps, int s, int e, int[] sTree, int idx) {
        if (s == e) {
            sTree[idx] = temps[s];
        } else {
            int mid = (s + e) / 2, left = 2 * idx + 1, right = 2 * idx + 2;
            buildTree(temps, s, mid, sTree, left);
            buildTree(temps, mid + 1, e, sTree, right);
            sTree[idx] = Math.min(sTree[left], sTree[right]);
        }
    }
}

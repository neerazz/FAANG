package contest1490;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * Created on:  Feb 16, 2021
 * Questions: https://codeforces.com/contest/1490/problem/D
 */

public class PermutationTransformation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            getLevels(n, nums);
        }
    }

    private static void getLevels(int n, int[] nums) {
        int[] sTree = new int[4 * n];
        buildSTree(nums, 0, n - 1, sTree, 0);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, n - 1, 0});
        int[] levels = new int[n];
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int start = poll[0], end = poll[1], level = poll[2];
            int maxIdx = query(sTree, start, end, 0, n - 1, 0, nums);
            levels[maxIdx] = level;
//            System.out.println(String.format("[%d,%d]. L:%d, MaxIDx: %d", start, end, level, maxIdx));
            if (maxIdx > start) queue.add(new int[]{start, maxIdx - 1, level + 1});
            if (maxIdx < end) queue.add(new int[]{maxIdx + 1, end, level + 1});
        }
        System.out.println(Arrays.stream(levels).boxed().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static int query(int[] sTree, int qs, int qe, int s, int e, int i, int[] nums) {
        if (e < qs || qe < s) return -1;
        if (qs <= s && e <= qe) return sTree[i];
        int m = s + (e - s) / 2, l = 2 * i + 1, r = 2 * i + 2;
        int lIdx = query(sTree, qs, qe, s, m, l, nums), rIdx = query(sTree, qs, qe, m + 1, e, r, nums);
        if (lIdx == -1) return rIdx;
        if (rIdx == -1) return lIdx;
        return nums[lIdx] > nums[rIdx] ? lIdx : rIdx;
    }

    private static void buildSTree(int[] nums, int s, int e, int[] sTree, int i) {
        if (s == e) {
            sTree[i] = s;
        } else {
            int m = s + (e - s) / 2, l = 2 * i + 1, r = 2 * i + 2;
            buildSTree(nums, s, m, sTree, l);
            buildSTree(nums, m + 1, e, sTree, r);
            int lIdx = sTree[l], rIdx = sTree[r];
            if (nums[lIdx] > nums[rIdx]) {
                sTree[i] = lIdx;
            } else {
                sTree[i] = rIdx;
            }
        }
    }
}

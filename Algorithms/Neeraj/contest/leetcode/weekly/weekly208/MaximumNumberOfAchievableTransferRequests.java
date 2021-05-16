package weekly.weekly208;

import java.util.Map;
import java.util.Queue;

/**
 * Created on:  Sep 26, 2020
 * Questions: https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/
 */
public class MaximumNumberOfAchievableTransferRequests {
    static int count;

    public static void main(String[] args) {
        System.out.println(maximumRequests(5, new int[][]{{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}}) + " = 5");
        System.out.println(maximumRequests(3, new int[][]{{0, 0}, {1, 2}, {2, 1}}) + " = 3");
        System.out.println(maximumRequests(4, new int[][]{{0, 3}, {3, 1}, {1, 2}, {2, 0}}) + " = 4");
    }

    public static int maximumRequests(int n, int[][] requests) {
        count = 0;
        int[] counts = new int[n];
        helper(requests, 0, counts, 0);
        return count;
    }

    private static void helper(int[][] requests, int idx, int[] counts, int total) {
        if (idx == requests.length) {
//            Once you reach the end, validate if any counts have non-zeros. Means invalid transfer.
            for (int c : counts) if (c != 0) return;
            count = Math.max(count, total);
            return;
        }
//        Try to make current transfer. So reduce the count in from and increase in to
        counts[requests[idx][0]]--;
        counts[requests[idx][1]]++;
        helper(requests, idx + 1, counts, total + 1);
        counts[requests[idx][0]]++;
        counts[requests[idx][1]]--;
        helper(requests, idx + 1, counts, total);
    }

    private static void dfs(int start, Map<Integer, Queue<Integer>> map) {
        Queue<Integer> deps = map.get(start);
        while (!deps.isEmpty()) {
            int child = deps.poll();
            if (map.get(child).isEmpty()) continue;
            count++;
            dfs(child, map);
        }
    }
}

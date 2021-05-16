package weekly.weekly231;

import java.util.*;

/**
 * Created on:  Mar 06, 2021
 * Questions:
 */

public class NumberOfRestrictedPathsFromFirstToLastNode {

    public static void main(String[] args) {
        System.out.println(countRestrictedPaths(5, new int[][]{{1, 2, 3}, {1, 3, 3}, {2, 3, 1}, {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}}) + " = 3");
        System.out.println(countRestrictedPaths(7, new int[][]{{1, 3, 1}, {4, 1, 2}, {7, 3, 4}, {2, 5, 3}, {5, 6, 1}, {6, 7, 2}, {7, 5, 3}, {2, 6, 4}}) + " = 1");
    }

    static int mod = 1_000_000_007;

    public static int countRestrictedPaths(int n, int[][] edges) {
        Map<Integer, Set<int[]>> graph = new HashMap<>();
        int[] best = new int[n + 1];
        Arrays.fill(best, Integer.MAX_VALUE);
        best[0] = best[n] = 0;
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph.get(from).add(new int[]{to, edge[2]});
            graph.get(to).add(new int[]{from, edge[2]});
        }
        processBest(n, best, graph);
        Long[] dp = new Long[n + 1];
        long result = path(1, graph, best, n, dp);
        return (int) result;
    }

    private static void processBest(int n, int[] best, Map<Integer, Set<int[]>> graph) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((v1, v2) -> Integer.compare(v1[1], v2[1]));
        queue.add(new int[]{n, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cur = poll[0], d = poll[1];
            if (best[cur] < d) continue;
            for (int[] dep : graph.get(cur)) {
                if (best[dep[0]] > d + dep[1]) {
                    best[dep[0]] = d + dep[1];
                    queue.add(new int[]{dep[0], best[dep[0]]});
                }
            }
        }
    }

    private static long path(int cur, Map<Integer, Set<int[]>> graph, int[] best, int n, Long[] dp) {
        if (cur == n) return 1;
        if (dp[cur] != null) return dp[cur];
        dp[cur] = 0L;
        for (int[] dep : graph.get(cur)) {
            int next = dep[0];
            if (best[cur] > best[next]) {
                dp[cur] = (dp[cur] + path(next, graph, best, n, dp)) % mod;
            }
        }
        return dp[cur];
    }
}

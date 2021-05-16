package weekly.weekly220;

import java.util.*;

/**
 * Created on:  Dec 19, 2020
 * Questions:
 */

public class CheckingExistenceOfEdgeLengthLimitedPaths {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distanceLimitedPathsExist(3, new int[][]{{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}}, new int[][]{{0, 1, 2}, {0, 2, 5}})));
    }

//    https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/discuss/978509/Java-Sort-and-then-Union-Find-Disjoint-Set
    public static boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[][] lens = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(lens[i], Integer.MAX_VALUE);
            lens[i][i] = 0;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edgeList) {
            int from = edge[0], to = edge[1];
            lens[from][to] = lens[to][from] = Math.min(lens[from][to], edge[2]);
            graph.computeIfAbsent(from, val -> new HashSet<>()).add(to);
            graph.computeIfAbsent(to, val -> new HashSet<>()).add(from);
        }
//        calculateAllDistances(lens, n);
        boolean[][] visited = new boolean[n][n];
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int maxPath = getMaxLen(lens, query[0], query[1], graph, visited);
            result[i] = maxPath < query[2];
        }
        return result;
    }

    private static int getMaxLen(int[][] lens, int s, int e, Map<Integer, Set<Integer>> graph, boolean[][] visited) {
        if (s == e) return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int dep : graph.getOrDefault(poll, new HashSet<>())) {
                int val = Math.max(lens[s][poll], lens[poll][dep]);
                if (val < lens[s][dep]) {
                    visited[s][dep] = false;
                    lens[s][dep] = val;
                }
                if (!visited[s][dep]) {
                    queue.add(dep);
                    visited[s][dep] = true;
                }
            }
        }
        return lens[s][e];
    }

    private static void calculateAllDistances(int[][] lens, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
//                    Find path from i to j via k.
                    if (lens[i][k] == Integer.MAX_VALUE || lens[k][j] == Integer.MAX_VALUE) continue;
                    lens[i][j] = Math.min(lens[i][j], Math.max(lens[i][k], lens[k][j]));
                }
            }
        }
    }
}

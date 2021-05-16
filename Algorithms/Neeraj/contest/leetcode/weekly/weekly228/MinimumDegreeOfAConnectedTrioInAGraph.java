package weekly.weekly228;

import java.util.*;

/**
 * Created on:  Feb 13, 2021
 * Questions:
 */

public class MinimumDegreeOfAConnectedTrioInAGraph {

    public static void main(String[] args) {
        System.out.println(minTrioDegree(6, new int[][]{{1, 2}, {1, 3}, {3, 2}, {4, 1}, {5, 2}, {3, 6}}));
        System.out.println(minTrioDegree_rev2(6, new int[][]{{1, 2}, {1, 3}, {3, 2}, {4, 1}, {5, 2}, {3, 6}}));
    }

    static int min;

    public static int minTrioDegree_rev2(int n, int[][] edges) {
        boolean[][] connected = new boolean[n + 1][n + 1];
        int[] degree = new int[n + 1];
        min = Integer.MAX_VALUE;
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            connected[from][to] = connected[to][from] = true;
            degree[from]++;
            degree[to]++;
        }
        for (int i = 1; i <= n; i++) {
            if (degree[i] < 2) continue;
            for (int j = i + 1; j <= n; j++) {
                if (!connected[i][j] || degree[i] < 2) continue;
                for (int k = j + 1; k <= n; k++) {
                    if (connected[j][k] && connected[k][i]) {
                        int score = degree[i] - 2 + degree[j] - 2 + degree[k] - 2;
                        min = Math.min(min, score);
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static int minTrioDegree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] degree = new int[n + 1];
        min = Integer.MAX_VALUE;
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if (from == to) continue;
            map.computeIfAbsent(from, val -> new HashSet<>()).add(to);
            map.computeIfAbsent(to, val -> new HashSet<>()).add(from);
            degree[from]++;
            degree[to]++;
        }
        for (int i = 1; i <= n; i++) {
            dfs(i, i, i, map, degree[i], degree, 0);
        }
        return min == Integer.MAX_VALUE ? -1 : min - 6;
    }

    private static void dfs(int cur, int par, int start, Map<Integer, Set<Integer>> map, int sum, int[] degree, int count) {
        if (sum >= min) return;
        for (int dep : map.getOrDefault(cur, new HashSet<>())) {
            if (dep == par) continue;
            if (count == 2) {
                if (start == dep) min = Math.min(min, sum);
            } else if (count < 2) {
                dfs(dep, cur, start, map, sum + degree[dep], degree, count + 1);
            }
        }
    }
}

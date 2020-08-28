import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created on:  Jul 26, 2020
 * Questions: https://leetcode.com/problems/is-graph-bipartite/
 */
public class IsGraphBipartite {
    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}) + " = true");
        System.out.println(isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}) + " = false");
        System.out.println(isBipartite(new int[][]{{}, {2, 4, 6}, {1, 4, 8, 9}, {7, 8}, {1, 2, 8, 9}, {6, 9}, {1, 5, 7, 8, 9}, {3, 6, 9}, {2, 3, 4, 6, 9}, {2, 4, 5, 6, 7, 8}}) + " = false");
        System.out.println(isBipartite(new int[][]{{4}, {}, {4}, {4}, {0, 2, 3}}) + " = true");
        System.out.println(isBipartite(new int[][]{{4, 1}, {0, 2}, {1, 3}, {2, 4}, {3, 0}}) + " = false");
    }

    public static boolean isBipartite(int[][] graph) {
        Map<Integer, Set<Integer>> graphMap = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int dep : graph[i]) {
                set.add(dep);
            }
            graphMap.put(i, set);
        }
        int[] cols = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (cols[i] == 0 && !dfs(graphMap, i, -1, cols)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(Map<Integer, Set<Integer>> map, int cur, int val, int[] dp) {
        if (dp[cur] != 0) return dp[cur] == val;
        dp[cur] = val;
        for (int dep : map.get(cur)) {
            if (!dfs(map, dep, val == -1 ? 1 : -1, dp)) {
                return false;
            }
        }
        return true;
    }
}

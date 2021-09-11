import java.util.*;

/**
 * Created on:  May 31, 2021
 * Questions: https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/
 */

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {

    static int remove;

    public static void main(String[] args) {
        System.out.println(maxNumEdgesToRemove(4, new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}}) + " = 2");
        System.out.println(maxNumEdgesToRemove(4, new int[][]{{3, 1, 2}, {3, 2, 3}, {1, 1, 4}, {2, 1, 4}}) + " = 0");
        System.out.println(maxNumEdgesToRemove(4, new int[][]{{3, 2, 3}, {1, 1, 2}, {2, 3, 4}}) + " = -1");
    }

    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        remove = 0;
//        Build edges with only type 3.
        Set<String> threeEdges = new HashSet<>();
        buildThreeEdges(n, edges, threeEdges);
        return remove;
    }

    private static void buildThreeEdges(int n, int[][] edges, Set<String> threeEdges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                graph.computeIfAbsent(edge[1], val -> new ArrayList<>()).add(edge[2]);
                graph.computeIfAbsent(edge[2], val -> new ArrayList<>()).add(edge[1]);
            }
        }
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            dfs(graph, i, threeEdges, visited);
        }
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int cur, Set<String> threeEdges, boolean[] visited) {
        visited[cur] = true;
        for (int dep : graph.getOrDefault(cur, new ArrayList<>())) {
            if (visited[dep]) {
                remove++;
            } else if (!visited[dep]) {
                dfs(graph, dep, threeEdges, visited);
            }
            if (!threeEdges.contains(cur + "-" + dep)) {
                threeEdges.add(cur + "-" + dep);
                threeEdges.add(dep + "-" + cur);
            }
        }
    }

    static class UnionFind {

    }
}

package weekly.weekly197;

import java.util.*;

/**
 * Created on:  Jul 11, 2020
 * Questions: https://leetcode.com/problems/path-with-maximum-probability
 * Path with Maximum Probability
 */
public class PathWithMaximumProbability {
    public static void main(String[] args) {
        System.out.println(maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2}, 0, 2));
        System.out.println(maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.3}, 0, 2));
        System.out.println(maxProbability(3, new int[][]{{0, 1}}, new double[]{0.5}, 0, 2));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Set<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < succProb.length; i++) {
            int[] con = edges[i];
            graph.get(con[0]).add(new int[]{con[1], i});
            graph.get(con[1]).add(new int[]{con[0], i});
        }
//        Bellman Ford
        double[] result = new double[n];
        result[start] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
//            Travers through all the linked value.
            for (int[] next : graph.get(poll)) {
//                If the already distance from source to next node is calculated and if the probability is more than the current then dont take that path.
                if (result[poll] * succProb[next[1]] > result[next[0]]) {
                    result[next[0]] = result[poll] * succProb[next[1]];
                    queue.add(next[0]);
                }
            }
        }
        return result[end];
//        DFS is wrong answer
//        Set<Integer> visited = new HashSet<>();
//        Double[][] dp = new Double[n + 1][n + 1];
//        return dfs(graph, prob, visited, start, end, dp);
    }

    /**
     * @param visited Previously visited paths
     * @implNote This is a wrong solution because: in memoization, we keep the maximum probability from point a to b. <p>
     * This will be wrong when a node in the best path, is previously visited.
     * Ex: best path from d to f can be (d->b->g->h->i->f), if you are coming from path (a -> b -> d) then trying to find the best path to f, then dfs will not go to b as it is already visited.
     * a <-> b <-> d <-> e <-> f &
     * b <->  g <-> h <-> i <-> f
     */
    private static double dfs(Map<Integer, Set<Integer>> graph, double[][] prob, Set<Integer> visited, int start, int end, Double[][] dp) {
        double dist = 0;
        if (dp[start][end] != null) return dp[start][end];
        visited.add(start);
        for (int next : graph.get(start)) {
            if (next == end) {
                dist = Math.max(dist, prob[start][next]);
            } else if (!visited.contains(next)) {
                double nextVal = dfs(graph, prob, visited, next, end, dp);
                dist = Math.max(dist, prob[start][next] * nextVal);
            }
        }
        visited.remove(start);
        return dp[start][end] = dist;
    }
}

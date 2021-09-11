import java.util.*;

/**
 * Created on:  Mar 05, 2021
 * Questions: https://leetcode.com/problems/shortest-path-with-alternating-colors/
 */

public class ShortestPathWithAlternatingColors {

    public static void main(String[] args) {

    }

    public static int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[][] dist = new int[n][2];
        for (int[] dis : dist) {
            Arrays.fill(dis, Integer.MAX_VALUE);
        }
        dist[0] = new int[]{0, 0};
        Map<Integer, Set<Integer>> red = buildGraph(red_edges);
        Map<Integer, Set<Integer>> blue = buildGraph(blue_edges);
        Queue<int[]> queue = new LinkedList<>();
        // 0: node, 1 : dist, 2 : col (0 -> red, 1 -> blue)
        queue.add(new int[]{0, 0, 0});
        queue.add(new int[]{0, 0, 1});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int node = poll[0], d = poll[1], col = poll[2];
            int nextCol = col ^ 1;
            if (col == 0) {
//                 previous path was red
                for (int dep : blue.getOrDefault(node, new HashSet<>())) {
                    if (dist[dep][nextCol] == Integer.MAX_VALUE) {
                        dist[dep][nextCol] = d + 1;
                        queue.add(new int[]{dep, d + 1, nextCol});
                    }
                }
            } else {
//                 previous path was blue
                for (int dep : red.getOrDefault(node, new HashSet<>())) {
                    if (dist[dep][nextCol] == Integer.MAX_VALUE) {
                        dist[dep][nextCol] = d + 1;
                        queue.add(new int[]{dep, d + 1, nextCol});
                    }
                }
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int min = Math.min(dist[i][0], dist[i][1]);
            result[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return result;
    }

    private static Map<Integer, Set<Integer>> buildGraph(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], val -> new HashSet<>()).add(edge[1]);
        }
        return map;
    }
}

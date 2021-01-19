import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 19, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-oa2/min-cost-to-repair-edges
 */

public class MinCostToRepairEdges {

    public static void main(String[] args) {
        System.out.println(minCostToRepairEdges(8, new int[][]{{1, 2}, {4, 5}, {5, 7}, {6, 7}, {7, 8}},
                new int[][]{{2, 4, 100}, {2, 4, 16}, {2, 3, 7}, {2, 5, 15}, {3, 8, 17}}) + " = 22");
        System.out.println(minCostToRepairEdges(8, new int[][]{},
                new int[][]{{1, 4, 100}, {2, 4, 10}, {2, 3, 7}, {2, 5, 15}, {2, 1, 17}, {5, 3, 1}}) + " = -1");
        System.out.println(minCostToRepairEdges(1, new int[][]{}, new int[][]{}) + " = -1");
    }

    public static int minCostToRepairEdges(int n, int[][] edges, int[][] edgesToRepair) {
        if(edges == null || edgesToRepair == null) return -1;
        if (n == 0) return 0;
        Set<Integer>[] graph = new HashSet[n + 1];
        int[][] costs = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        for (int[] repair : edgesToRepair) {
            int from = repair[0], to = repair[1], cost = repair[2];
            graph[from].add(to);
            graph[to].add(from);
            if (costs[from][to] == 0) {
                costs[from][to] = costs[to][from] = cost;
            } else {
                costs[from][to] = costs[to][from] = Math.min(cost, costs[from][to]);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> Integer.compare(v1[1], v2[1]));
        Set<Integer> visited = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            addNode(i, graph, pq, visited, costs);
            if (!pq.isEmpty()) break;
        }
        addNode(1, graph, pq, visited, costs);
        int cost = 0;
        while (visited.size() < n && !pq.isEmpty()) {
            int[] poll = pq.poll();
            if (visited.contains(poll[0])) continue;
            cost += poll[1];
            addNode(poll[0], graph, pq, visited, costs);
        }
        return visited.size() == n ? cost : -1;
    }

    private static void addNode(int from, Set<Integer>[] graph, PriorityQueue<int[]> pq, Set<Integer> visited, int[][] costs) {
        Set<Integer> cons = graph[from];
        if (cons.isEmpty()) return;
        visited.add(from);
        for (int to : cons) {
            if (visited.contains(to)) continue;
            pq.add(new int[]{to, costs[from][to]});
        }
    }
}

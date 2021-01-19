import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 19, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-oa2-min-cost-to-add-new-roads
 */

public class MinCostToAddNewRoads {

    public static void main(String[] args) {

    }

    public static int minCostConnectNodes(int n, int[][] connects) {
        if (n == 0) return 0;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Comparator<int[]> sort = (c1, c2) -> Integer.compare(c1[1], c2[1]);
        int[][] costs = new int[n + 1][n + 1];
        for (int[] cost : costs) Arrays.fill(cost, Integer.MAX_VALUE);
//        0: from, 1: to, 2: cost
        for (int[] con : connects) {
            int from = con[0], to = con[1], cost = con[2];
            if (from == to) continue;
            graph.computeIfAbsent(from, val -> new HashSet<>()).add(to);
            graph.computeIfAbsent(to, val -> new HashSet<>()).add(from);
            costs[from][to] = costs[to][from] = Math.min(costs[from][to], cost);
        }
        Set<Integer> processed = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(sort);
        long cost = 0;
        for (int from : graph.keySet()) {
            addNode(from, graph, processed, pq, costs);
            break;
        }
        while (processed.size() < n && !pq.isEmpty()) {
            int[] poll = pq.poll();
            if (processed.contains(poll[0])) continue;
            cost += poll[1];
            addNode(poll[0], graph, processed, pq, costs);
        }
        return processed.size() == n ? (int) cost : -1;
    }

    private static void addNode(int from, Map<Integer, Set<Integer>> graph, Set<Integer> processed, PriorityQueue<int[]> pq, int[][] costs) {
        processed.add(from);
        for (int to : graph.get(from)) {
            pq.add(new int[]{to, costs[from][to]});
        }
    }
}

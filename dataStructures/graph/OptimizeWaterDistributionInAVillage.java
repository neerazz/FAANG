import java.util.*;

/**
 * Created on:  Aug 03, 2021
 * Ref : https://leetcode.com/problems/optimize-water-distribution-in-a-village/
 */
public class OptimizeWaterDistributionInAVillage {
    public static void main(String[] args) {
        System.out.println(minCostToSupplyWater(5, new int[]{46012, 72474, 64965, 751, 33304}, new int[][]{{2, 1, 6719}, {3, 2, 75312}, {5, 3, 44918}}));
    }

    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[1], p2[1]));
        for (int i = 1; i <= n; i++) {
//            map.computeIfAbsent(0, val -> new ArrayList<>()).add(new int[]{i, wells[i - 1]});
            pq.add(new int[]{i, wells[i - 1]});
        }
        for (int[] pipe : pipes) {
            int from = pipe[0], to = pipe[1], cost = pipe[2];
            map.computeIfAbsent(from, val -> new ArrayList<>()).add(new int[]{to, cost});
            map.computeIfAbsent(to, val -> new ArrayList<>()).add(new int[]{from, cost});
        }
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        int total = 0, processed = 0;
        while (processed < n && !pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0], cost = poll[1];
            if (visited[cur]) continue;
            visited[cur] = true;
            total += cost;
            for (int[] deps : map.getOrDefault(cur, new ArrayList<>())) {
                if (!visited[deps[0]]) {
                    pq.add(deps);
                }
            }
            processed++;
        }
        return processed == n ? total : -1;
    }
}

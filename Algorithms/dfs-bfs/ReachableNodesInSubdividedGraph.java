import java.util.*;

/**
 * Created on:  Sep 12, 2021
 * Ref: https://leetcode.com/problems/reachable-nodes-in-subdivided-graph
 */
public class ReachableNodesInSubdividedGraph {

    public static void main(String[] args) {
        System.out.println(reachableNodes(new int[][]{{0, 1, 10}, {0, 2, 1}, {1, 2, 2}}, 6, 3) + " = 13");
        System.out.println(reachableNodes(new int[][]{{0, 2, 3}, {0, 4, 4}, {2, 3, 8}, {1, 3, 5}, {0, 3, 9}, {3, 4, 6}, {0, 1, 5}, {2, 4, 6}, {1, 2, 3}, {1, 4, 1}}, 8, 5) + " = 43");
    }

    public static int reachableNodes(int[][] edges, int maxMoves, int n) {
        int count = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[][] vals = new int[n][n];
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], dist = edge[2];
            vals[from][to] = vals[to][from] = dist;
            map.get(from).add(to);
            map.get(to).add(from);
        }
        boolean[] visited = new boolean[n];
//        0: node, 1: moves. Sort based on remaining moves.
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n2[1], n1[1]));
        pq.add(new int[]{0, maxMoves});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0], moves = poll[1];
            if (visited[cur]) continue;
            visited[cur] = true;
            count++;
            if (moves < 0) continue;
//            Start exploring the neighbours.
            for (int next : map.get(cur)) {
                int cost = vals[cur][next];
                if (cost < 0) continue;
                if (moves > cost && !visited[next]) {
                    pq.add(new int[]{next, moves - cost - 1});
                }
                int allowed = Math.min(cost, moves);
                vals[cur][next] = vals[next][cur] -= allowed;
                count += allowed;
            }
        }
        return count;
    }
}

package biweekly.biweekly33;

import java.util.*;

/**
 * Created on:  Aug 22, 2020
 * Questions: https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 */
public class MinimumNumberOfVerticesToReachAllNodes {
    public static void main(String[] args) {
        System.out.println(findSmallestSetOfVertices(3, Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 0), Arrays.asList(0, 2))) + " -> " +
                findSmallestSetOfVertices_optimal(3, Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 0), Arrays.asList(0, 2))));
        System.out.println(findSmallestSetOfVertices(4, Arrays.asList(Arrays.asList(2, 0), Arrays.asList(0, 3), Arrays.asList(3, 1))) + " -> " +
                findSmallestSetOfVertices_optimal(4, Arrays.asList(Arrays.asList(2, 0), Arrays.asList(0, 3), Arrays.asList(3, 1))));
    }

    public static List<Integer> findSmallestSetOfVertices_optimal(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        for (List<Integer> edge : edges) {
            indegree[edge.get(1)]++;
        }
        List<Integer> op = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) op.add(i);
        }
        return op;
    }

    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (List<Integer> edge : edges) {
            map.computeIfAbsent(edge.get(0), val -> new HashSet<>()).add(edge.get(1));
        }
        boolean[] visited;
//        0: node, 1: outbounds
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v2[1] - v1[1]);
//        Get how many nodes can be visited from one node and sort based on that.
        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            counts[i] = getCount(i, visited, map);
            pq.add(new int[]{i, counts[i]});
        }
        visited = new boolean[n];
        List<Integer> op = new ArrayList<>();
        while (!pq.isEmpty()) {
            int poll = pq.poll()[0];
            if (!visited[poll]) {
                op.add(poll);
                dfs(poll, visited, map);
            }
        }
        return op;
    }

    private static int getCount(int start, boolean[] visited, Map<Integer, Set<Integer>> map) {
        if (visited[start]) return 0;
        visited[start] = true;
        int cur = 1;
        for (int dep : map.getOrDefault(start, new HashSet<>())) {
            cur += getCount(dep, visited, map);
        }
        return cur;
    }

    private static void dfs(int start, boolean[] visited, Map<Integer, Set<Integer>> map) {
        if (visited[start]) return;
        visited[start] = true;
        for (int dep : map.getOrDefault(start, new HashSet<>())) {
            dfs(dep, visited, map);
        }
    }
}

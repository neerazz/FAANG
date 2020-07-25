import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created on:  Jul 24, 2020
 * Questions: https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/practice-problems/algorithm/minimum-spanning-tree-5/description/
 */
public class MinimumSpanningTree {
    public static void main(String[] args) throws IOException {
//        FastReader fr = new FastReader();
        FastReader fr = new FastReader(new URL("https://he-s3.s3.amazonaws.com/media/hackathon/question-for-new-practice-section/problems/bab08ec4-0-input-bab02c0.txt?Signature=54NVb9jT6Xbno%2BhZW7g5Ao04hD4%3D&Expires=1595654936&AWSAccessKeyId=AKIA6I2ISGOYH7WWS3G5"));
        int nodes = fr.nextInt();
        int edges = fr.nextInt();
        int[][] connections = new int[edges][3];
        for (int i = 0; i < edges; i++) {
            connections[i] = new int[]{fr.nextInt(), fr.nextInt(), fr.nextInt()};
        }
        System.out.println(getMiniMumSpanningTreeCostUsingPrimsAlgorithum(connections, nodes));
        System.out.println(getMiniMumSpanningTreePathUsingPrimsAlgorithum(connections, nodes));
    }

    private static long getMiniMumSpanningTreeCostUsingPrimsAlgorithum(int[][] connections, int n) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[][] costs = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        for (int[] con : connections) {
            int from = con[0], to = con[1], cost = con[2];
            graph.get(from).add(to);
            graph.get(to).add(from);
            costs[from][to] = costs[to][from] = Math.min(costs[from][to], cost);
        }
//        0 : node, 1 : cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        Set<Integer> visited = new HashSet<>();
        addEdges(graph, 1, visited, pq, costs);
        long cost = 0;
        while (visited.size() < n && !pq.isEmpty()) {
            int[] poll = pq.poll();
            if (visited.contains(poll[0])) continue;
            cost += poll[1];
            addEdges(graph, poll[0], visited, pq, costs);
        }
        return cost;
    }

    private static void addEdges(Map<Integer, Set<Integer>> graph, int start, Set<Integer> visited, PriorityQueue<int[]> pq, int[][] costs) {
        visited.add(start);
        for (int dep : graph.get(start)) {
            if (!visited.contains(dep)) {
                pq.add(new int[]{dep, costs[start][dep]});
            }
        }
    }

    /**
     * @param connections array of connections Ex: [ start, end, 0]
     * @return [a, b, c, d]
     */
    private static List<String> getMiniMumSpanningTreePathUsingPrimsAlgorithum(int[][] connections, int n) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[][] costs = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        for (int[] con : connections) {
            int from = con[0], to = con[1], cost = con[2];
            graph.get(from).add(to);
            graph.get(to).add(from);
            costs[from][to] = costs[to][from] = Math.min(costs[from][to], cost);
        }
//        0 : node, 1 : cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        Set<Integer> visited = new HashSet<>();
        addEdges(graph, 1, visited, pq, costs);
        List<String> op = new ArrayList<>();
        while (visited.size() < n && !pq.isEmpty()) {
            int[] poll = pq.poll();
            if (visited.contains(poll[0])) continue;
            op.add(poll[0] + " -> ");
            addEdges(graph, poll[0], visited, pq, costs);
        }
        return op;
    }
}

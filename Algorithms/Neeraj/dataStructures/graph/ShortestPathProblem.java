import java.io.IOException;
import java.util.*;

/**
 * Created on:  Jul 29, 2020
 * Questions: https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/tutorial/
 */
public class ShortestPathProblem {
    public static void main(String[] args) throws IOException {
//        FastReader fr = new FastReader("D:\\JavaProjects\\FAANG\\Algorithms\\Neeraj\\dataStructures\\graph\\hugeGraphData.txt");
        FastReader fr = new FastReader();
        int v = fr.nextInt(), e = fr.nextInt();
        int[][] edges = new int[e][3];
        for (int i = 0; i < e; i++) {
            edges[i] = new int[]{fr.nextInt(), fr.nextInt(), fr.nextInt()};
        }
        int[] distances = getShortestPathFromAllNodesWithBellmanFord(v, e, edges);
        System.out.println("Distances from 1: \n\t" + Arrays.toString(distances));
        distances = getShortestPathFromAllNodesWithDijkstrasAlgorithm(v, e, edges);
        System.out.println("Distances from 1: \n\t" + Arrays.toString(distances));
        int[][] allPathDistances = getDistancesFromAllNodesWithFloydWarshall(v, e, edges);
        System.out.println("Distances between all points:");
        Arrays.stream(allPathDistances).forEach(arr -> System.out.println("\t" + Arrays.toString(arr)));
        for (int i = 1; i <= v; i++) {
            if (distances[i] != allPathDistances[1][i]) {
                System.out.println("There is an error in calculating the distance. Distance from 1 to " + i + " should be :" + distances[i] + " but it is : " + allPathDistances[1][i]);
            }
        }
    }

    private static int[][] getDistancesFromAllNodesWithFloydWarshall(int v, int e, int[][] edges) {
        int[][] distances = new int[v + 1][v + 1];
        int[][] parent = new int[v + 1][v + 1];
//        Prepopulate the distances from the given edge.
        for (int i = 1; i <= v; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
//            Set the diagonal distance value to 0.
            distances[i][i] = 0;
            Arrays.fill(parent[i], Integer.MAX_VALUE);
        }
        int level = 0;
        for (int[] edge : edges) {
            distances[edge[0]][edge[1]] = edge[2];
//            Set the path to the level.
            parent[edge[0]][edge[1]] = level++;
        }

//        Loop through all the matrix by travelling from(j), to(k), via(i). And check if a shorter distance is found.
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                for (int k = 1; k <= v; k++) {
                    if (distances[j][i] == Integer.MAX_VALUE || distances[i][k] == Integer.MAX_VALUE) {
                        continue;
                    }
//                    Check if traveled from(j), to(k), via(i). Is shorter. Then update the value.
                    if (distances[j][k] > distances[j][i] + distances[i][k]) {
                        distances[j][k] = distances[j][i] + distances[i][k];
//                        The new shortest path from j to k (j->k = j->i + i->k), so the parent path will be i->k.
                        parent[j][k] = parent[i][k];
                    }
                }
            }
        }

//        We have updated the diagonal values to 0, initially.
//          While calculating the shortest path if the diagonal values goes below zero, then there is a negative weighted cycle.
        for (int i = 1; i <= v; i++) {
            if (distances[i][i] < 0) {
                System.out.println("It have a negative Path.");
            }
        }
        return distances;
    }

    // Find the shortest distance from vertex 1, to all nodes using BellmanFord Algorithum.
    private static int[] getShortestPathFromAllNodesWithBellmanFord(int v, int e, int[][] edges) {
        int[] costs = new int[v + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[0] = costs[1] = 0;
//        Integer[] parent = new Integer[v + 1];

//        Loop v-1 time in the given edges to find the starting distance from 1.
        for (int i = 0; i < v - 1; i++) {
//            System.out.println(" Calculating Vertex  = " + i);
            for (int[] edge : edges) {
//                System.out.println("edge = " + Arrays.toString(edge));
                int from = edge[0], to = edge[1], cost = edge[2];
//                If the calculated cost is greater than the cost for current travel, and over ride the cost, and the parent.
                if (costs[from] != Integer.MAX_VALUE && costs[to] > costs[from] + cost) {
                    costs[to] = costs[from] + cost;
//                    parent[to] = from;
                }
            }
        }

//        The above loop guaranties to give a shortest path. Try doing the calculation again.
//          If you find a lowest path again, that means that there is a negative path.
//              https://www.geeksforgeeks.org/detect-negative-cycle-graph-bellman-ford/
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], cost = edge[2];
//                If the calculated cost is greater than the cost for current travel, and over ride the cost, and the parent.
            if (costs[to] > costs[from] + cost) {
                System.out.println("It have a negative Path.");
            }
        }

        return costs;
    }

    //    Find the distance from 1 to all the indexes.
    private static int[] getShortestPathFromAllNodesWithDijkstrasAlgorithm(int v, int e, int[][] edges) {
        int[] costs = new int[v + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[0] = costs[1] = 0;
//        Keep all the connected vertices in a map.
        Map<Integer, Set<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], cost = edge[2];
            graph.computeIfAbsent(from, val -> new HashSet<>()).add(new int[]{to, cost});
            graph.computeIfAbsent(to, val -> new HashSet<>()).add(new int[]{from, cost});
        }
//        0: distance, 1:node
        PriorityQueue<int[]> queue = new PriorityQueue<>((v1, v2) -> v1[0] == v2[0] ? v1[1] - v2[1] : v1[0] - v2[0]);
        queue.add(new int[]{0, 1});
        boolean[] visited = new boolean[v + 1];
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curNode = poll[1], curDistance = poll[0];
            if (visited[curNode]) continue;
            visited[curNode] = true;
            for (int[] dep : graph.getOrDefault(curNode, new HashSet<>())) {
                if (costs[dep[0]] > dep[1] + curDistance) {
                    queue.add(new int[]{costs[dep[0]] = dep[1] + curDistance, dep[0]});
                }
            }
        }
        return costs;
    }
}

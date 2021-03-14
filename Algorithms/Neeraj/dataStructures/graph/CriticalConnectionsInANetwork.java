import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * Created on:  Mar 11, 2021
 * Questions: https://leetcode.com/problems/critical-connections-in-a-network/
 */

public class CriticalConnectionsInANetwork {

    public static void main(String[] args) {
        System.out.println(criticalConnections(10, buildList(new int[][]{{1, 0}, {2, 0}, {3, 0}, {4, 1}, {5, 3}, {6, 1}, {7, 2}, {8, 1}, {9, 6}, {9, 3}, {3, 2}, {4, 2}, {7, 4}, {6, 2}, {8, 3}, {4, 0}, {8, 6}, {6, 5}, {6, 3}, {7, 5}, {8, 0}, {8, 5}, {5, 4}, {2, 1}, {9, 5}, {9, 7}, {9, 4}, {4, 3}})));
        System.out.println(ArticulationPointsAndBridges.getBridges(10, buildboolean(10, new int[][]{{1, 0}, {2, 0}, {3, 0}, {4, 1}, {5, 3}, {6, 1}, {7, 2}, {8, 1}, {9, 6}, {9, 3}, {3, 2}, {4, 2}, {7, 4}, {6, 2}, {8, 3}, {4, 0}, {8, 6}, {6, 5}, {6, 3}, {7, 5}, {8, 0}, {8, 5}, {5, 4}, {2, 1}, {9, 5}, {9, 7}, {9, 4}, {4, 3}})));
    }

    private static boolean[][] buildboolean(int n, int[][] cons) {
        boolean[][] edges = new boolean[n][n];
        for (int[] con : cons) {
            edges[con[0]][con[1]] = edges[con[1]][con[0]] = true;
        }
        return edges;
    }

    private static List<List<Integer>> buildList(int[][] cons) {
        return Arrays.stream(cons).map(con -> Arrays.asList(con[0], con[1])).collect(Collectors.toList());
    }

    static int discovery;

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        discovery = 0;
        int[] lows = new int[n], dis = new int[n];
        Map<Integer, List<Integer>> graph = buildGraph(n, connections);
        List<List<Integer>> criticalBridge = new ArrayList<>();
        boolean[] visited = new boolean[n];
        getConnections(0, -1, lows, dis, graph, criticalBridge, visited);
        return criticalBridge;
    }

    private static void getConnections(int cur, int par, int[] lows, int[] dis, Map<Integer, List<Integer>> graph, List<List<Integer>> criticalBridge, boolean[] visited) {
        lows[cur] = dis[cur] = discovery++;
        visited[cur] = true;
        for (int dep : graph.get(cur)) {
            if (par == dep) continue;
            if (visited[dep]) lows[cur] = Math.min(lows[cur], dis[dep]);
            else {
                getConnections(dep, cur, lows, dis, graph, criticalBridge, visited);
                lows[cur] = Math.min(lows[cur], lows[dep]);
                if (lows[dep] > lows[cur]) criticalBridge.add(Arrays.asList(cur, dep));
            }
        }
    }

    private static Map<Integer, List<Integer>> buildGraph(int n, List<List<Integer>> cons) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (List<Integer> con : cons) {
            int from = con.get(0), to = con.get(1);
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        return graph;
    }
}

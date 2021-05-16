package weekly.weekly188;
/*
    Created on:  May 09, 2020
 */

import java.util.*;

/**
 * Questions: https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
 */
public class MinimumTimeToCollectAllApplesInATree {
    public static void main(String[] args) {
        System.out.println(minTime(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, Arrays.asList(false, false, true, false, true, true, false)));
        System.out.println(minTime(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, Arrays.asList(false, false, true, false, false, true, false)));
        System.out.println(minTime(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, Arrays.asList(false, false, false, false, false, false, false)));
    }

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            Node fromNode = graph.getOrDefault(from, new Node(from, hasApple.get(from)));
            Node toNode = graph.getOrDefault(to, new Node(to, hasApple.get(to)));
            fromNode.child.add(toNode);
            graph.putIfAbsent(from, fromNode);
            graph.putIfAbsent(to, toNode);
        }
        Set<Node> visited = new HashSet<>();
        return dfs(graph.get(0), visited);
    }

    private static int dfs(Node node, Set<Node> visited) {
        int sum = 0;
        visited.add(node);
        for (Node child : node.child) {
            if (!visited.contains(child)) {
                sum += dfs(child, visited);
            }
        }
        if ((sum > 0 || node.hasApple) && (node.val != 0)) {
            sum += 2;
        }
        return sum;
    }

    static class Node {
        int val;
        boolean hasApple;
        List<Node> child = new ArrayList<>();

        public Node(int val, boolean hasApple) {
            this.val = val;
            this.hasApple = hasApple;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", hasApple=" + hasApple +
                    ", child=" + child +
                    '}';
        }
    }
}

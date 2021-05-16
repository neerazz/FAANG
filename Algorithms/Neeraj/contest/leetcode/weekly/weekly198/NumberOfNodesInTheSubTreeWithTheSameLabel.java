package weekly.weekly198;

import java.util.*;

/**
 * Created on:  Jul 18, 2020
 * Questions: https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
 * Number of Nodes in the Sub-Tree With the Same Label
 */
public class NumberOfNodesInTheSubTreeWithTheSameLabel {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countSubTrees(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, "aeed")));
    }

    public static int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new Node(i, labels.charAt(i)));
        }
        for (int[] edge : edges) {
            map.get(edge[0]).dep.add(map.get(edge[1]));
            map.get(edge[1]).dep.add(map.get(edge[0]));
        }
        Set<Integer> visited = new HashSet<>();
        dfs(0, map, visited);
        int[] op = new int[n];
        for (int i = 0; i < n; i++) {
            Node node = map.get(i);
            op[i] = node.counts[node.labelIdx];
        }
        return op;
    }

    private static int[] dfs(int node, Map<Integer, Node> map, Set<Integer> visited) {
        Node cur = map.get(node);
        visited.add(node);
        for (Node dep : cur.dep) {
            if (visited.contains(dep.val)) continue;
            int[] next = dfs(dep.val, map, visited);
            for (int i = 0; i < 26; i++) {
                cur.counts[i] += next[i];
            }
        }
        cur.counts[cur.labelIdx]++;
        return cur.counts;
    }

    static class Node {
        int val;
        int labelIdx;
        Set<Node> dep;
        int[] counts;

        public Node(int val, char label) {
            this.val = val;
            this.labelIdx = label - 'a';
            dep = new HashSet<>();
            counts = new int[26];
        }
    }
}

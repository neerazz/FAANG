import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 17, 2021
 * Questions: https://aonecode.com/amazon-interview-questions/find-critical-nodes
 * https://leetcode.com/discuss/interview-question/436073/
 */

public class FindCriticalNodes {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findCriticalNodes(7, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}})) + " = [2,3,5]");
        System.out.println(Arrays.toString(findCriticalNodes(5, new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 1}, {4, 3}, {2, 0}})) + " = [1]");
    }

    static int dis;

    public static int[] findCriticalNodes(int n, int[][] cons) {
        dis = 0;
        int[] discovery = new int[n], lowest = new int[n];
        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] con : cons) {
            graph.computeIfAbsent(con[0], val -> new HashSet<>()).add(con[1]);
            graph.computeIfAbsent(con[1], val -> new HashSet<>()).add(con[0]);
        }
        Set<Integer> critical = new HashSet<>();
//        Start from some point.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, null, graph, critical, visited, discovery, lowest);
            }
        }
        int[] result = new int[critical.size()];
        int i = 0;
        for (int node : critical) {
            result[i++] = node;
        }
        return result;
    }

    private static void dfs(int cur, Integer parent, Map<Integer, Set<Integer>> graph, Set<Integer> critical, boolean[] visited, int[] discovery, int[] lowest) {
        lowest[cur] = discovery[cur] = ++dis;
        visited[cur] = true;
        Set<Integer> childs = graph.getOrDefault(cur, new HashSet<>());
        int child = 0;
        boolean isCritical = false;
//        Loop through all the dependencies.
        for (int dep : childs) {
//            Avoid going back in the same direction. Check using the logic, that the dep node is not the parent of the current node.
            if (parent != null && dep == parent) continue;
//            Find the lowest node that can be reached from this node.
            if (!visited[dep]) {
                child++;
                dfs(dep, cur, graph, critical, visited, discovery, lowest);
                lowest[cur] = Math.min(lowest[cur], lowest[dep]);
                if (parent != null && lowest[dep] >= discovery[cur]) isCritical = true;
            } else {
                lowest[cur] = Math.min(lowest[cur], discovery[dep]);
            }
        }
//            If current is parent and there are more than one children.
//            If you cant find a lowest point that can be reached than current, then this will be critical point.
        if ((parent == null && child > 1) || (parent != null && isCritical)) {
            critical.add(cur);
        }
    }
}

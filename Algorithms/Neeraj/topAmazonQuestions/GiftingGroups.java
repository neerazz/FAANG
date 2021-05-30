import java.util.*;

/**
 * Created on:  May 30, 2021
 * Questions:
 */

public class GiftingGroups {

    public static void main(String[] args) {
        System.out.println(countGroups(Arrays.asList("110", "110", "001")));
    }

    private static int countGroups(List<String> related) {
        int rows = related.size(), cols = rows > 0 ? related.get(0).length() : 0;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == col) continue;
                char cur = related.get(row).charAt(col);
                if (cur == '1') {
                    graph.computeIfAbsent(row, val -> new HashSet<>()).add(col);
                    graph.computeIfAbsent(col, val -> new HashSet<>()).add(row);
                }
            }
        }
        int count = 0;
        boolean[] visited = new boolean[rows];
        for (int node = 0; node < rows; node++) {
            if (!visited[node]) {
                count++;
                dfs(graph, visited, node);
            }
        }
        return count;
    }

    private static void dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, int cur) {
        if (visited[cur]) return;
        visited[cur] = true;
        for (int dep : graph.getOrDefault(cur, new HashSet<>())) {
            dfs(graph, visited, dep);
        }
    }
}

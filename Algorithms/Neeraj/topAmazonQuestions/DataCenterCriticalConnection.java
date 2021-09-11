import java.util.*;

/**
 * Created on:  Jan 19, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-data-center-critical-connection
 */

public class DataCenterCriticalConnection {

    static int time;

    public static void main(String[] args) {
        System.out.println(findCriticalConn(4, 4, new int[][]{{1, 2}, {1, 3}, {3, 2}, {3, 4}}) + " = [[3,4]]");
    }

    public static List<List<Integer>> findCriticalConn(int n, int connectionsNum, int[][] connections) {
        time = 0;
        int[] disc = new int[n + 1], lowest = new int[n + 1];
        Set<Integer>[] graph = new HashSet[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] con : connections) {
            int from = con[0], to = con[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        boolean[] visited = new boolean[n + 1];
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            dfs(i, null, graph, disc, lowest, visited, result);
        }
        return new ArrayList<>(result);
    }

    private static void dfs(int cur, Integer parent, Set<Integer>[] graph, int[] disc, int[] lowest, boolean[] visited, Set<List<Integer>> result) {
        disc[cur] = lowest[cur] = ++time;
        visited[cur] = true;
        for (int next : graph[cur]) {
            if (parent != null && next == parent) continue;
            if (visited[next]) {
                lowest[cur] = Math.min(lowest[cur], disc[next]);
            } else {
                dfs(next, cur, graph, disc, lowest, visited, result);
                lowest[cur] = Math.min(lowest[cur], lowest[next]);
                if (lowest[next] > disc[cur]) {
                    result.add(Arrays.asList(cur, next));
                }
            }
        }
    }
}

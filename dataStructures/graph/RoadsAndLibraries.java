import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created on:  Jul 27, 2020
 * Questions: https://www.hackerrank.com/challenges/torque-and-development/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=graphs&isFullScreen=true
 */
public class RoadsAndLibraries {
    static long cost;

    public static void main(String[] args) {
        System.out.println(roadsAndLibraries(3, 2, 1, new int[][]{{1, 2}, {3, 1}, {2, 3}}) + " = 4");
        System.out.println(roadsAndLibraries(6, 2, 5, new int[][]{{1, 3}, {3, 4}, {2, 4}, {1, 2}, {2, 3}, {5, 6}}) + " = 12");
    }

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        cost = 0;
        boolean[] visited = new boolean[n + 1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] city : cities) {
            map.get(city[0]).add(city[1]);
            map.get(city[1]).add(city[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
//                When the node is not visited. Then add the cost of library, and do a dfs for that node.
                cost += c_lib - Math.min(c_lib, c_road);
                dfs(map, i, visited, Math.min(c_lib, c_road));
            }
        }
        return cost;
    }

    private static void dfs(Map<Integer, Set<Integer>> graph, int cur, boolean[] visited, int minCost) {
        cost += minCost;
        visited[cur] = true;
        for (int dep : graph.get(cur)) {
            if (!visited[dep]) {
                dfs(graph, dep, visited, minCost);
            }
        }
    }
}

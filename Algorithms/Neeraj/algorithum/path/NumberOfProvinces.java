import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/problems/number-of-provinces/
 */

public class NumberOfProvinces {

    public static void main(String[] args) {

    }

    public static int findCircleNum(int[][] grid) {
        int count = 0, rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    map.computeIfAbsent(row, val -> new HashSet<>()).add(col);
                    map.computeIfAbsent(col, val -> new HashSet<>()).add(row);
                }
            }
        }
        boolean[] visited = new boolean[rows];
        for (int cur : map.keySet()) {
            if (visited[cur]) continue;
            count++;
            dfs(cur, map, visited);
        }
        return count;
    }

    private static void dfs(int cur, Map<Integer, Set<Integer>> map, boolean[] visited) {
        if (visited[cur]) return;
        visited[cur] = true;
        for (int dep : map.get(cur)) {
            dfs(dep, map, visited);
        }
    }
}

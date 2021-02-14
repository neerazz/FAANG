import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/problems/number-of-provinces/
 */

public class NumberOfProvinces {

    public static void main(String[] args) {

    }

    public static int findCircleNum_rev1(int[][] isConnected) {
        int n = isConnected.length, count =0;;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                dfs(i, n, visited, isConnected);
            }
        }
        return count;
    }
    private static void dfs(int cur, int n, boolean[] visited, int[][] connected){
        visited[cur] = true;
        for(int i=0; i<n; i++){
            if(i == cur) continue;
            if(!visited[i] && connected[cur][i] == 1){
                connected[cur][i] = connected[i][cur] =0;
                dfs(i, n, visited, connected);
            }
        }
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

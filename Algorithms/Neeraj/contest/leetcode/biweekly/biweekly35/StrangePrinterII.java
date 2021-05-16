package biweekly.biweekly35;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created on:  Sep 19, 2020
 * Questions: https://leetcode.com/problems/strange-printer-ii/
 */
public class StrangePrinterII {
    public static void main(String[] args) {
        System.out.println(isPrintable(new int[][]{{1, 3, 2}, {2, 3, 0}, {1, 0, 3}, {1, 0, 2}}) + " false");
        System.out.println(isPrintable(new int[][]{{1, 1, 1, 1}, {1, 2, 2, 1}, {1, 2, 2, 1}, {1, 1, 1, 1}}) + " true");
        System.out.println(isPrintable(new int[][]{{1, 1, 1, 1}, {1, 1, 3, 3}, {1, 1, 3, 4}, {5, 5, 1, 4}}) + " true");
        System.out.println(isPrintable(new int[][]{{1, 1, 1, 1}, {1, 1, 3, 3}, {1, 1, 3, 4}, {5, 5, 1, 4}}) + " false");
        System.out.println(isPrintable(new int[][]{{1, 1, 1}, {3, 1, 3}}) + " false");
    }

    public static boolean isPrintable(int[][] targetGrid) {
//        0: start row, 1 : start col, 2 : end row, 3 : end col
        Map<Integer, int[]> map = new HashMap<>();
        int rows = targetGrid.length, cols = rows > 0 ? targetGrid[0].length : 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int colour = targetGrid[row][col];
                int[] val = map.getOrDefault(colour, new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE});
                val[0] = Math.min(val[0], row);
                val[1] = Math.min(val[1], col);
                val[2] = Math.max(val[2], row);
                val[3] = Math.max(val[3], col);
                map.put(colour, val);
            }
        }
        Map<Integer, Set<Integer>> dependencies = new HashMap<>();
        for (int colour = 1; colour <= 60; colour++) {
            int[] cur = map.getOrDefault(colour, new int[]{0, 0, -1 - 1});
            for (int r = cur[0]; r <= cur[2]; r++) {
                for (int c = cur[1]; c <= cur[3]; c++) {
                    if (targetGrid[r][c] != colour) {
                        dependencies.computeIfAbsent(colour, val -> new HashSet<>()).add(targetGrid[r][c]);
                    }
                }
            }
        }
//        Perform a DFS of the graph, to check if there is a circular dependency.
        for (int colour = 0; colour <= 60; colour++) {
            if (!hasCircular(dependencies, colour, new int[61])) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasCircular(Map<Integer, Set<Integer>> map, int cur, int[] visited) {
//        0 -> not visited, 1 -> visited but not complete, 2 -> completely visited
        if (visited[cur] != 0) return visited[cur] == 2;
        visited[cur] = 1;
        for (int dep : map.getOrDefault(cur, new HashSet<>())) {
            if (!hasCircular(map, dep, visited)) return false;
        }
        visited[cur] = 2;
        return true;
    }
}

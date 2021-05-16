package biweekly.biweekly33;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Aug 22, 2020
 * Questions: https://leetcode.com/problems/detect-cycles-in-2d-grid/
 */
public class DetectCyclesIn2DGrid {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        System.out.println("*********************************** Solution 1 ****************************************");
        System.out.println(containsCycle(new char[][]{{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}}) + " = false");
        System.out.println(containsCycle(new char[][]{{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}}) + " = true");
        System.out.println(containsCycle(new char[][]{{'c', 'c', 'c', 'a'}, {'c', 'd', 'c', 'c'}, {'c', 'c', 'e', 'c'}, {'f', 'c', 'c', 'c'}}) + " = true");
        System.out.println("*********************************** Solution 2 ****************************************");
        System.out.println(containsCycle_optimal(new char[][]{{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}}) + " = false");
        System.out.println(containsCycle_optimal(new char[][]{{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}}) + " = true");
        System.out.println(containsCycle_optimal(new char[][]{{'c', 'c', 'c', 'a'}, {'c', 'd', 'c', 'c'}, {'c', 'c', 'e', 'c'}, {'f', 'c', 'c', 'c'}}) + " = true");
    }

    public static boolean containsCycle_optimal(char[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char cur = grid[row][col];
                if (!visited[row][col]) {
                    for (int[] dir : dirs) {
                        if (hasCycle(grid, cur, new int[]{row, col}, new int[]{row + dir[0], col + dir[1]}, rows, cols, visited)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean hasCycle(char[][] grid, char expected, int[] pre, int[] cur, int rows, int cols, boolean[][] visited) {
        if (cur[0] < 0 || cur[0] >= rows || cur[1] < 0 || cur[1] >= cols || grid[cur[0]][cur[1]] != expected)
            return false;
        visited[cur[0]][cur[1]] = true;
        for (int[] dir : dirs) {
            int[] next = new int[]{cur[0] + dir[0], cur[1] + dir[1]};
//            If the next index is in-valid, then skip that path.
            if (next[0] < 0 || next[0] >= rows || next[1] < 0 || next[1] >= cols) continue;
//            If the next is equal to pre, then skip that path.
            if (next[0] == pre[0] && next[1] == pre[1]) continue;
//            If the next is equal to expected and is already visited then true;
            if (grid[next[0]][next[1]] == expected) {
                if (visited[next[0]][next[1]]) return true;
                if (hasCycle(grid, expected, cur, next, rows, cols, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsCycle(char[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        boolean[][][] checked = new boolean[rows][cols][26];
        Set<String> path = new HashSet<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Set<Integer> indexs = new HashSet<>();
                char cur = grid[row][col];
                if (!checked[row][col][cur - 'a'] && canFormCycle(grid, row, col, rows, cols, cur, path, indexs, checked)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean canFormCycle(char[][] grid, int row, int col, int rows, int cols, char expected, Set<String> paths, Set<Integer> nodes, boolean[][][] checked) {
        if (grid[row][col] != expected) return false;
        if (nodes.contains(row * 999 + col)) return true;
        nodes.add(row * 999 + col);
        checked[row][col][expected - 'a'] = true;
        for (int[] dir : dirs) {
            int nrow = row + dir[0], ncol = col + dir[1];
            if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols) {
                String key = row + "-" + col + " to " + nrow + "-" + ncol, key2 = nrow + "-" + ncol + " to " + row + "-" + col;
                if (!paths.contains(key)) {
                    paths.add(key);
                    paths.add(key2);
                    if (canFormCycle(grid, nrow, ncol, rows, cols, expected, paths, nodes, checked)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

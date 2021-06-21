package weekly.weekly246;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on:  Jun 19, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-246/problems/count-sub-islands/
 */

public class CountSubIslands {

    public static void main(String[] args) {
        System.out.println(countSubIslands(
                new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}},
                new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}})
                + " = 3");
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid2.length, cols = rows > 0 ? grid2[0].length : 0;
        int subCount = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid2[row][col] == 1) {
                    Set<Coordinate> island = new HashSet<>();
                    dfs(grid2, row, col, rows, cols, island);
                    if (isSubIsland(island, grid1)) subCount++;
                }
            }
        }
        return subCount;
    }

    private static boolean isSubIsland(Set<Coordinate> island, int[][] grid) {
//        Loop through second island and check each coordinate in grid, it should be land.
        for (Coordinate cord : island) {
            if (grid[cord.x][cord.y] == 0) return false;
        }
        return true;
    }

    public static int countSubIslands_naive(int[][] grid1, int[][] grid2) {
        List<Set<Coordinate>> island1 = getIsland(grid1);
        List<Set<Coordinate>> island2 = getIsland(grid2);
        int count = 0;
        for (Set<Coordinate> island : island2) {
            if (isSubIsland(island, island1)) count++;
        }
        return count;
    }

    private static boolean isSubIsland(Set<Coordinate> subIland, Set<Coordinate> island1) {
        if (subIland.size() > island1.size()) return false;
        for (Coordinate land : subIland) {
            if (island1.contains(land)) continue;
            return false;
        }
        return true;
    }

    private static boolean isSubIsland(Set<Coordinate> island, List<Set<Coordinate>> island1) {
        for (Set<Coordinate> il1 : island1) {
            if (isSubIsland(island, il1)) return true;
        }
        return false;
    }

    private static List<Set<Coordinate>> getIsland(int[][] grid) {
        List<Set<Coordinate>> islands = new ArrayList<>();
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    Set<Coordinate> island = new HashSet<>();
                    dfs(grid, row, col, rows, cols, island);
                    islands.add(island);
                }
            }
        }
        return islands;
    }

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static void dfs(int[][] grid, int row, int col, int rows, int cols, Set<Coordinate> island) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) return;
        island.add(new Coordinate(row, col));
        grid[row][col] = 0;
        for (int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1], rows, cols, island);
        }
    }

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            if (x != that.x) return false;
            return y == that.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}

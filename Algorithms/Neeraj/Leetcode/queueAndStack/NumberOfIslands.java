package queueAndStack;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1374/

 */
public class NumberOfIslands {

    static List<Index> coveredList = new ArrayList<>();

    public static void main(String[] args) {
        char[][] grid = new char[][]{{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println("Answer is: " + numIslands(grid) + " should be [1]");
        coveredList = new ArrayList<>();
        char[][] grid1 = new char[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        System.out.println("Answer is: " + numIslands(grid1) + " should be [3]");
    }

    //     Loop through the array and when you encounter 1, find the neighbouring 1's. Always change the visited values to 0.
    public static int numIslands(char[][] grid) {
        int row = grid.length;
        int column = row > 0 ? grid[0].length : 0;
        if (column == 0) return 0;
        int islands = 0;
        char one = '1';

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    findConnectedIslands(grid, i, j, row, column);
                }
            }
        }
        return islands;
    }

    private static void findConnectedIslands(char[][] grid, int i, int j, int row, int column) {
        if (i < 0 || i >= row || j < 0 || j >= column) return;
        char one = '1';
        if (grid[i][j] == '1') {
            grid[i][j] = 0;
//            Check for connected island.
            findConnectedIslands(grid, i - 1, j, row, column);
            findConnectedIslands(grid, i + 1, j, row, column);
            findConnectedIslands(grid, i, j - 1, row, column);
            findConnectedIslands(grid, i, j + 1, row, column);
        }
    }

    public static int namIslands_elegant(char[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
//                do nothing if the point is water or previously traveled
                if (grid[i][j] == '0') continue;
//                now we've found a new piece of land, populate all pieces of land that it's attached to
                islands++;
                populateIsland(grid, i, j);
            }
        }
        return islands;
    }

    public static void populateIsland(char[][] grid, int i, int j) {
        // check to see if we've been here before or if it's water
        if (grid[i][j] == '0') return;

        // set grid[i][j] to show we've been here
        grid[i][j] = '0';

        // iterate on whole island
        if (i > 0 && grid[i - 1][j] == '1') {
            populateIsland(grid, i - 1, j);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            populateIsland(grid, i, j - 1);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            populateIsland(grid, i + 1, j);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
            populateIsland(grid, i, j + 1);
        }
    }

    public static int numIslands_option2(char[][] grid) {
        int rows = grid.length;
        int column = rows > 0 ? grid[0].length : 0;
        if (column == 0) return 0;
        List<List<Index>> islands = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '\u0001') {
                    Index currentIndex = new Index(i, j);
                    boolean covered = false;
//                    Check If the current value is already covered.
                    if (!coveredList.contains(currentIndex)) {
                        List<Index> currentIsland = findIslands(i, j, grid, new ArrayList<>());
                        System.out.println(currentIsland);
                        if (!currentIsland.isEmpty()) islands.add(currentIsland);
                    }
                }
            }
        }
        return islands.size();
    }

    private static List<Index> findIslands(int i, int j, char[][] grid, List<Index> indices) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '\u0001') return indices;
        Index currentIndex = new Index(i, j);

        if (coveredList.contains(currentIndex)) return indices;
        else coveredList.add(currentIndex);

        if (grid[i][j] == '\u0001') {
            indices.add(currentIndex);
        } else {
            return indices;
        }
        indices = findIslands(i + 1, j, grid, indices);
        indices = findIslands(i - 1, j, grid, indices);
        indices = findIslands(i, j + 1, grid, indices);
        indices = findIslands(i, j - 1, grid, indices);
        return indices;
    }
}

class Index {
    int i;
    int j;

    public Index(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "i=" + i +
                ", j=" + j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Index index = (Index) o;

        if (i != index.i) return false;
        return j == index.j;
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + j;
        return result;
    }
}
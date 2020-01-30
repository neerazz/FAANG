package topAmazonQuestions;

import java.util.Arrays;
import java.util.HashSet;

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input:
11110
11010
11000
00000
Output: 1
Example 2:
Input:
11000
11000
00100
00011
Output: 3
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println("Answer is: " + numIslands(grid) + " should be [1]");
        char[][] grid1 = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println("Answer is: " + numIslands(grid1) + " should be [3]");
    }

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = rows > 0 ? grid[0].length : 0;
        int numberOfIslands = 0;
        if (cols > 0) {
            HashSet<Integer> visited = new HashSet<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int currentPositionHash = i * 100 + j;
                    if (!visited.contains(currentPositionHash) && grid[i][j] == '1') {
                        numberOfIslands++;
                        performDepthFirstSearch(grid, i, j, rows, cols, visited);
                    }
                }
            }
        }
        return numberOfIslands;
    }

    private static void performDepthFirstSearch(char[][] grid, int row, int col, int rows, int cols, HashSet<Integer> visited) {
        if (visited.contains(row * 100 + col) || row >= rows || row < 0 || col >= cols || col < 0 || grid[row][col] == '0') {
            return;
        }
//        Add the current position into the visited list.
        visited.add(row * 100 + col);
        if (grid[row][col] == '1') {
            grid[row][col] = 0;
            //        Travel in all the 4 directions to get the end of the island.
            performDepthFirstSearch(grid, row - 1, col, rows, cols, visited);
            performDepthFirstSearch(grid, row + 1, col, rows, cols, visited);
            performDepthFirstSearch(grid, row, col - 1, rows, cols, visited);
            performDepthFirstSearch(grid, row, col + 1, rows, cols, visited);
        }
    }
}

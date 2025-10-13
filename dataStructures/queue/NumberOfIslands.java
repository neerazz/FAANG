import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        int numIslands = 0;

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (grid[r][c] == '1') {
                    numIslands++;
                    grid[r][c] = '0'; // Mark as visited
                    Queue<int[]> neighbors = new LinkedList<>();
                    neighbors.add(new int[]{r, c});

                    while (!neighbors.isEmpty()) {
                        int[] id = neighbors.remove();
                        int row = id[0];
                        int col = id[1];

                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add(new int[]{row - 1, col});
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < numRows && grid[row + 1][col] == '1') {
                            neighbors.add(new int[]{row + 1, col});
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(new int[]{row, col - 1});
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < numCols && grid[row][col + 1] == '1') {
                            neighbors.add(new int[]{row, col + 1});
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }

        return numIslands;
    }
}

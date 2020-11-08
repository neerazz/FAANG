import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 07, 2020
 * Questions: https://app.codesignal.com/arcade/intro/level-2/xskq4ZxLyqQMCLshr
 * After becoming famous, the CodeBots decided to move into a new building together. Each of the rooms has a different cost, and some of them are free, but there's a rumour that all the free rooms are haunted! Since the CodeBots are quite superstitious, they refuse to stay in any of the free rooms, or any of the rooms below any of the free rooms.
 * <p>
 * Given matrix, a rectangular matrix of integers, where each value represents the cost of the room, your task is to return the total sum of all rooms that are suitable for the CodeBots (ie: add up all the values that don't appear below a 0).
 * <p>
 * Example
 * <p>
 * For
 * <p>
 * matrix = [[0, 1, 1, 2],
 * [0, 5, 0, 0],
 * [2, 0, 3, 3]]
 * the output should be
 * matrixElementsSum(matrix) = 9.
 */

public class RoomTravel {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {

    }

    static int matrixElementsSum(int[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        boolean[][] dont = new boolean[rows][cols];
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(matrix[r][c] == 0 || (r>0 && dont[r-1][c])){
                    dont[r][c] = true;
                }
            }
        }
        // System.out.println(Arrays.deepToString(dont));
        int sum =0;
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(matrix[r][c] != 0 && !dont[r][c]){
                    sum += dfs(matrix, r,c,rows, cols, dont);
                }
            }
        }
        return sum;
    }

    static int dfs(int[][] matrix, int row, int col, int rows, int cols, boolean[][] dont) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || dont[row][col]) return 0;
        int val = matrix[row][col];
        dont[row][col] = true;
        for (int[] dir : dirs) {
            val += dfs(matrix, row + dir[0], col + dir[1], rows, cols, dont);
        }
        return val;
    }
}

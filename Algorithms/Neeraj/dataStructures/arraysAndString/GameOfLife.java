import java.util.*;
import java.io.*;

/**
 * Created on:  Dec 30, 2020
 * Questions: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/573/week-5-december-29th-december-31st/3586/
 */

public class GameOfLife {

    public static void main(String[] args) {

    }

    public static void gameOfLife(int[][] board) {
        List<int[]> changed = new ArrayList<>();
        int rows = board.length, cols = rows > 0 ? board[0].length : 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int live = getLiveNeighbours(board, row, col, rows, cols);
                if (board[row][col] == 0 && live == 3) {
                    changed.add(new int[]{row, col});
                } else if (board[row][col] == 1 && (live < 2 || live > 3)) {
                    changed.add(new int[]{row, col});
                }
            }
        }
        for (int[] val : changed) {
            board[val[0]][val[1]] ^= 1;
        }
    }

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    private static int getLiveNeighbours(int[][] board, int row, int col, int rows, int cols) {
        int count = 0;
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                count += board[row + dir[0]][col + dir[1]];
            }
        }
        return count;
    }
}

import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 13, 2020
 * Questions: https://leetcode.com/problems/minesweeper/
 */

public class Minesweeper {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(updateBoard(new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0})));
        System.out.println(Arrays.deepToString(updateBoard(new char[][]{{'B', '1', 'E', '1', 'B'}, {'B', '1', 'M', '1', 'B'}, {'B', '1', '1', '1', 'B'}, {'B', 'B', 'B', 'B', 'B'}}, new int[]{1, 2})));
    }

    public static char[][] updateBoard(char[][] board, int[] click) {
        System.out.println("Input  = " + Arrays.deepToString(board));
        int rows = board.length, cols = rows > 0 ? board[0].length : 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        loops:
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
//                 If cur is M then game over;
                if (board[cur[0]][cur[1]] == 'M') {
                    board[cur[0]][cur[1]] = 'X';
                    break loops;
                } else if (board[cur[0]][cur[1]] == 'E') {
//                     Explore all the surroundings, if every thing is unreserved then set to b.
                    board[cur[0]][cur[1]] = '0';
                    for (int[] dir : dirs) {
                        int x = cur[0] + dir[0], y = cur[1] + dir[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols) {
                            if (board[x][y] == 'E') continue;
                            if (board[x][y] == 'M') board[cur[0]][cur[1]]++;
                        }
                    }
                    if (board[cur[0]][cur[1]] == '0') {
//                         When all the surroundings are un-reveled Loop through all the adjacent boxes
                        board[cur[0]][cur[1]] = 'B';
                        for (int[] dir : dirs) {
                            int x = cur[0] + dir[0], y = cur[1] + dir[1];
                            if (x >= 0 && x < rows && y >= 0 && y < cols) {
                                queue.add(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Output = " + Arrays.deepToString(board));
        return board;
    }
}

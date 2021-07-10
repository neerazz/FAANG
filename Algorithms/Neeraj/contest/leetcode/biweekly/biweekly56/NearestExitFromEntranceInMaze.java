package biweekly.biweekly56;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on:  Jul 10, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-56/problems/nearest-exit-from-entrance-in-maze/
 */

public class NearestExitFromEntranceInMaze {

    public static void main(String[] args) {
//        System.out.println(nearestExit(new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}}, new int[]{1, 2}) + " = 1");
        System.out.println(nearestExit(new char[][]{{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}}, new int[]{1, 0}) + " = 2");
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = rows > 0 ? maze[0].length : 0;
        int level = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        maze[entrance[0]][entrance[1]] = '+';
        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();
                for (int[] dir : dirs) {
                    int newRow = poll[0] + dir[0], newCol = poll[1] + dir[1];
                    if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || maze[newRow][newCol] == '+')
                        continue;
                    if (maze[newRow][newCol] == '.' && (newRow == 0 || newRow == rows - 1 || newCol == 0 || newCol == cols - 1))
                        return level + 1;
                    maze[newRow][newCol] = '+';
                    queue.add(new int[]{newRow, newCol});
                }
            }
            level++;
        }
        return -1;
    }
}

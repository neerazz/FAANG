package queueAndStack;

import java.util.Arrays;

/*
https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1373/
You are given a m x n 2D grid initialized with these three possible values.
-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
Example:
Given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
Solution: https://www.youtube.com/watch?v=Pj9378ZsCh4
 */
public class WallsAndGates {
    public static void main(String[] args) {
        int[][] values = new int[][]{
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
        wallsAndGates(values);
        Arrays.stream(values).forEach(i -> System.out.println(Arrays.toString(i)));
    }

    public static void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int column = rows > 0 ? rooms[0].length : 0;
        if (column == 0) return;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (rooms[i][j] == 0) {
                    setNearByValues(i, j, 0, rooms);
                }
            }
        }
    }

    private static void setNearByValues(int i, int j, int distance, int[][] rooms) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length || rooms[i][j] < distance) return;
        rooms[i][j] = distance;
        setNearByValues(i + 1, j, distance + 1, rooms);
        setNearByValues(i - 1, j, distance + 1, rooms);
        setNearByValues(i, j + 1, distance + 1, rooms);
        setNearByValues(i, j - 1, distance + 1, rooms);
    }

    public static void wallsAndGates_worse(int[][] rooms) {
        int rows = rooms.length;
        int column = rooms[0].length;
        if (column == 0) return;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (rooms[i][j] == 2147483647) {
                    rooms[i][j] = findDistance(rooms, i, j, rows, column);
                }
            }
        }
    }

    private static int findDistance(int[][] rooms, int currentRow, int currentColumn, int rows, int column) {
        if (rooms[currentRow][currentColumn] == 0) return 0;
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;

//        Check the value at the top of the current value
        if (currentRow - 1 >= 0 && rooms[currentRow - 1][currentColumn] != -1) {
            a = 0;
            a = findDistance(rooms, currentRow + 1, currentColumn, rows, column) + 1;
        }
//        Check the value at the bottom of the current value
        if (currentRow + 1 < rows && rooms[currentRow + 1][currentColumn] != -1) {
            b = 0;
            b = findDistance(rooms, currentRow + 1, currentColumn, rows, column) + 1;
        }
//        Check the value at the right of the current value
        if (currentColumn + 1 < column && rooms[currentRow][currentColumn + 1] != -1) {
            c = 0;
            c = findDistance(rooms, currentRow, currentColumn + 1, rows, column) + 1;
        }
//        Check the value at the left of the current value
        if (currentColumn - 1 >= 0 && rooms[currentRow][currentColumn - 1] != -1) {
            d = 0;
            d = findDistance(rooms, currentRow, currentColumn + 1, rows, column) + 1;
        }
        return Math.min(Math.min(a, b), Math.min(c, d));
    }
}
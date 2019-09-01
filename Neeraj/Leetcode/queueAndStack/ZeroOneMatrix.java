package queueAndStack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1388/
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Example 1:
Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Example 2:
Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]
Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 */
public class ZeroOneMatrix {
    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
//        Arrays.stream(updateMatrix(matrix)).forEach(a -> System.out.println(Arrays.toString(a)));
//        System.out.println("========================================");
//        int[][] matrix2 = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
//        Arrays.stream(updateMatrix(matrix2)).forEach(a -> System.out.println(Arrays.toString(a)));
//        System.out.println("========================================");
//        int[][] matrix3 = new int[][]{{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
//        Arrays.stream(updateMatrix(matrix3)).forEach(a -> System.out.println(Arrays.toString(a)));
//        System.out.println("========================================");
//        int[][] matrix4 = new int[][]{{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},{0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},{0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,1,1,1,0,1},{1,1,1,1,1,1,1,0,1,0},{1,1,1,1,0,1,0,0,1,1}};
//        Arrays.stream(updateMatrix(matrix4)).forEach(a -> System.out.println(Arrays.toString(a)));
        System.out.println("========================================");
        int[][] matrix5 = new int[][]{{0, 0, 1, 0, 1, 1, 1, 0, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 0, 1, 0, 1, 1, 1, 0, 1, 1}, {0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}};
        Arrays.stream(updateMatrix(matrix5)).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    public static int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = rows > 0 ? matrix[0].length : 0;
        int[][] res = new int[rows][columns];
        Queue<Position> q = new LinkedList<Position>();

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < columns; c++) {
                if (matrix[r][c] == 0) {
                    res[r][c] = 0;
                    q.add(new Position(0, r, c));
                } else {
                    res[r][c] = Integer.MAX_VALUE;
                }
            }

        while (!q.isEmpty()) {
            Position next = q.poll();
            UpdateMatrix(res, q, new Position(next.dis + 1, next.r + 1, next.c));
            UpdateMatrix(res, q, new Position(next.dis + 1, next.r, next.c + 1));
            UpdateMatrix(res, q, new Position(next.dis + 1, next.r - 1, next.c));
            UpdateMatrix(res, q, new Position(next.dis + 1, next.r, next.c - 1));
        }

        return res;
    }

    static void UpdateMatrix(int[][] res, Queue<Position> q, Position pos) {
        // For all sides if the range is good and the value is less put it.
        if (pos.r < 0 || pos.r >= res.length || pos.c >= res[0].length || pos.c < 0 || pos.dis >= res[pos.r][pos.c])
            return;
        res[pos.r][pos.c] = pos.dis;
        q.add(pos);
    }

    public static int[][] updateMatrix_wrong(int[][] matrix) {
        int rows = matrix.length;
        int columns = rows > 0 ? matrix[0].length : 0;
        int[][] output = new int[rows][columns];
        HashSet<Integer> visited = new HashSet<>();
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = columns - 1; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    output[i][j] = updateMatrixHelper(matrix, i, j, rows, columns, visited);
                }
            }
        }

        visited = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] != 0) {
                    output[i][j] = updateMatrixHelper(matrix, i, j, rows, columns, visited);
                }
            }
        }
        return output;
    }

    private static int updateMatrixHelper(int[][] matrix, int currentRow, int currentColumn, int rows, int columns, HashSet<Integer> visited) {
        if (currentRow < 0 || currentRow >= rows || currentColumn < 0 || currentColumn >= columns)
            return Integer.MAX_VALUE;
        if (visited.contains(currentRow + currentColumn * columns)) return matrix[currentRow][currentColumn];
        visited.add(currentRow + currentColumn * columns);
        if (matrix[currentRow][currentColumn] == 0) return 0;
        if (currentRow == 0 && currentColumn == 9) {
            System.out.println("Reached");
        }
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
        if (currentRow - 1 >= 0) {
            a = 1;
            a += updateMatrixHelper(matrix, currentRow - 1, currentColumn, rows, columns, visited);
        }
        if (currentRow + 1 < rows) {
            b = 1;
            b += updateMatrixHelper(matrix, currentRow + 1, currentColumn, rows, columns, visited);
        }
        if (currentColumn - 1 >= 0) {
            c = 1;
            c += updateMatrixHelper(matrix, currentRow, currentColumn - 1, rows, columns, visited);
        }
        if (currentColumn + 1 < columns) {
            d = 1;
            d += updateMatrixHelper(matrix, currentRow, currentColumn + 1, rows, columns, visited);
        }
        int minValue = Math.min(Math.min(a, b), Math.min(c, d));
        matrix[currentRow][currentColumn] = minValue;
        return minValue;
    }

    static class Position {
        public int dis;
        public int r;
        public int c;

        public Position(int dis, int r, int c) {
            this.dis = dis;
            this.r = r;
            this.c = c;
        }
    }
}

package virtualOnline;/*
    Created on:  Apr 30, 2020
 */

/**
 * Questions: Given a matrix from start to end, navigate and collect the maximum points.
 */
public class Question3 {
    public static void main(String[] args) {

    }

    private int getMaxPoints(int[][] matrix, int[] start, int[] end) {
        dfs(matrix, start, end, 0);
        return output;
    }

//     At each point find the maximum value

    private int dp(int[][] matrix, int[] current, int[] end) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];

        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
//                Get max of top, left top, right
                int max = Math.max(Math.max(matrix[row - 1][col], matrix[row][col - 1]), matrix[row - 1][col - 1]);
                dp[row][col] = max + matrix[row][col];
            }
        }
//        Then just take the value at the point.
        return dp[end[0]][end[1]];
    }

    int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int output = 0;

    private void dfs(int[][] matrix, int[] current, int[] end, int points) {
        int currX = current[0], currY = current[1];
//        Check if it is out of the boundaries.
        if (currX < 0 || currX >= matrix.length || currY < 0 || currY >= matrix[0].length) return;

//        Also check if it is a block that currY can't travel.
        if (matrix[currX][currY] == -1) return;

//        Check if we reached the end.
        if (currX == end[0] && currY == end[1]) output = Math.max(output, points);

//        Set the current value into an variable, so that you can set it back.
        int currVal = matrix[currX][currY];

//        Set the current value to -1. move line 32 down.
        matrix[currX][currY] = -1;

//        Travel through all the four directions.
        for (int[] move : moves) {
            int newX = currX + move[0], newY = currX + move[1];
            dfs(matrix, new int[]{newX, newY}, end, points + currVal);
        }

//        Set the value back after the dfs.
        matrix[currX][currY] = currVal;
    }
}

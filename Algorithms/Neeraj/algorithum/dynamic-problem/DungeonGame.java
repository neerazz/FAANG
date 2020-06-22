/**
 * Created on:  Jun 21, 2020
 * Questions: https://leetcode.com/problems/dungeon-game/
 */
public class DungeonGame {
    static int rows, cols;

    public static void main(String[] args) {
        System.out.println(calculateMinimumHP(new int[][]{{-3, 5}}) + " should be [4]");
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        rows = dungeon.length;
        cols = rows > 0 ? dungeon[0].length : 0;
        Integer[][] dp = new Integer[rows][cols];
        int result = helper(dungeon, dp, 0, 0);
        return result > 0 ? 1 : Math.abs(result) + 1;
    }

    private static int helper(int[][] arr, Integer[][] dp, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) return Integer.MAX_VALUE;
        if (row == rows - 1 && col == cols - 1) return arr[row][col];
        if (dp[row][col] != null) return dp[row][col];
        int right = helper(arr, dp, row, col + 1);
        int down = helper(arr, dp, row + 1, col);
        int next = 0;
        if (right < 0 && down < 0) next = Math.max(right, down);
        if (right == Integer.MAX_VALUE || down == Integer.MAX_VALUE) next = Math.min(right, down);
        if (next > 0) next = 0;
        return dp[row][col] = arr[row][col] + next;
    }
}

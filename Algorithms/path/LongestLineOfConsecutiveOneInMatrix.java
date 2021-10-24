/**
 * Created on:  Aug 10, 2021
 * Ref : https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
 */
public class LongestLineOfConsecutiveOneInMatrix {
    static int[][] dirs = {{1, 0}, {1, -1}, {1, 1}, {0, -1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};

    public static void main(String[] args) {
        System.out.println(longestLine(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}}) + " = 3");
    }

    public static int longestLine(int[][] mat) {
        int max = 0;
        int rows = mat.length, cols = rows > 0 ? mat[0].length : 0;
        Integer[][][] dp = new Integer[rows][cols][8];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 0) continue;
                for (int i = 0; i < 8; i++) {
                    max = Math.max(max, dfs(mat, row, col, rows, cols, i, dp));
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return max;
    }

    private static int dfs(int[][] mat, int row, int col, int rows, int cols, int dir, Integer[][][] dp) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) return 0;
        if (mat[row][col] == 0) return 0;
        if (dp[row][col][dir] != null) return dp[row][col][dir];
        mat[row][col] = 0;
        int nr = row + dirs[dir][0], nc = col + dirs[dir][1];
        int max = dfs(mat, nr, nc, rows, cols, dir, dp);
        mat[row][col] = 1;
        return dp[row][col][dir] = max + 1;
    }
}

/**
 * Created on:  Sep 22, 2021
 * Ref: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathInAMatrix {
    static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int m, n;

    public static void main(String[] args) {
        System.out.println(longestIncreasingPath(new int[][]{{7, 7, 5}, {2, 4, 6}, {8, 2, 0}}) + " = 4");
        System.out.println(longestIncreasingPath(new int[][]{{7, 8, 9}, {9, 7, 6}, {7, 2, 3}}) + " = 6");
        System.out.println(longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}) + " = 4");
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs(matrix, i, j, cache));
        return ans;
    }

    private static int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j])
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
        }
        return ++cache[i][j];
    }
}

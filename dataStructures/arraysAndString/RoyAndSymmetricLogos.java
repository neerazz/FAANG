/*
    Created on:  May 08, 2020
 */

/**
 * Questions: https://www.hackerearth.com/practice/data-structures/arrays/multi-dimensional/practice-problems/algorithm/roy-and-symmetric-logos-1/
 */
public class RoyAndSymmetricLogos {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = fr.nextInt();
            int[][] grid = new int[n][n];
            for (int j = 0; j < n; j++) {
                int idx = 0;
                for (char c : fr.readLine().toCharArray()) {
                    grid[j][idx++] = c;
                }
            }
            sb.append(checkForSymmetric(grid, n)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String checkForSymmetric(int[][] grid, int n) {
        int mid = (n + 1) / 2;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < mid; row++) {
                if (grid[row][col] != grid[n - row - 1][col]) {
                    return "NO";
                }
            }
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < mid; col++) {
                if (grid[row][col] != grid[row][n - col - 1]) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}

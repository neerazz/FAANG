/**
 * Crated on:  Apr 04, 2020
 */
public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros") + " should be [3].");
        System.out.println(minDistance("intention", "execution") + " should be [5].");
        System.out.println(minDistance("ros", "ros") + " should be [0].");
        System.out.println(minDistance("horse", "") + " should be [5].");
        System.out.println(minDistance("", "ros") + " should be [3].");
        System.out.println(minDistance("distance", "springbok") + " should be [9].");

    }

    public static int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return 0;
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();
        if (word1.equals(word2)) return 0;
        int rows = word2.length(), cols = word1.length();
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < cols; i++) {
            dp[0][i] = i;
        }
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                if (word1.charAt(col - 1) == word2.charAt(row - 1)) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    dp[row][col] = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]) + 1;
                }
            }
        }
        return dp[rows][cols];
    }
}

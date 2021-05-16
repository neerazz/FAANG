package weekly.weekly229;

/**
 * Created on:  Feb 20, 2021
 * Questions:
 */

public class MaximizePalindromeLengthFromSubsequences {

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("cacb", "abba") + " = 5");
//        System.out.println(longestPalindrome("ab", "ab") + " = 3");
        System.out.println(longestPalindrome("ab", "aa") + " = 3");
//        System.out.println(longestPalindrome("aa", "bb") + " = 0");
//        System.out.println(longestPalindrome("ceebeddc", "d") + " = 3");
    }

    public static int longestPalindrome(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length(), total = l1 + l2;
        int[][] dp = new int[total + 1][total + 1];
        longestPalindromeSubseq(word1 + word2, dp);
        int max = 0;
        for (int i1 = 0; i1 < l1; i1++) {
            for (int i2 = 0; i2 < l2; i2++) {
                if (word1.charAt(i1) == word2.charAt(i2)) {
                    max = Math.max(max, dp[i1+1][l1 + i2 + 1]);
                }
            }
        }
        return max;
    }

    public static void longestPalindromeSubseq(String word, int[][] dp) {
        int len = word.length();
        for (int l = 1; l <= len; l++) {
            for (int row = 1; row + l <= len; row++) {
                int col = row + l;
                dp[row][row] = dp[col][col] = 1;
                if (word.charAt(row - 1) == word.charAt(col - 1)) {
                    dp[row][col] = 2 + dp[row + 1][col - 1];
                } else {
                    dp[row][col] = Math.max(dp[row][col - 1], dp[row + 1][col]);
                }
            }
        }
    }

    private static boolean isPalindrome(String str) {
        System.out.println("str = " + str);
        int s = 0, e = str.length() - 1;
        while (s < e) {
            if (str.charAt(s++) != str.charAt(e--)) return false;
        }
        return true;
    }
}

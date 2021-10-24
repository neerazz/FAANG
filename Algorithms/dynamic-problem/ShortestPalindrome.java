/**
 * Created on:  Jul 18, 2021
 * Ref : https://leetcode.com/problems/shortest-palindrome/
 */
public class ShortestPalindrome {
    public static void main(String[] args) {

    }

    public String shortestPalindrome(String s) {
        int len = s.length();
        int largest = 0;
        for (int i = 0; i < len; i++) {
            if (isPalindrome(s, 0, i)) {
                largest = i;
            }
        }
        if (largest == len) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(largest + 1));
        String reverse = sb.reverse().toString();
        return reverse + s;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    public String shortestPalindrome_dp(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        calculateDp(s, len, dp);
        int largest = 0;
        for (int i = 0; i < len; i++) {
            if (dp[0][i]) {
                largest = i;
            }
        }
        if (largest == len) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i > largest; i--) {
            sb.append(s.charAt(i));
        }
        sb.append(s.substring(0, largest + 1));
        for (int i = largest + 1; i < len; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private void calculateDp(String str, int len, boolean[][] dp) {
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = str.charAt(i) == str.charAt(j);
                } else {
                    dp[i][j] = str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1];
                }
            }
        }
    }
}

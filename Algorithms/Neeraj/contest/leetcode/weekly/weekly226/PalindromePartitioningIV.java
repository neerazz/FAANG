package weekly.weekly226;

/**
 * Created on:  Jan 30, 2021
 * Questions:
 */

public class PalindromePartitioningIV {

    public static void main(String[] args) {
        System.out.println(checkPartitioning("abcbdd") + " = true");
    }

    public static boolean checkPartitioning(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len + 1][len + 1];
        char[] chars = s.toCharArray();
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (chars[i] == chars[j]) {
//                    If there is more then one char between i & j then get the dp value of that.
                    dp[i][j] = i + 1 <= j - 1 ? dp[i + 1][j - 1] : true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
//        Start from 1 so that prefix have atleast one char.
//        End at len-1, so that suffix have atleast one char.
        for (int i = 1; i < len - 1; i++) {
            for (int j = i; j < len - 1; j++) {
                if (dp[0][i - 1] && dp[i][j] && dp[j + 1][len - 1]) return true;
            }
        }
        return false;
    }

    public static boolean checkPartitioning_naive(String s) {
        int len = s.length();
        Boolean[][] dp = new Boolean[len + 1][3];
        return helper(s, 0, 0, 3, dp);
    }

    private static boolean helper(String s, int start, int cur, int req, Boolean[][] dp) {
        if (start == s.length()) {
            return cur == req;
        }
        if (cur >= req) return false;
        if (dp[start][cur] != null) return dp[start][cur];
        String str = "";
        for (int i = start; i < s.length(); i++) {
            str += s.charAt(i);
            if (isPalindrome(str) && helper(s, i + 1, cur + 1, req, dp)) {
                return dp[start][cur] = true;
            }
        }
        return dp[start][cur] = false;
    }

    private static boolean isPalindrome(String str) {
        int s = 0, e = str.length() - 1;
        while (s < e) {
            if (str.charAt(s++) != str.charAt(e--)) return false;
        }
        return true;
    }
}

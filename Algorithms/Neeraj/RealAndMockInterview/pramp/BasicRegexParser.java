/**
 * Created on:  Sep 12, 2020
 * Questions: https://www.pramp.com/challenge/KvZ3aL35Ezc5K9Eq9Llp
 * Questions: https://leetcode.com/problems/regular-expression-matching/
 */
public class BasicRegexParser {
    public static void main(String[] args) {
        System.out.println(isMatch("mississippi", "mis*is*p*.") + " = false");
    }

    public static boolean isMatch(String text, String pattern) {
        if (text.length() == 0 || pattern.equals("*")) return true;
        Boolean[][] dp = new Boolean[text.length() + 1][pattern.length() + 1];
        return helper(text, 0, pattern, 0, dp);
    }

    public static boolean helper(String test, int i, String pattern, int j, Boolean[][] dp) {
        if (test.length() == i && pattern.length() == j) return true;
        if (test.length() <= i || pattern.length() <= j) return false;
        if (pattern.substring(j).equals("*")) return true;
        if (dp[i][j] != null) return dp[i][j];
        if (pattern.charAt(j) == '.') {
            dp[i][j] = helper(test, i + 1, pattern, j + 1, dp);
        } else if (pattern.charAt(j) == '*') {
            for (int start = i; start < test.length(); start++) {
                if (helper(test, start, pattern, j + 1, dp)) return dp[i][j] = true;
            }
            dp[i][j] = false;
        } else {
//            return dp[i][j] = (test.charAt(i) == pattern.charAt(j) && helper(test, i + 1, pattern, j + 1, dp)) || helper(test, i, pattern, j + 1, dp);
            dp[i][j] = test.charAt(i) == pattern.charAt(j) && helper(test, i + 1, pattern, j + 1, dp);
        }
//        System.out.println("test = " + test + ", i = " + i + ", pattern = " + pattern + ", j = " + j + ", dp[i][j] = " + dp[i][j]);
        return dp[i][j];
    }
}

import java.util.Arrays;

/**
 * Crated on:  Apr 06, 2020
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println("***************************** Solution 1 *************************");
        System.out.println(isMatch("aab", "c*a*b") + " should be [true].");
        System.out.println(isMatch("", "c*") + " should be [true].");
        System.out.println(isMatch("mississippi", "mis*is*p*.") + " should be [false].");
        System.out.println(isMatch("ab", ".*c") + " should be [false].");

        System.out.println("***************************** Solution 2 *************************");
//        System.out.println(isMatch_rev2("aab", "c*a*b") + " should be [true].");
//        System.out.println(isMatch_rev2("", "c*") + " should be [true].");
//        System.out.println(isMatch_rev2("mississippi", "mis*is*p*.") + " should be [false].");
        System.out.println(isMatch_rev2("ab", ".*c") + " should be [false].");
        System.out.println(isMatch_rev2("aab", "c*a*b") + " should be [true].");
    }

    public static boolean isMatch_rev2(String s, String p) {
        if (s.equals(p)) return true;
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return helper(s, p, 0, 0, dp);
    }

    static boolean helper(String s, String p, int i, int j, Boolean[][] dp) {
//        Keep track of the the pattern if it has a * in next char, based on that either one index in input or move two index in pattern.
        boolean nextIsStar = j + 1 < p.length() && p.charAt(j + 1) == '*';
        if (s.length() == i) {
//            Pattern also ends
            if (j == p.length()) return true;
//            If pattern has * in the next char.
            if (nextIsStar) return helper(s, p, i, j + 2, dp);
            return false;
        }
//        If pattern is ended and string has chars.
        if (j >= p.length()) return false;
        if (dp[i][j] != null) return dp[i][j];
        boolean firstMath = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
        if (nextIsStar) {
//            If the next character in pattern is *, then either of the below case is correct.
//              1. If the current char match, then move to next char in string. (Means more then one char in s string is considered for * in pattern).
            boolean op1 = firstMath && helper(s, p, i + 1, j, dp);
//              2. The current char occurrence in pattern is 0 and the next char (*) in pattern needs to be skipped due to preceding element.
//                  Move the pattern pointer by 2, and keep the input pointer at place.
            boolean op2 = helper(s, p, i, j + 2, dp);
            return dp[i][j] = op1 || op2;
        } else {
            return dp[i][j] = firstMath && helper(s, p, i + 1, j + 1, dp);
        }
    }

    public static boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 0; i <= sLen; i++) { // i == 0 to fill up i=0 column. in order to handle s="", p="c*"
            for (int j = 1; j <= pLen; j++) {
                if (j - 1 >= 0 && p.charAt(j - 1) == '*') {
//                    If it is a wild character, if either of the below cases are true set true.
//                      1. Then check if the previous chars are matching,
//                      2. Or if the pre chars is also a '.' wild char.
//                    Else take the dp val at pre char, as in regular expression we can ignore chars.
                    boolean preMatch = i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.');
                    dp[i][j] = preMatch && dp[i - 1][j] || dp[i][j - 2];
                } else {
//                    If it is not a wild char, then the s char should match p char (or it can be '.')
//                    If it matches then take the left top value or else, set to false
                    boolean firstMatch = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                    dp[i][j] = firstMatch && dp[i - 1][j - 1];
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[sLen][pLen];
    }
}

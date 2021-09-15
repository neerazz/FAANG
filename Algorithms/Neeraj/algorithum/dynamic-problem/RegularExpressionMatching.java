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
        System.out.println(isMatch_rev2("aab", "c*a*b") + " should be [true].");
        System.out.println(isMatch_rev2("", "c*") + " should be [true].");
        System.out.println(isMatch_rev2("mississippi", "mis*is*p*.") + " should be [false].");
        System.out.println(isMatch_rev2("ab", ".*c") + " should be [false].");
        System.out.println(isMatch_rev2("aab", "c*a*b") + " should be [true].");

        System.out.println("***************************** Solution 3 *************************");
        System.out.println(isMatch_rev3("aab", "c*a*b") + " should be [true].");
        System.out.println(isMatch_rev3("", "c*") + " should be [true].");
        System.out.println(isMatch_rev3("mississippi", "mis*is*p*.") + " should be [false].");
        System.out.println(isMatch_rev3("ab", ".*c") + " should be [false].");
        System.out.println(isMatch_rev3("aab", "c*a*b") + " should be [true].");
    }

    public static boolean isMatch_rev3(String s, String p) {
        int l1 = s.length(), l2 = p.length();
        Boolean[][] dp = new Boolean[l1][l2];
        return helper(s, 0, l1, p, 0, l2, dp);
    }

    private static boolean helper(String s, int p1, int l1, String p, int p2, int l2, Boolean[][] dp) {
//        System.out.println("s = " + s + ", p1 = " + p1 + ", l1 = " + l1 + ", p = " + p + ", p2 = " + p2 + ", l2 = " + l2);
        boolean nextIsStar = p2 + 1 < p.length() && p.charAt(p2 + 1) == '*';
        if (p1 == l1 && p2 == l2) return true;
//        If you have reached the last char, in string and pattern still has *'s then skip the stars.
        if (p1 == l1 && nextIsStar) return helper(s, p1, l1, p, p2 + 2, l2, dp);
        if (p1 == l1 || p2 == l2) return false;
        if (dp[p1][p2] != null) return dp[p1][p2];
        boolean firstMath = s.charAt(p1) == p.charAt(p2) || p.charAt(p2) == '.';
        dp[p1][p2] = false;
        if (nextIsStar) {
//            Option 1: Match * with no any chars
            boolean op1 = helper(s, p1, l1, p, p2 + 2, l2, dp);
//            Option 2: If first chars matches then
            boolean op2 = firstMath && helper(s, p1 + 1, l1, p, p2, l2, dp);
            return dp[p1][p2] = op1 || op2;
        } else {
            return dp[p1][p2] = firstMath && helper(s, p1 + 1, l1, p, p2 + 1, l2, dp);
        }
    }

    public static boolean isMatch_rev2(String s, String p) {
        if (s.equals(p)) return true;
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        return helper(s, p, 0, 0, dp);
    }

    static boolean helper(String s, String p, int i, int j, Boolean[][] dp) {
//        Keep track of the pattern if it has a * in next char, based on that either one index in input or move two index in pattern.
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
//              1. If the current char match, then move to next char in string. (Means more than one char in s string is considered for * in pattern).
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

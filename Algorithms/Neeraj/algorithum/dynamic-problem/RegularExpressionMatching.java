import java.util.Arrays;

/**
 * Crated on:  Apr 06, 2020
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b") + " should be [true].");
        System.out.println(isMatch("", "c*") + " should be [true].");
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
        System.out.println(Arrays.deepToString(dp));
        return dp[sLen][pLen];
    }
}

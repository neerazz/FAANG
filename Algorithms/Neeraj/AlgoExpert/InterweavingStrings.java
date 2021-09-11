/**
 * Created on:  Feb 24, 2021
 * Questions: https://www.algoexpert.io/questions/Interweaving%20Strings
 * Write a function that takes in three strings and returns a boolean representing whether the third string can be formed by interweaving the first two strings.
 * <p>
 * To interweave strings means to merge them by alternating their letters without any specific pattern. For instance, the strings "abc" and "123" can be interwoven as "a1b2c3", as "abc123", and as "ab1c23" (this list is nonexhaustive).
 * <p>
 * Letters within a string must maintain their relative ordering in the interwoven string.
 * <p>
 * Sample Input
 * one = "algoexpert"
 * two = "your-dream-job"
 * three = "your-algodream-expertjob"
 * Sample Output
 * true
 */

public class InterweavingStrings {

    public static void main(String[] args) {

    }

    public static boolean interweavingStrings(String one, String two, String three) {
        char[] c1 = one.toCharArray(), c2 = two.toCharArray(), c3 = three.toCharArray();
        Boolean[][] dp = new Boolean[c1.length + 1][c2.length + 1];
        return interweavingStrings(c1, 0, c2, 0, c3, 0, dp);
    }

    private static boolean interweavingStrings(char[] c1, int i1, char[] c2, int i2, char[] c3, int i3, Boolean[][] dp) {
        if (i3 == c3.length) return i1 == c1.length && i2 == c2.length;
        if (dp[i1][i2] != null) return dp[i1][i2];
        if (i1 < c1.length && c3[i3] == c1[i1] && i2 < c2.length && c3[i3] == c2[i2]) {
            return dp[i1][i2] = (interweavingStrings(c1, i1 + 1, c2, i2, c3, i3 + 1, dp) || interweavingStrings(c1, i1, c2, i2 + 1, c3, i3 + 1, dp));
        } else if (i1 < c1.length && c3[i3] == c1[i1]) {
            return dp[i1][i2] = interweavingStrings(c1, i1 + 1, c2, i2, c3, i3 + 1, dp);
        } else if (i2 < c2.length && c3[i3] == c2[i2]) {
            return dp[i1][i2] = interweavingStrings(c1, i1, c2, i2 + 1, c3, i3 + 1, dp);
        } else {
            return dp[i1][i2] = false;
        }
    }
}

/**
 * Created on:  Feb 27, 2021
 * Questions:
 * In most modern-day computers, glob patterns are used to refer to multiple file names on the computer's system at once.
 * <p>
 * Glob patterns typically take advantage of the following two special characters:
 * <p>
 * 1) Wildcards, represented by the * symbol, which match any number of characters, including zero characters.
 * 2) Question marks, represented by the ? symbol, which match any single character (exactly one).
 * For example, the glob pattern "*.js" matches any file name ending in the JavaScript .js extension.
 * <p>
 * Write a function that takes in a file name and a pattern (both strings) and returns whether that file name matches the pattern.
 * <p>
 * Sample Input
 * fileName = "abcdefg"
 * pattern = "a*e?g"
 * Sample Output
 * true
 */

public class GlobalMatching {

    public static void main(String[] args) {

    }

    public static boolean globMatching(String fileName, String pattern) {
        int l1 = fileName.length(), l2 = pattern.length();
        Boolean[][] dp = new Boolean[l1][l2];
        return helper(fileName, 0, l1, pattern, 0, l2, dp);
    }

    private static boolean helper(String fileName, int i1, int l1, String pattern, int i2, int l2, Boolean[][] dp) {
        // System.out.println("i1 =" + i1 + " i2 =" + i2);
        if (i1 == l1) {
            while (i2 < l2 && pattern.charAt(i2) == '*') i2++;
            // System.out.println("End : " + fileName.substring(i1) + " and " + pattern.substring(i2) + " has value " + (i2 == l2));
            return i2 == l2;
        }
        if (i1 >= l1 || i2 >= l2) return false;
        if (dp[i1][i2] != null) return dp[i1][i2];
        dp[i1][i2] = false;
        if (pattern.charAt(i2) == '*') {
            for (int i = i1; i <= l1; i++) {
                if (helper(fileName, i, l1, pattern, i2 + 1, l2, dp)) {
                    dp[i1][i2] = true;
                    break;
                }
            }
        } else if (pattern.charAt(i2) == '?' || pattern.charAt(i2) == fileName.charAt(i1)) {
            dp[i1][i2] = helper(fileName, i1 + 1, l1, pattern, i2 + 1, l2, dp);
        }
        // System.out.println(fileName.substring(i1) + " and " + pattern.substring(i2) + " has value " + (dp[i1][i2]));
        return dp[i1][i2];
    }
}

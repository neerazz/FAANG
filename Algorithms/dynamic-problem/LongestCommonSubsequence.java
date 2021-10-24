import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ZXVVYZW", "XKYKZPW") + " should be [X,Y,Z,W]");
    }

    public static int longestCommonSubsequence_count(String text1, String text2) {
        int l1 = text1.length(), l2 = text2.length();
        Integer[][] dp = new Integer[l1][l2];
        return helper(text1, 0, l1, text2, 0, l2, dp);
    }

    static int helper(String s1, int p1, int l1, String s2, int p2, int l2, Integer[][] dp) {
        if (p1 >= l1 || p2 >= l2) return 0;
        if (dp[p1][p2] != null) return dp[p1][p2];
        if (s1.charAt(p1) == s2.charAt(p2)) {
            dp[p1][p2] = 1 + helper(s1, p1 + 1, l1, s2, p2 + 1, l2, dp);
        } else {
            dp[p1][p2] = Math.max(helper(s1, p1 + 1, l1, s2, p2, l2, dp), helper(s1, p1, l1, s2, p2 + 1, l2, dp));
        }
        return dp[p1][p2];
    }

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        List<Character> op = new ArrayList<>();
        String result = "";
        if (str1.equals(str2)) {
            result = str1;
        } else {
            int cols = str1.length(), rows = str2.length();
            String[][] dp = new String[rows + 1][cols + 1];
            // Set all the array elements to space.
            for (int i = 0; i <= rows; i++) {
                Arrays.fill(dp[i], "");
            }
            System.out.println(Arrays.deepToString(dp));
            for (int row = 1; row <= rows; row++) {
                for (int col = 1; col <= cols; col++) {
                    char x = str1.charAt(col - 1), y = str2.charAt(row - 1);
                    if (x == y) {
                        dp[row][col] = dp[row - 1][col - 1] + x;
                    } else {
                        String left = dp[row][col - 1], top = dp[row - 1][col];
                        if (left.length() > top.length()) {
                            dp[row][col] = left;
                        } else {
                            dp[row][col] = top;
                        }
                    }
                }
            }
            result = dp[rows][cols];
        }
        for (char c : result.toCharArray()) {
            op.add(c);
        }
        return op;
    }
}

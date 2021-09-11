import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ZXVVYZW", "XKYKZPW") + " should be [X,Y,Z,W]");
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

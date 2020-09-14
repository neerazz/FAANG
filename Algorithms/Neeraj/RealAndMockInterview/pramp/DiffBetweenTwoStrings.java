import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Sep 13, 2020
 * Questions: https://www.pramp.com/challenge/5j2xWAx1qPtlZGLnG2O0
 */
public class DiffBetweenTwoStrings {

    static String[] diffBetweenTwoStrings(String source, String target) {
        int rows = source.length(), cols = target.length();
        Integer[][] dp = new Integer[rows + 1][cols + 1];
//        IntStream.rangeClosed(0, rows).forEach(row -> dp[row][cols] = 0);
//        IntStream.rangeClosed(0, cols).forEach(col -> dp[rows][col] = cols - col);
//        for (int row = rows - 1; row >= 0; row--) {
//            for (int col = cols - 1; col >= 0; col--) {
//                if (source.charAt(row) == target.charAt(col)) dp[row][col] = dp[row + 1][col + 1];
//                else dp[row][col] = Math.min(dp[row + 1][col], dp[row][col + 1]) + 1;
//            }
//        }
        dp(source, 0, target, 0, dp);
        int i = 0, j = 0;
        List<String> edits = new ArrayList<>();
        Arrays.stream(dp).forEach(array -> System.out.println(Arrays.toString(array)));
        while (i < rows && j < cols) {
            if (source.charAt(i) == target.charAt(j)) {
                edits.add("" + source.charAt(i));
                i++;
                j++;
            } else if (dp[i + 1][j] <= dp[i][j + 1]) {
                edits.add("-" + source.charAt(i++));
            } else {
                edits.add("+" + target.charAt(j++));
            }
        }
        while (j < cols) {
            edits.add("+" + target.charAt(j++));
        }
        return edits.toArray(new String[0]);
    }

    private static int dp(String source, int i, String target, int j, Integer[][] dp) {
        if (i == source.length()) return dp[i][j] = target.length() - j;
        if (j == target.length()) return dp[i][j] = source.length() - i;
        if (dp[i][j] == null) {
            if (source.charAt(i) == target.charAt(j)) dp[i][j] = dp(source, i + 1, target, j + 1, dp);
            else
                dp[i][j] = 1 + Math.min(dp(source, i + 1, target, j, dp), dp(source, i, target, j + 1, dp));
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(diffBetweenTwoStrings("ABCDEFG", "ABDFFGH")));
        System.out.println(Arrays.toString(diffBetweenTwoStrings("CABAAABBC", "CBBC")));
    }
}

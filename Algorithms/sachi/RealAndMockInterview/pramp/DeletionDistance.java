import java.util.Arrays;

public class DeletionDistance {

    static int deletionDistance(String str1, String str2) {
        if(str1 == null || str2 == null) return 0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        dp[0][0] = 0;

        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[row].length; col++) {
                int val = Math.min(dp[row - 1][col], dp[row][col - 1]);
                if (str1.charAt(row - 1) != str2.charAt(col - 1)) {
                    dp[row][col] = val + 1;
                } else {
                    dp[row][col] = val - 1;
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        System.out.println(deletionDistance("dogyz", "frogyz"));
    }

  /*
      ''  f  r  o   g   y
 ''   0   1  2  3   4   5

  d   1   2  3  4   5   6

  o   1   3  4  3   4   5

  g   1   4  5  4   3   4

  y   1   5  6  5   4   3
*/

}

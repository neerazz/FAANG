public class DeletionDistance {

    static int deletionDistance(String str1, String str2) {

        int[][] dp = new int[str1.length()][str2.length()];

        if (str1.charAt(0) != str2.charAt(0)) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 0;
        }

        for (int i = 1; i <= dp.length; i++) {
            for (int j = 1; j <= dp[i].length; j++) {

                int val = Math.min(dp[i - 1][j], dp[i][j - 1]);
                if (str1.charAt(i - 1) != str2.charAt(j - 1)) {
                    dp[i][j] = val + 1;
                } else {
                    dp[i][j] = val - 1;
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        System.out.println(deletionDistance("dog", "frog"));
    }

  /*
      ''  f  r  o   g   y
 ''   0

  d   0   2  3  4   5   6

  o   0   3  4  3   4   5

  g   0   4  5  4   3   4

  y   0   5  6  5   4   3
*/

}

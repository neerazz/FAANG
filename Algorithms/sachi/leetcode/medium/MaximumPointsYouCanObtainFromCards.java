import java.util.Arrays;

public class MaximumPointsYouCanObtainFromCards {

    public static int maxScore(int[] cardPoints, int k) {

        if (k == 1) {
            return Math.max(cardPoints[0], cardPoints[cardPoints.length - 1]);
        }

        if (k == cardPoints.length) {
            return Arrays.stream(cardPoints).sum();
        }

        int[][] dp = new int[k + 1][cardPoints.length];

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < cardPoints.length; j++) {
                if (i == 0) {
                    dp[i][j] = Math.max(cardPoints[0], cardPoints[j]);
                } else {
                    if (j - i + 1 < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[1][j - i + 1];
                    }
                }
            }
        }
        return dp[k][cardPoints.length - 1];
    }

    public static void main(String[] args) {
        //System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
        //System.out.println(maxScore(new int[]{2, 2, 2}, 2));
        System.out.println(maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
        //System.out.println(maxScore(new int[]{1,1000,1}, 1));
        //System.out.println(maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }
}

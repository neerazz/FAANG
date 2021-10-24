/**
 * Created on:  Aug 10, 2021
 * Ref : https://leetcode.com/problems/new-21-game/
 */
public class New21Game {
    public static void main(String[] args) {

    }

    public static double new21Game(int n, int k, int maxPts) {
        if (k == 0 || k + maxPts <= n) return 1.0;
//        dp[i] = the probability of ending the game with Ith cards.
        Double[] dp = new Double[n + 1];
        dp[0] = 1.0;
        int j = 0, i = 0;
        Double sum = 0.0, total = 0.0;

        while (j <= n) {
//            If Jth game can be played, then there are more probabilities.
            if (j < k) sum += dp[j];
//            When there are no more probabilities of playing game (when you have scored greater than or equal to k).
//              Then add the probabilities that was calculated previously.
            if (j >= k) total += dp[j];
            j++;
//            If picking i th card is beyond allowed points:
//              then reduce only the probability of that card,
//              And increase the card number so that it is not picked next time.
            if (j - i > maxPts) {
                sum -= dp[i];
                i++;
            }
//            If the jth game is with in allowed range (1,n)
            if (j <= n) dp[j] = sum / maxPts;
        }
        return total;
    }
}



/**
 * Created on:  Aug 06, 2021
 * Ref : https://leetcode.com/problems/stone-game-iii/
 */
public class StoneGameIII {
    public static void main(String[] args) {
        System.out.println(stoneGameIII(new int[]{1, 2, 3, 7}));
    }

    public static String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        Score[][] dp = new Score[len][2];
        Score result = helper(stoneValue, 0, 0, len, dp);
        return result.winner();
    }

    private static Score helper(int[] stones, int player, int idx, int len, Score[][] dp) {
        if (idx == len) return new Score();
        if (dp[idx][player] != null) return dp[idx][player];
        Score cur = null;
        int sum = 0;
        for (int i = idx; i < idx + 3 && i < len; i++) {
            sum += stones[i];
            Score next = helper(stones, player ^ 1, i + 1, len, dp);
            if (cur == null || cur.getScore(player) < next.getScore(player) + sum) {
                cur = next.clone();
                cur.scores[player] += sum;
            }
        }
        return dp[idx][player] = cur;
    }

    static class Score {
        int[] scores = new int[2];

        int getScore(int idx) {
            return scores[idx];
        }

        String winner() {
            int compare = Integer.compare(scores[0], scores[1]);
            if (compare == 0) return "Tie";
            if (compare < 0) return "Bob";
            return "Alice";
        }

        public Score clone() {
            Score clone = new Score();
            clone.scores[0] = scores[0];
            clone.scores[1] = scores[1];
            return clone;
        }
    }
}

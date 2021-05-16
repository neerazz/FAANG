package weekly.weekly211;

import java.util.*;

/**
 * Created on:  Oct 17, 2020
 * Questions:
 */

public class BestTeamWithNoConflicts {

    public static void main(String[] args) {
        System.out.println(bestTeamScore(new int[]{988, 511, 618, 880, 214, 589, 576, 744, 865, 830, 478}, new int[]{89, 57, 20, 93, 20, 100, 8, 18, 62, 47, 4}));
        System.out.println(bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1}));
    }

    public static int bestTeamScore(int[] scores, int[] ages) {
        int len = scores.length, best = 0;
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            players.add(new Player(scores[i], ages[i]));
        }
        Collections.sort(players, (p1, p2) -> p1.age == p2.age ? p1.score - p2.score : p1.age - p2.age);
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            Player cur = players.get(i);
            dp[i] = cur.score;
            for (int j = 0; j < i; j++) {
                Player pre = players.get(j);
                if (pre.score > cur.score) {
                    continue;
                } else {
//                    When not conflicting, then take the best score by :
//                      only taking the cur, or by taking score at nonclonflicting player idx + cur;
                    dp[i] = Math.max(dp[i], dp[j] + cur.score);
                }
            }
            best = Math.max(best, dp[i]);
        }
        return best;
    }

    static class Player {
        int score, age;

        public Player(int score, int age) {
            this.score = score;
            this.age = age;
        }
    }
}

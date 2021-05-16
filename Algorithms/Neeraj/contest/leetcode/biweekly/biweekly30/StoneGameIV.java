package biweekly.biweekly30;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Jul 11, 2020
 * Questions: https://leetcode.com/problems/stone-game-iv/
 */
public class StoneGameIV {
    public static void main(String[] args) {
        System.out.println(winnerSquareGame(1) + " should be [true]");
        System.out.println(winnerSquareGame(2) + " should be [false]");
        System.out.println(winnerSquareGame(4) + " should be [true]");
        System.out.println(winnerSquareGame(7) + " should be [false]");
        System.out.println(winnerSquareGame(8) + " should be [true]");
        System.out.println(winnerSquareGame(17) + " should be [false]");
    }

    public static boolean winnerSquareGame(int n) {
//        Get all the possible moves.
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i * i <= n; i++) {
            set.add(i * i);
        }
        Integer[][] dp = new Integer[n + 1][2];
//        Consider 0 -> Alice and 1 -> Bob
        return helper(n, set, 0, dp) == 0;
    }

    //    At each stone count find who can win that game
    private static int helper(int stones, Set<Integer> set, int player, Integer[][] dp) {
//        Check if the current player take all the stones and win the game.
        if (set.contains(stones)) return player;
        if (dp[stones][player] != null) return dp[stones][player];
        boolean canWin = false;
//        Pick all possible combination of stones and let the other player play the game.
//          At each level check if the current player can win the game. (It is because both the players smarter level is same).
        for (int num : set) {
//            player ^ 1 means letting the other player play the game.
//              If any combination gives that current player as winner then ther is a chance for current player to win.
            if (stones > num && helper(stones - num, set, player ^ 1, dp) == player) {
                canWin = true;
                break;
            }
        }
        return dp[stones][player] = canWin ? player : player ^ 1;
    }
}

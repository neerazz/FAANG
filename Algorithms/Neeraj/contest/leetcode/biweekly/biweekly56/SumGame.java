package biweekly.biweekly56;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Jul 10, 2021
 * Ref: https://leetcode.com/problems/sum-game/discuss/1329138/clear-and-easy-to-understand-java
 */

public class SumGame {

    public static void main(String[] args) {
//        System.out.println(sumGame("5023") + " = false");
//        System.out.println(sumGame("25??") + " = true");
//        System.out.println(sumGame("?3295???") + " = false");
        System.out.println(sumGame("??????") + " = true");
    }

    public static boolean sumGame(String num) {
        int leftSum = 0, rightSum = 0, len = num.length(), leftEmpty = 0, rightEmpty = 0;
        for (int i = 0; i < len; i++) {
            char cur = num.charAt(i);
            if (i < len / 2) {
                if (cur == '?') leftEmpty++;
                else leftSum += cur - '0';
            } else {
                if (cur == '?') rightEmpty++;
                else rightSum += cur - '0';
            }
        }
//        If there are no any empty chars (?), then alice when leftSum is not same as rightsum.
        if (leftEmpty == 0 && rightEmpty == 0) return leftSum != rightSum;
//        If the number of blanks are odd, then alice wins since alice starts the game.
        if ((leftEmpty + rightEmpty) % 2 == 1) return true;
//            Since both the players are playing optimally, assume the extreme case where:
//                  alice place 9 on left then bob places 9 on right and visa-versa. Till left and right empty is same.
//                  And in the left\right over: (right-left) or (left-right)
//                      alice always places 9 and since bob has to match he is playing safe by keeping 0's.
        if (leftEmpty < rightEmpty) {
            int diff = (rightEmpty - leftEmpty) / 2;
            rightSum += 9 * diff;
        } else {
            int diff = (leftEmpty - rightEmpty) / 2;
            leftSum += 9 * diff;
        }
        return leftSum != rightSum;
    }

    public static boolean sumGame_dp(String num) {
        int left = 0, right = 0, len = num.length(), empty = 0;
        char[] chars = num.toCharArray();
        for (int i = 0; i < len; i++) {
            char cur = chars[i];
            if (cur == '?') {
                empty++;
            } else {
                if (isLeft(i, len)) left += cur - '0';
                else right += cur - '0';
            }
        }
        Map<String, Integer> dp = new HashMap<>();
//        Integer[][] dp = new Integer[empty + 1][2];
//        dp[i][j] = when there are i questions marks and j'th player plays the game. If dp value is 0 then alice wins, if 1 bob wins.
        int result = helper(chars, empty, left, right, len, dp, 0);
        return result == 0;
    }

    private static int helper(char[] chars, int empty, int left, int right, int len, Map<String, Integer> dp, int player) {
        if (empty == 0) {
            System.out.println("chars = " + Arrays.toString(chars) + "\t Left = " + left + " Right = " + right);
            return left == right ? 1 : 0;
        }
        String key = String.format("empty = %d, [%d,%d], Player = %d", empty, left, right, player);
        if (dp.containsKey(key)) return dp.get(key);
//            When alice plays, he aims to change the left and right sum so that he can win the game.
//            When bob plays, he will try to bring left and right sum so that he can win the game.
        for (int i = 0; i < len; i++) {
            if (chars[i] == '?') {
                for (int j = 0; j < 10; j++) {
                    int newLeft = left + (isLeft(i, len) ? j : 0), newRight = right + (isLeft(i, len) ? 0 : j);
                    chars[i] = (char) ('0' + j);
                    int next = helper(chars, empty - 1, newLeft, newRight, len, dp, player ^ 1);
//                    If Current player can win then return current
                    if (next == player) {
                        dp.put(key, player);
                        return player;
                    }
                    chars[i] = '?';
                }
            }
        }
//        The current player cannot win
        dp.put(key, player ^ 1);
        return player ^ 1;
//        if (player == 0) {
//
//        } else {
//            for (int i = 0; i < len; i++) {
//                if (chars[i] == '?') {
//                    for (int j = 0; j < 10; j++) {
//                        int newLeft = left + (isLeft(i, len) ? j : 0), newRight = right + (isLeft(i, len) ? 0 : j);
//                        chars[i] = (char) ('0' + j);
//                        int next = helper(chars, empty - 1, newLeft, newRight, len, dp, player ^ 1);
//                        if (next == 1) return dp[empty][player] = 0;
//                        chars[i] = '?';
//                    }
//                }
//            }
//        }
    }

    static boolean isLeft(int idx, int len) {
        return idx < len / 2;
    }
}

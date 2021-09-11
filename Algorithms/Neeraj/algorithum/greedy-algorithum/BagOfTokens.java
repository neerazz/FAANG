import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Oct 25, 2020
 * Questions: https://leetcode.com/problems/bag-of-tokens/
 */

public class BagOfTokens {

    static int max;

    public static void main(String[] args) {
        System.out.println("******************************** Solution 1 ***************************************");
        System.out.println(bagOfTokensScore(new int[]{100}, 50));
        System.out.println(bagOfTokensScore(new int[]{100, 200}, 100));
        System.out.println(bagOfTokensScore(new int[]{100, 200, 300}, 150));
        System.out.println(bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
        System.out.println(bagOfTokensScore(new int[]{26}, 51));
        System.out.println(bagOfTokensScore(new int[]{58, 91}, 50));
        System.out.println(bagOfTokensScore(new int[]{9591, 1301, 9665, 3622, 4733, 2926, 9371, 9581, 6359, 1840, 9929, 1025, 5808, 1564, 8976}, 9456));

        System.out.println("******************************** Solution 2 ***************************************");
        System.out.println(bagOfTokensScore_optimal(new int[]{100}, 50));
        System.out.println(bagOfTokensScore_optimal(new int[]{100, 200}, 100));
        System.out.println(bagOfTokensScore_optimal(new int[]{100, 200, 300}, 150));
        System.out.println(bagOfTokensScore_optimal(new int[]{100, 200, 300, 400}, 200));
        System.out.println(bagOfTokensScore_optimal(new int[]{26}, 51));
        System.out.println(bagOfTokensScore_optimal(new int[]{58, 91}, 50));
        System.out.println(bagOfTokensScore_optimal(new int[]{9591, 1301, 9665, 3622, 4733, 2926, 9371, 9581, 6359, 1840, 9929, 1025, 5808, 1564, 8976}, 9456));
    }

    public static int bagOfTokensScore_optimal(int[] tokens, int p) {
        int len = tokens.length, score = 0, max = 0;
        if (len == 0) return 0;
        if (len == 1) return tokens[0] <= p ? 1 : 0;
        Arrays.sort(tokens);
        int start = 0, end = len - 1;
        while (start <= end) {
            if (p >= tokens[start]) {
                score++;
                p -= tokens[start++];
            } else if (score > 0) {
                score--;
                p += tokens[end--];
            } else {
//                If none of the above is possible then ignore playing the coin. This is the key step.
                start++;
            }
            max = Math.max(max, score);
        }
        return max;
    }

    public static int bagOfTokensScore(int[] tokens, int P) {
        max = 0;
        Arrays.sort(tokens);
        Map<String, Integer> memo = new HashMap<>();
        helper(tokens, 0, tokens.length - 1, P, memo);
//        System.out.println("memo = " + memo);
        return max;
    }

    private static int helper(int[] tokens, int start, int end, int pow, Map<String, Integer> memo) {
        if (start > end || pow < 0 || end >= tokens.length) return 0;
        String key = String.format("%d - %d, pow,%d", start, end, pow);
        if (memo.containsKey(key)) return memo.get(key);
        int cur = 0;
        if (start == end) {
            if (tokens[start] <= pow) cur = 1;
        } else {
//        Get the value with out taking the token.
            cur = Math.max(helper(tokens, start + 1, end, pow, memo), helper(tokens, start, end - 1, pow, memo));
//        check if you can take first token face up, and louse token, and gain score.
            if (tokens[start] <= pow) {
                int next = helper(tokens, start + 1, end, pow - tokens[start], memo);
                cur = Math.max(cur, next + 1);
//            Since you gained a score you can now try lose the gained score and take teh poser and get the value.
                int next2 = helper(tokens, start + 1, end - 1, pow - tokens[start] + tokens[end], memo);
                cur = Math.max(cur, next2);
            }
        }
        max = Math.max(max, cur);
        memo.put(key, cur);
        return cur;
    }
}

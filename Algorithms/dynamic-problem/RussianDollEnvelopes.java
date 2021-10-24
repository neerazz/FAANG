import java.util.Arrays;

/**
 * Created on:  Aug 25, 2020
 * Questions: https://leetcode.com/problems/russian-doll-envelopes/
 */
public class RussianDollEnvelopes {
    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}) + " = 3");
        System.out.println(maxEnvelopes(new int[][]{{1, 3}, {3, 5}, {6, 7}, {6, 8}, {8, 4}, {9, 5}}) + " = 3");
        System.out.println(maxEnvelopes(new int[][]{{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}}) + " = 3");
    }

    public static int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);
        Integer[] dp = new Integer[len];
        System.out.println(Arrays.deepToString(envelopes));
        int result = 1;
        for (int i = 0; i < len; i++) {
            result = Math.max(helper(envelopes, i, len, dp), result);
        }
        System.out.println(Arrays.toString(dp));
        return result;
//        return helper(envelopes, 0, len, dp);
    }

    private static int helper(int[][] envelopes, int start, int len, Integer[] dp) {
        if (start == len - 1) return 1;
        if (dp[start] != null) return dp[start];
//         Take value without merging current
        int cur = 0;
        for (int end = start + 1; end < len; end++) {
//             Check if the current can be merged with all other envelop.
//                 If can be merged then take the best with and without merging.
            int next = helper(envelopes, end, len, dp) + (canMerge(envelopes, start, end) ? 1 : 0);
            cur = Math.max(cur, next);
        }
        return dp[start] = cur;
    }

    private static boolean canMerge(int[][] envs, int small, int big) {
        return envs[small][0] < envs[big][0] && envs[small][1] < envs[big][1];
    }
}

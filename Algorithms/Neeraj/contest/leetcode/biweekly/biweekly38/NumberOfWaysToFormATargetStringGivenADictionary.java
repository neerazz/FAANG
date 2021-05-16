package biweekly.biweekly38;

/**
 * Created on:  Oct 31, 2020
 * Questions:
 */

public class NumberOfWaysToFormATargetStringGivenADictionary {

    static int val, mod;

    public static void main(String[] args) {
        System.out.println(numWays(new String[]{"acca", "bbbb", "caca"}, "aba") + " should be [6]");
        System.out.println(numWays(new String[]{"abba", "baab"}, "bab") + " should be [4]");
        System.out.println(numWays(new String[]{"abcd"}, "abcd") + " should be [1]");
        System.out.println(numWays(new String[]{"abab", "baba", "abba", "baab"}, "abba") + " should be [16]");

        System.out.println("********************************* DP ************************************");
        System.out.println(numWays_dp(new String[]{"acca", "bbbb", "caca"}, "aba") + " should be [6]");
        System.out.println(numWays_dp(new String[]{"abba", "baab"}, "bab") + " should be [4]");
        System.out.println(numWays_dp(new String[]{"abcd"}, "abcd") + " should be [1]");
        System.out.println(numWays_dp(new String[]{"abab", "baba", "abba", "baab"}, "abba") + " should be [16]");
    }

    public static int numWays_dp(String[] words, String target) {
        val = 0;
        mod = 1_000_000_007;
        int len = words[0].length();
        int[][] count = new int[len][26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }
        Integer[][] dp = new Integer[len + 1][target.length() + 1];
        return helper_dp(count, 0, len, target, 0, dp);
    }

    private static int helper_dp(int[][] count, int p1, int len, String target, int p2, Integer[][] dp) {
        if (p2 == target.length()) return 1;
        char curChar = target.charAt(p2);
        if (p1 >= len) return 0;
        if (dp[p1][p2] != null) return dp[p1][p2];
//        Get the value without taking any value from the current words list.
        int cur = helper_dp(count, p1 + 1, len, target, p2, dp);
        if (count[p1][curChar - 'a'] == 0) return cur % mod;
//        Else consider the current char.
        long next = helper_dp(count, p1 + 1, len, target, p2 + 1, dp);
        long val = next * count[p1][curChar - 'a'];
        return dp[p1][p2] = (cur + (int) (val % mod)) % mod;
    }

    public static int numWays(String[] words, String target) {
        val = 0;
        mod = 1_000_000_007;
        int len = words[0].length();
        int[][] count = new int[len][26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }
        helper(count, 0, len, target, 0, 1);
        return val;
    }

    private static void helper(int[][] count, int p1, int len, String target, int p2, long soFar) {
        if (target.length() == p2) {
            val = (int) ((val + soFar) % mod);
        } else if (p1 >= len) {
            return;
        } else {
            char curChar = target.charAt(p2);
            for (int i = p1; i < len; i++) {
                if (count[i][curChar - 'a'] > 0) {
                    helper(count, i + 1, len, target, p2 + 1, soFar * count[i][curChar - 'a']);
                }
            }
        }
    }
}

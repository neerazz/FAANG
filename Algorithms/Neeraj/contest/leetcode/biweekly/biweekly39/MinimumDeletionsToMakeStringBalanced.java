package biweekly.biweekly39;

/**
 * Created on:  Nov 14, 2020
 * Questions: https://leetcode.com/contest/biweekly-contest-39/problems/minimum-deletions-to-make-string-balanced/
 */

public class MinimumDeletionsToMakeStringBalanced {

    static int[][] counts;

    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab"));
        System.out.println(minimumDeletions("bbaaaaabb"));
    }

    /*
        Greedy Approach: At every step where an unbalanced string is encounter, decided if you have to delete all b's. Or the current.
     */
    public static int minimumDeletions_elegent(String s) {
        int deleted = 0, bs = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
//                deleted+1 represents removing the new a character that just came in
//                bs represents removing all bs seen so far in the dynamic program
                deleted = Math.min(deleted + 1, bs);
            } else {
                bs++;
            }
        }
        return deleted;
    }

    public static int minimumDeletions(String s) {
        int len = s.length();
        counts = new int[len][2];
        Integer[] dp = new Integer[len];
        int a = 0, b = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == 'a') a++;
            else b++;
            counts[i][0] = a;
            counts[i][1] = b;
        }
        return helper(s, 0, dp);
    }

    private static int helper(String str, int start, Integer[] dp) {
        if (start == str.length()) return 0;
//        When there is only one chars after the current index then there is no need to delete any chars
        if (counts[start][0] == 0 || counts[start][1] == 0) return 0;
        if (dp[start] != null) return dp[start];
        int cur = Integer.MAX_VALUE;
        int a = 0, b = 0;
        for (int p2 = start; p2 < str.length(); p2++) {
            char c = str.charAt(p2);
            if (c == 'b') {
                b++;
            } else {
                if (b == 0) {
//                    Then no any b's are ahead of this a
                    a++;
                } else {
//                    There is a b ahead of this a, there can be two cases:
//                            1. Delete all b's that came so far, and get the deletes of remaining string.
                    int case1 = b + helper(str, p2, dp);
//                            2. Delete all a's after this point.
                    int case2 = counts[p2][0];
                    cur = Math.min(case1, case2);
                    break;
                }
            }
        }
        return dp[start] = cur == Integer.MAX_VALUE ? 0 : cur;
    }
}

package weekly.weekly199;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Jul 25, 2020
 * Questions: https://leetcode.com/problems/string-compression-ii/
 */
public class StringCompressionII {
    public static void main(String[] args) {
        System.out.println(getLengthOfOptimalCompression("aaabcccd", 2) + " = 4");
    }

    public static int getLengthOfOptimalCompression(String s, int k) {
        if (s.length() <= k) return 0;
        List<int[]> chars = new ArrayList<>();
        char pre = s.charAt(0);
        int preCount = 1;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (pre == cur) {
                preCount++;
            } else {
                chars.add(new int[]{pre, preCount});
                pre = cur;
                preCount = 1;
            }
        }
        Integer[][][] dp = new Integer[chars.size() + 1][s.length() + 1][k + 1];
        return helper(chars, 0, 0, k, dp);
    }

    private static int helper(List<int[]> chars, int idx, int pre, int k, Integer[][][] dp) {
        if (idx == chars.size()) {
//            You have reached to the end of characters.
            return 0;
        }
        if (dp[idx][pre][k] != null) return dp[idx][pre][k];
        int[] cur = chars.get(idx);
//        Get the count of same character + continuation chars if any.
//          In cases like `aabbaa` and we delete two `b`, then pre = 2.
        int count = cur[1] + pre;
//        Get count with out removing any character.
        int best = helper(chars, idx + 1, 0, k, dp) + counts(count);
//        Check if we can remove any game-changing characters.
//          Like if count is 1, then by deleting one char is reduced in output. Similarly when 10, removing 1 char will get the
        for (int pos : new int[]{1, 10, 100}) {
            int charsToRemove = count - pos;
//            Removal is possible only if we can remove that many characters, and the chars to remove are positive number.
            if (charsToRemove > 0 && charsToRemove <= k) {
                best = Math.min(best, helper(chars, idx + 1, 0, k, dp) + counts(pos));
            }
        }
        return 0;
    }

    private static int counts(int n) {
//        This is to get n of chars when we have continues n number of same character.
        if (n <= 1) return 1;
        if (n < 10) return 2;
        if (n < 100) return 3;
        return 4;
    }

    private static int compressString(String input) {
        char pre = ' ';
        int letters = 0, rep = 0, nums = 0;
        for (char cur : input.toCharArray()) {
            if (pre == cur) {
                rep++;
            } else {
                if (pre != ' ') letters++;
                if (rep > 1) nums++;
                rep = 1;
            }
            pre = cur;
        }
        letters++;
        if (rep > 1) nums++;
        return letters + nums;
    }
}

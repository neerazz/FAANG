package weekly.weekly249;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Jul 17, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-249/problems/unique-length-3-palindromic-subsequences/
 */
public class UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {

    }

    public static int countPalindromicSubsequence(String s) {
        int len = s.length();
        int[][] left = new int[len][26], right = new int[len][26];
        int[] preCount = new int[26];
//         Build the left array
        for (int i = 0; i < len; i++) {
            left[i] = preCount;
            preCount = incrementAndCopy(preCount, s.charAt(i));
        }
        preCount = new int[26];
//         Build the right side array
        for (int i = len - 1; i >= 0; i--) {
            right[i] = preCount;
            preCount = incrementAndCopy(preCount, s.charAt(i));
        }
        Set<String> set = new HashSet<>();
        for (int i = 1; i < len - 1; i++) {
            int[] leftVals = left[i], rightVals = right[i];
            for (int j = 0; j < 26; j++) {
                int min = Math.min(leftVals[j], rightVals[j]);
                if (min > 0) {
                    char chars = (char) ('a' + j);
                    set.add(" " + chars + s.charAt(i) + chars);
                }
            }
        }
        return set.size();
    }

    static int[] incrementAndCopy(int[] pre, char cur) {
        int[] result = new int[26];
        for (int i = 0; i < 26; i++) {
            result[i] = pre[i];
        }
        result[cur - 'a']++;
        return result;
    }
}

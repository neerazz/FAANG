import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 05, 2021
 * Questions: https://leetcode.com/problems/minimum-window-subsequence/
 */

public class MinimumWindowSubsequence {

    public static void main(String[] args) {

    }

    public static String minWindow(String s, String t) {
        int len = s.length(), min = t.length();
        int[] result = {-1, 0, 0};
        for (int i = 0; i + min <= len; i++) {
            if (s.charAt(i) == t.charAt(0)) {
                int end = getEnd(s, i, t);
                if (end == -1) continue;
                if (result[0] == -1 || result[0] > end - i + 1) {
                    result[0] = end - i + 1;
                    result[1] = i;
                    result[2] = end;
                }
            }
        }
        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }

    private static int getEnd(String s, int i, String t) {
        int j = 0;
        while (i <= s.length()) {
            char cur = s.charAt(i++);
            if (t.charAt(j) == cur) j++;
            if (j == t.length()) return i - 1;
        }
        return -1;
    }
}

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 11, 2024
 * Ref:
 */

public class FindPatternInString {

    public static void main(String[] args) {
        System.out.println(getPatternCount("abcaeabc", "abc"));
    }

    private static int getPatternCount(String str, String pattern) {
        int count = 0, len = str.length(), p = pattern.length();
//         Build lps.
        int[] lps = new int[p];
        buildLPS(pattern, lps);
        int i = 0, j = 0;
        while (i < len) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == p) {
                    j = lps[j - 1];
                }
            } else {
                if (j > 0) {
//                    Find the previous prefix and suffix.
                    j = lps[j - 1];
                } else {
//                    If there is no any previous prefix then
                    i++;
                }
            }
        }
        return count;
    }

    private static void buildLPS(String pattern, int[] lps) {
        int len = lps.length, pre = 0;
        lps[0] = 0;
        int i = 1;
        while (i < len) {
            if (pattern.charAt(i) == pattern.charAt(pre)) {
                pre++;
                lps[i] = pre;
                i++;
            } else {
                if (pre != 0) {
                    pre = lps[pre - 1];
                } else {
                    lps[i] = pre;
                    i++;
                }
            }
        }
    }


}

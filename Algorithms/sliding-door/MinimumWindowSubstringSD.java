/**
 * Created on:  Jul 02, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/3wDJAYG2pAR
 */

public class MinimumWindowSubstringSD {

    public static void main(String[] args) {

    }

    public static String findSubstring(String str, String pattern) {
        String result = "";
        int[] required = new int[26], window = new int[26];
        for (char c : pattern.toCharArray()) required[c - 'a']++;
        int p1 = 0, p2 = 0, len = str.length(), max = Integer.MAX_VALUE;
        while (p2 < len) {
            char cur = str.charAt(p2);
            window[cur - 'a']++;
            while (p1 <= p2 && hasRequired(required, window)) {
                if (p2 - p1 + 1 < max) {
                    max = p2 - p1 + 1;
                    result = str.substring(p1, p2 + 1);
                }
                window[str.charAt(p1++) - 'a']--;
            }
            p2++;
        }
        return result;
    }

    static boolean hasRequired(int[] required, int[] cur) {
        for (int i = 0; i < 26; i++) {
            if (required[i] > cur[i]) return false;
        }
        return true;
    }
}

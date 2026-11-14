/**
 * Created on:  Oct 05, 2020
 * Questions: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/longest-substring-with-same-letters-after-replacement-hard
 */

public class LongestSubstringWithSameLettersAfterReplacement {

    public static void main(String[] args) {

    }

    public static int findLength(String str, int k) {
        int max = Integer.MIN_VALUE, len = str.length();
        for (int i = 0; i < len; i++) {
            int temp = k, count = 0, j = i;
            while (j < len && (str.charAt(i) == str.charAt(j) || temp > 0)) {
                count++;
                temp -= str.charAt(i) == str.charAt(j) ? 0 : 1;
                j++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}

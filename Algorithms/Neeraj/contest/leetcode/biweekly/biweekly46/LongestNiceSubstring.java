package biweekly.biweekly46;

/**
 * Created on:  Feb 20, 2021
 * Questions:
 */

public class LongestNiceSubstring {

    public static void main(String[] args) {

    }

    public static String longestNiceSubstring(String s) {
        int len = s.length();
        int[] result = {0, 0, 0};
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            int[] small = new int[26], big = new int[26];
            for (int j = i; j < len; j++) {
                char cur = chars[j];
                if (Character.isUpperCase(cur)) {
                    big[cur - 'A']++;
                } else {
                    small[cur - 'a']++;
                }
                if (isValid(small, big) && result[0] < j - i + 1) {
                    result[0] = j - i + 1;
                    result[1] = i;
                    result[2] = j + 1;
                }
            }
        }
        return s.substring(result[1], result[2]);
    }

    private static boolean isValid(int[] small, int[] big) {
        for (int i = 0; i < 26; i++) {
            if (small[i] == 0 && big[i] > 0) return false;
            if (small[i] > 0 && big[i] == 0) return false;
        }
        return true;
    }
}

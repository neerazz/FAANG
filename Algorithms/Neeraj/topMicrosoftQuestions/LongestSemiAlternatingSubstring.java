/**
 * Created on:  Oct 31, 2020
 * Questions: https://leetcode.com/discuss/interview-question/398037/
 */

public class LongestSemiAlternatingSubstring {

    public static void main(String[] args) {
        System.out.println(getLongestSemiAlternatingSubString("baaabbabbb") + " should be 7");
        System.out.println(getLongestSemiAlternatingSubString("babba") + " should be 5");
        System.out.println(getLongestSemiAlternatingSubString("abaaaa") + " should be 4");
    }

    /*
              i
            baaabbabbb
                     j
     */
    private static int getLongestSemiAlternatingSubString(String s) {
        int max = 0, count = 1, len = s.length(), p1 = 0;
        for (int p2 = 1; p2 < len; p2++) {
            if (s.charAt(p2 - 1) == s.charAt(p2)) {
                count++;
            } else {
                count = 1;
            }
            if (count < 3) {
                max = Math.max(max, p2 - p1 + 1);
            } else {
                p1 = p2 - 1;
                count = 2;
            }
        }
        return max;
    }
}

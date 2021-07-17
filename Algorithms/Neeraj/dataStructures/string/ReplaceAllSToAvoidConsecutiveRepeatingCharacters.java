/**
 * Created on:  Jun 23, 2021
 * Ref: https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters
 */

public class ReplaceAllSToAvoidConsecutiveRepeatingCharacters {

    public static void main(String[] args) {

    }

    public static String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int j = 0; j < s.length(); j++) {
            char cur = chars[j];
            if (cur == '?') {
                for (int i = 0; i < 26; i++) {
                    char newChar = (char) ('a' + i);
                    boolean valid = true;
                    if (j + 1 < chars.length) {
//                         Check only right
                        valid = newChar != chars[j + 1];
                    }
                    if (valid && j - 1 >= 0) {
//                         Check only left
                        valid = newChar != chars[j - 1];
                    }
                    if (valid) {
                        chars[j] = newChar;
                        break;
                    }
                }
            }
        }
        return String.valueOf(chars);
    }
}

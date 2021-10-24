/**
 * Created on:  Sep 23, 2021
 * Ref: https://leetcode.com/problems/break-a-palindrome/
 */
public class BreakAPalindrome {
    public static void main(String[] args) {

    }

    public static String breakPalindrome(String pal) {
        int len = pal.length();
        if (len <= 1) return "";
        char[] chars = pal.toCharArray();
        boolean changed = false;
        for (int i = 0; i < len; i++) {
            char cur = chars[i];
            if (cur != 'a') {
                chars[i] = 'a';
                if (isPalindrome(chars)) {
                    chars[i] = cur;
                } else {
                    changed = true;
                    break;
                }
            }
        }
        if (!changed) chars[len - 1] = 'b';
        return String.valueOf(chars);
    }

    static boolean isPalindrome(char[] chars) {
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (chars[start++] != chars[end--]) return false;
        }
        return true;
    }
}

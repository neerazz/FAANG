/**
 * Created on:  Oct 01, 2020
 * Questions: https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String str) {
        int s = 0, e = str.length() - 1;
        while (s < e) {
            while (s < str.length() && !Character.isLetterOrDigit(str.charAt(s))) s++;
            while (e >= 0 && !Character.isLetterOrDigit(str.charAt(e))) e--;
            if (s < e && Character.toLowerCase(str.charAt(s++)) != Character.toLowerCase(str.charAt(e--))) return false;
        }
        return true;
    }
}

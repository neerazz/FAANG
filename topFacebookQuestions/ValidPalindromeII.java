/**
 * Created on:  Jul 19, 2020
 * Questions: https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII {
    public static void main(String[] args) {
        System.out.println(validPalindrome("aba") + " [true]");
        System.out.println(validPalindrome("abca") + " [true]");
        System.out.println(validPalindrome("abca") + " [true]");
        System.out.println(validPalindrome("abc") + " [false]");
    }

    public static boolean validPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        return helper(s, start, end, true);
    }

    private static boolean helper(String s, int start, int end, boolean canDelete) {
        if (start > end) return false;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                if (canDelete) {
//                    You can remove the starting character or the ending character.
                    return helper(s, start, end - 1, false) || helper(s, start + 1, end, false);
                }
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

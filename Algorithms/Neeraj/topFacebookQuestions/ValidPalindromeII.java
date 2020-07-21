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
        return helper(s, true);
    }

    private static boolean helper(String s, boolean canDelete) {
        int start = 0, end = s.length() - 1, diff = 0;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
//                You can remove the starting character or the ending character.
                if (!canDelete) return false;
                return helper(s.substring(start, end), false) || helper(s.substring(start + 1, end + 1), false);
            }
            start++;
            end--;
        }
        return true;
    }
}

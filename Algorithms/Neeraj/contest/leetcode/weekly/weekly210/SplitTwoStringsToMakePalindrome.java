package weekly.weekly210;

/**
 * Created on:  Oct 10, 2020
 * Questions: https://leetcode.com/problems/split-two-strings-to-make-palindrome
 */

public class SplitTwoStringsToMakePalindrome {

    public static void main(String[] args) {

    }

    public static boolean checkPalindromeFormation(String a, String b) {
        int len = a.length();
        if (isPalindrome(a, 0, len - 1) || isPalindrome(b, 0, len - 1)) return true;
        return checkPrefixAndSuffix(a, b) || checkPrefixAndSuffix(b, a);
    }

    private static boolean checkPrefixAndSuffix(String a, String b) {
        int len = a.length(), p1 = 0, p2 = len - 1;
        while (p1 < p2 && a.charAt(p1) == b.charAt(p2)) {
            ++p1;
            --p2;
        }
        return isPalindrome(a, p1, p2) || isPalindrome(b, p1, p2);
    }
    private static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

    public static boolean checkPalindromeFormation_naive(String a, String b) {
        int len = a.length();
        if (isPalindrome(a, 0, len - 1) || isPalindrome(b, 0, len - 1)) return true;
        for (int i = 0; i < len; i++) {
            String first = a.substring(0, i) + b.substring(i), second = b.substring(0, i) + a.substring(i);
            if (isPalindrome(first, 0, len - 1) || isPalindrome(second, 0, len - 1)) return true;
        }
        return false;
    }

}

/**
 * Created on:  Nov 04, 2020
 * Questions: https://leetcode.com/discuss/interview-question/916880/Uber-OA-or-Oct-2020
 * Question -3:
 * <p>
 * For a string, find a prefix with a length greater than 2, and this prefix is ​​one palindrome.
 * Then delete this prefix from the string.
 * The remaining string repeats the previous operation, knowing that it cannot be performed.
 * For example: input: aaaabcbd output: d
 * <p>
 * Explanation:
 * <p>
 * aaaabcbd -> aaaa is the longest prefix, the length is greater than 2, and it is palindrome, so delete it, the remaining string is bbcd,
 * <p>
 * bcbd -> bcb is the longest prefix , length greater than 2, and is Palindrome, so to remove the rest of the string D
 * <p>
 * D -> D is Palindrome, but the length is less than 2, it can not continue to delete
 */

public class LongestPrefixPalindromeRemoval {

    public static void main(String[] args) {
        System.out.println(getStringAfterLongestPrefixPalindromeRemoval("aaaabcbd"));
    }

    private static String getStringAfterLongestPrefixPalindromeRemoval(String str) {
        String prefix = getPrefixPalindrome(str);
        if (prefix.length() > 2) {
            return getStringAfterLongestPrefixPalindromeRemoval(str.substring(prefix.length()));
        }
        return str;
    }

    private static String getPrefixPalindrome(String str) {
        for (int i = str.length() - 1; i >= 2; i--) {
            if (isPalindrome(str, 0, i)) {
                return str.substring(0, i + 1);
            }
        }
        return "";
    }

    private static boolean isPalindrome(String str, int s, int e) {
        while (s < e) {
            if (str.charAt(s++) != str.charAt(e--)) return false;
        }
        return true;
    }
}

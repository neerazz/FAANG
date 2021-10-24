/**
 * Created on:  May 23, 2021
 * Questions: https://leetcode.com/problems/construct-k-palindrome-strings/
 */

public class ConstructKPalindromeStrings {

    public static void main(String[] args) {
        System.out.println(canConstruct("annabelle", 2) + " = true");
        System.out.println(canConstruct("eminem", 2) + " = true");
    }

    //    https://leetcode.com/problems/construct-k-palindrome-strings/discuss/564236/Java-counting-simple-explained
    private static boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        int odds = 0;
        for (int count : counts) {
            odds += count % 2;
        }
//        The chars that are evens can be used in any sub-string. But those that are odd can be used at maximum once, in a sub-string.
        return odds <= k;
    }

    public static boolean canConstruct_wrong_Understanding(String s, int k) {
        int len = s.length();
        boolean[][] isPalindrome = createPalindromeMatrix_2(s, len);
        Boolean[][] dp = new Boolean[len][k + 1];
        return helper(s, 0, k, isPalindrome, dp);
    }

    private static boolean[][] createPalindromeMatrix_2(String s, int len) {
        boolean[][] isPalindrome = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
            for (int j = i + 1; j < len; j++) {
                isPalindrome[i][j] = canFormPalindrome(s.substring(i, j + 1));
            }
        }
        return isPalindrome;
    }

    private static boolean canFormPalindrome(String str) {
        int[] counts = new int[26];
        for (char c : str.toCharArray()) {
            counts[c - 'a']++;
        }
        return canFormPalindrome(counts);
    }

    private static boolean canFormPalindrome(int[] counts) {
        int len = 0, odd = 0;
        for (int i = 0; i < 26; i++) {
            len += counts[i];
            odd += counts[i] % 2 == 1 ? 1 : 0;
        }
        return len % 2 == 1 ? odd <= 1 : odd == 0;
    }

    private static boolean[][] createPalindromeMatrix(String s, int len) {
        boolean[][] isPalindrome = new boolean[len][len];
        for (int l = 1; l < len; l++) {
            for (int i = 0; i < len && i + l - 1 < len; i++) {
                int j = i + l - 1;
                if (l == 1) {
                    isPalindrome[i][j] = true;
                } else {
                    boolean sameChar = s.charAt(i) == s.charAt(j);
                    isPalindrome[i][j] = i + 1 == j ? sameChar : sameChar && isPalindrome[i + 1][j - 1];
                }
            }
        }
        return isPalindrome;
    }

    private static boolean helper(String s, int start, int k, boolean[][] isPalindrome, Boolean[][] dp) {
        if (start == s.length()) return k == 0;
        if (k <= 0) return false;
        if (dp[start][k] != null) return dp[start][k];
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome[start][end] && helper(s, end + 1, k - 1, isPalindrome, dp)) {
                return dp[start][k] = true;
            }
        }
        return dp[start][k] = false;
    }
}

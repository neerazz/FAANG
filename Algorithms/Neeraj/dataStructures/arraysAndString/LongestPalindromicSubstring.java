import java.util.Arrays;

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:
Input: "cbbd"
Output: "bb"
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
//        System.out.println(longestPalindrome("babad") + " should be [bab].");
//        System.out.println(longestPalindrome("a") + " should be [a].");
//        System.out.println(longestPalindrome("bb") + " should be [bb].");
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) return s;
        String output = "";
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j)) && Math.abs(i - j) > maxLength) {
                    maxLength = Math.abs(i - j);
                    output = s.substring(i, j);
                }
            }
        }
        return output;
    }

    private static boolean isPalindrome(String string) {
        int start = 0, end = string.length() - 1;
        while (start < end) {
            if (string.charAt(start++) != string.charAt(end--))
                return false;
        }
        return true;
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num3 = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, num3, 0, nums1.length);
        System.arraycopy(nums2, 0, num3, nums1.length, nums2.length);
        Arrays.sort(num3);
        if (num3.length % 2 == 0) {
            return (num3[(num3.length - 1) / 2] + num3[num3.length / 2]) / 2;
        } else {
            return num3[num3.length / 2];
        }
    }
}
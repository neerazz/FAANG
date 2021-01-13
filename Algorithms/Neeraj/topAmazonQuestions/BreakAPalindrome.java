import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/problems/break-a-palindrome/
 */

public class BreakAPalindrome {

    public static void main(String[] args) {

    }

    public static String breakPalindrome(String palindrome) {
        char[] chars = palindrome.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') continue;
            for (int j = 0; j < 26; j++) {
                char c = (char) ('a' + j);
                if (c != chars[chars.length - i - 1]) {
                    char before = chars[i];
                    chars[i] = c;
                    // System.out.println("Changing at i" + i);
                    if (!isPalindrome(chars)) return String.valueOf(chars);
                    chars[i] = before;
                }
            }
        }
//         If reached the end and len greater then 1. that means all are a's.
        if (chars.length > 1) {
            chars[chars.length - 1]++;
            if (!isPalindrome(chars)) return String.valueOf(chars);
            chars[chars.length - 1]--;
        }
        return "";
    }

    private static boolean isPalindrome(char[] chars) {
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (chars[start++] != chars[end--]) return false;
        }
        return true;
    }
}

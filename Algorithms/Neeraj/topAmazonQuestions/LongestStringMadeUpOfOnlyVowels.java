import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 18, 2021
 * <p>
 * https://leetcode.com/discuss/interview-question/233724/Amazon-online-assessment-Longest-string-made-up-of-only-vowels
 * You are given with a string . Your task is to remove atmost two substrings of any length from the given string such that the remaining string contains vowels('a','e','i','o','u') only. Your aim is the maximise the length of the remaining string. Output the length of remaining string after removal of atmost two substrings.
 * NOTE: The answer may be 0, i.e. removing the entire string.
 * <p>
 * Sample Input
 * 2
 * earthproblem
 * letsgosomewhere
 * Sample Output
 * 3
 * 2
 */

public class LongestStringMadeUpOfOnlyVowels {

    public static void main(String[] args) {
        System.out.println(maxVowels(""));
    }

    private static int maxVowels(String str) {
        int con = 0, vowelCount = 0, len = str.length();
        int start = 0, end = len - 1;
//        If the string starts and ends with the vowels count that.
        while (start < len && isVowel(str.charAt(start))) start++;
        while (end > 0 && isVowel(str.charAt(start))) end--;
        if (start == len || end == -1) return len;
        int sum = 0, largest = 0;
        for (int i = start; i <= end; i++) {
            sum = isVowel(str.charAt(i)) ? sum + 1 : 0;
            largest = Math.max(largest, sum);
        }
        return 0;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

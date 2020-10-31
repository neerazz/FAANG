import java.util.*;

/**
 * Created on:  Oct 31, 2020
 * Questions: https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    static int max;

    public static void main(String[] args) {

    }

//    Time 2 ^n
    public static int maxLength(List<String> arr) {
        max = 0;
        List<String> words = new ArrayList<>();
        for (String str : arr) {
            if (hasUniqueChars(str))
                words.add(str);
        }
        helper(words, "", 0);
        return max;
    }

    private static boolean hasUniqueChars(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            if (++count[c - 'a'] > 1) return false;
        }
        return true;
    }

    private static void helper(List<String> words, String soFar, int i) {
        max = Math.max(max, soFar.length());
        for (int end = i; end < words.size(); end++) {
            if (hasUniqueChars(words.get(end) + soFar)) {
                helper(words, words.get(end) + soFar, end + 1);
            }
        }
    }
}

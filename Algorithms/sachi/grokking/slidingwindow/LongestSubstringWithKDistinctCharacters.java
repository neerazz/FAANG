package grokking.slidingwindow;

import util.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * <p>
 * You can assume that K is less than or equal to the length of the given string.
 * <p>
 * <p>
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * <p>
 * <p>
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * <p>
 * <p>
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */

public class LongestSubstringWithKDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(findLength("araaci", 2));
        System.out.println(findLength("araaci", 1));
        System.out.println(findLength("cbbebi", 3));
        test();
    }

    public static void test() {
        int runs = 100000;
        for (int i = 0; i < runs; i++) {
            String input = Util.generateRandomString(100);
            int k = Util.generateRandomNumber(input.length());
            int expected = findLengthSol(input, k);
            int actual = findLengthSol(input, k);
            if (actual != expected) {
                System.out.println("Failed for: " + input + " with K:" + k);
                System.out.println("Expected: " + expected + " Actual:" + actual);
            }
        }
    }

    public static int findLength(String str, int k) {
        int start = 0, end = 0, sol = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(str.charAt(0), 1);
        while (end < str.length() - 1) {
            if (canGoNext(map, str, start, end, k)) {
                end++;
                sol = Math.max(sol, end - start + 1);
                map.put(str.charAt(end), map.getOrDefault(str.charAt(end), 0) + 1);
            } else {
                if (map.get(str.charAt(end)) == 1) {
                    map.remove(str.charAt(end));
                } else {
                    map.put(str.charAt(start), map.getOrDefault(str.charAt(end), 1) - 1);
                }
                start++;
            }
        }
        return sol;
    }

    public static boolean canGoNext(Map<Character, Integer> map, String s, int start, int end, int k) {
        return map.containsKey(s.charAt(end + 1)) || map.size() < k;
    }

    public static int findLengthSol(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k)
            throw new IllegalArgumentException();

        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }
}

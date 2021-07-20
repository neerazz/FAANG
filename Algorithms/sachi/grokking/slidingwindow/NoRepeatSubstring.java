package grokking.slidingwindow;


import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring, which has no repeating characters.
 * <p>
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 * <p>
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring without any repeating characters is "ab".
 * <p>
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 */

public class NoRepeatSubstring {


    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();

        int start = 0, end = 0, sol = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while (end < s.length() - 1) {
            end++;
            while (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            sol = Math.max(sol, end - start + 1);
        }
        return sol;
    }

}

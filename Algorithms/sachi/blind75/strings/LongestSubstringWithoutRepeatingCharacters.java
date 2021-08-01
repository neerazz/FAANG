package blind75.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * F
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * tmmzuxt -> 5
 *
 *
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }

    //Store value, index in a Map
    //When you see a duplicate move to the Max(prev+1, curr) - This is done so that we never go backwards
    //Solution is =>  Max(sol, end-start+1)
    public static int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, sol = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)) + 1, start);
            }
            map.put(s.charAt(end), end);
            sol = Math.max(sol, end - start + 1);
            end++;
        }
        return sol;
    }

    public static int lengthOfLongestSubstringNaive(String s) {
        if (s.length() < 2) return s.length();
        int start = 0, end = 0, sol = 0;
        char repeated;
        Set<Character> set = new HashSet<>();
        while (end < s.length()) {
            char c2 = s.charAt(end);
            if (set.contains(c2)) {
                //Found Duplicate
                repeated = c2;
                while (start <= end) {
                    char c1 = s.charAt(start++);
                    set.remove(c1);
                    if (c1 == repeated) {
                        break;
                    }
                }
            }
            set.add(c2);
            sol = Math.max(sol, end - start + 1);
            end++;
        }
        return sol;
    }

}

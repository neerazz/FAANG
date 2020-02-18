package ds.hashtable;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1135/
Given a string, find the length of the longest substring without repeating characters.
Example 1:
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb") + " should be [3].");
        System.out.println(lengthOfLongestSubstring("bbbbb") + " should be [1].");
        System.out.println(lengthOfLongestSubstring("") + " should be [0].");
        System.out.println(lengthOfLongestSubstring(" ") + " should be [1].");
        System.out.println(lengthOfLongestSubstring("aab") + " should be [2].");
        System.out.println(lengthOfLongestSubstring("pwwkew") + " should be [3].");
        System.out.println(lengthOfLongestSubstring("ohomm") + " should be [3].");
        System.out.println(lengthOfLongestSubstring("loddktdji") + " should be [5].");
    }

    public static int lengthOfLongestSubstring(String s) {
        List<Character> characters = new ArrayList<>();
        int max = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (characters.contains(current)) {
                max = Math.max(max, count);
                int index = characters.indexOf(current);
                for (int j = index; j >= 0; j--) characters.remove(0);
                count -= index + 1;
            }
            characters.add(current);
            count++;
        }
        return Math.max(max, count);
    }
}

import java.util.HashMap;

/*
https://leetcode.com/explore/learn/card/hash-table/184/comparison-with-other-data-structures/1117/
Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
Example 1:
Input: s = "egg", t = "add"
Output: true
Example 2:
Input: s = "foo", t = "bar"
Output: false
Example 3:
Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add") + " should be [true].");
        System.out.println(isIsomorphic("foo", "bar") + " should be [false].");
        System.out.println(isIsomorphic("paper", "title") + " should be [true].");
        System.out.println(isIsomorphic("ab", "aa") + " should be [false].");
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char first = s.charAt(i);
            char second = t.charAt(i);
            if ((map.containsKey(first) && map.get(first) != second) || (!map.containsKey(first) && map.containsValue(second)))
                return false;
            map.put(first, second);
        }
        return true;
    }
}

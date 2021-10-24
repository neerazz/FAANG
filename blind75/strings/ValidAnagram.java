package strings;

/*
https://leetcode.com/problems/valid-anagram/
P
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

 */
public class ValidAnagram {

    public static void main(String[] args) {

    }

    //Insight - Count and Compare
    //Sorting is another technique that can be used.
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int j : arr) {
            if (j != 0) return false;
        }
        return true;
    }

}

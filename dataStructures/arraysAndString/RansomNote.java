/*
    Created on:  May 03, 2020
 */

/**
 * Questions: https://leetcode.com/problems/ransom-note/
 */
public class RansomNote {
    public static void main(String[] args) {

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for (char c : magazine.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (chars[c - 'a'] > 0) {
                chars[c - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }
}

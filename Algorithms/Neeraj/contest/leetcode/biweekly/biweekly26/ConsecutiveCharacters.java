package biweekly.biweekly26;
/*
    Created on:  May 16, 2020
 */

/**
 * Questions: https://leetcode.com/contest/biweekly-contest-26/problems/consecutive-characters
 */
public class ConsecutiveCharacters {
    public static void main(String[] args) {
        System.out.println(maxPower("leetcode") + " should be [2]");
        System.out.println(maxPower("abbcccddddeeeeedcba") + " should be [5]");
        System.out.println(maxPower("triplepillooooow") + " should be [5]");
        System.out.println(maxPower("hooraaaaaaaaaaay") + " should be [11]");
        System.out.println(maxPower("tourist") + " should be [1]");
        System.out.println(maxPower("cc") + " should be [2]");
    }

    public static int maxPower(String s) {
        if (s.length() < 2) return s.length();
        int[] counts = new int[26];
        int max = 1;
        counts[s.charAt(0) - 'a']++;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                max = Math.max(max, ++counts[s.charAt(i) - 'a']);
            } else {
                counts[s.charAt(i) - 'a'] = 1;
                counts[s.charAt(i - 1) - 'a'] = 0;
            }
        }
        return max;
    }
}

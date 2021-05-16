package weekly.weekly238;

import java.util.*;

/**
 * Created on:  Apr 24, 2021
 * Questions: https://leetcode.com/contest/weekly-contest-238/problems/longest-substring-of-all-vowels-in-order/
 */

public class LongestSubstringOfAllVowelsInOrder {

    public static void main(String[] args) {
        System.out.println(longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
    }

    public static int longestBeautifulSubstring(String word) {
        int max = 0;
        Stack<Character> stack = new Stack<>();
        int[] counts = new int[26];
        for (char cur : word.toCharArray()) {
            if (stack.isEmpty()) {
                if (cur == 'a') {
                    stack.add(cur);
                    counts[cur - 'a']++;
                }
            } else if (isSameOrNext(stack.peek(), cur)) {
                stack.add(cur);
                counts[cur - 'a']++;
            } else {
                stack.clear();
                counts = new int[26];
                if (cur == 'a') {
                    stack.add(cur);
                    counts[cur - 'a']++;
                }
            }
            max = Math.max(max, getCount(counts));
        }
        return max;
    }

    private static int getCount(int[] counts) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (isVowel((char) i) && counts[i] == 0) return 0;
            sum += counts[i];
        }
        return sum;
    }

    private static boolean isSameOrNext(char c1, char c2) {
        if (c1 == c2) return true;
        if (c1 == 'a') return c2 == 'e';
        if (c1 == 'e') return c2 == 'i';
        if (c1 == 'i') return c2 == 'o';
        if (c1 == 'o') return c2 == 'u';
        return false;
    }

    static boolean isVowel(char c) {
        c += 'a';
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

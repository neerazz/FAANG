import java.util.*;

/**
 * Created on:  May 17, 2020
 * Questions: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        System.out.println("*********************** Method 1 ***********************");
        System.out.println(findAnagrams("cbaebabacd", "abc") + " should be [0,6].");
        System.out.println(findAnagrams("abab", "ab") + " should be [0,1,2].");
        System.out.println(findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa") + " should be [].");
        System.out.println("*********************** Method 2 ***********************");
        System.out.println(findAnagrams_optimal("cbaebabacd", "abc") + " should be [0,6].");
        System.out.println(findAnagrams_optimal("abab", "ab") + " should be [0,1,2].");
        System.out.println(findAnagrams_optimal("aaaaaaaaaa", "aaaaaaaaaaaaa") + " should be [0,1,2].");
    }

    public static List<Integer> findAnagrams_optimal(String s, String p) {
        List<Integer> op = new ArrayList<>();
        if (p.length() > s.length()) return op;
        if (p.length() == s.length()) {
            return p.equals(s) ? Arrays.asList(0) : op;
        }
        int[] chars = getCharsCount(p);
        System.out.println(Arrays.toString(chars));
        int p1 = 0, p2 = p.length() - 1;
        int[] slide = getCharsCount(s.substring(p1, p2));
        while (p2 < s.length()) {
            slide[s.charAt(p2++) - 'a']++;
            if (isSame(slide, chars)) {
                op.add(p1);
            }
            slide[s.charAt(p1++) - 'a']--;
        }
        return op;
    }

    private static int[] getCharsCount(String input) {
        int[] chars = new int[26];
        for (char c : input.toCharArray()) {
            chars[c - 'a']++;
        }
        return chars;
    }

    private static boolean isSame(int[] slide, int[] chars) {
        for (int i = 0; i < 26; i++) {
            if (slide[i] != chars[i]) return false;
        }
        return true;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> op = new ArrayList<>();
        String sortedP = getSorted(p);
        int p1 = 0, p2 = p.length();
        while (p2 <= s.length()) {
            String temp = s.substring(p1, p2);
            if (getSorted(temp).equals(sortedP)) {
                op.add(p1);
            }
            p1++;
            p2++;
        }
        return op;
    }

    private static String getSorted(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}

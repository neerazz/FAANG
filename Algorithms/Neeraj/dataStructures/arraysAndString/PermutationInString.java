import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  May 18, 2020
 * Questions: https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {
    public static void main(String[] args) {
        System.out.println("********************* Method 1 ************************");
        System.out.println(checkInclusion("ab", "eidbaooo") + " should be [true]");
        System.out.println(checkInclusion("ab", "eidboaoo") + " should be [false]");
        System.out.println(checkInclusion("adc", "dcda") + " should be [true]");
        System.out.println("********************* Method 2 ************************");
        System.out.println(checkInclusion_optimal("ab", "eidbaooo") + " should be [true]");
        System.out.println(checkInclusion_optimal("ab", "eidboaoo") + " should be [false]");
        System.out.println(checkInclusion_optimal("adc", "dcda") + " should be [true]");
        System.out.println("********************* Method 3 ************************");
        System.out.println(checkInclusion_rev1("ab", "eidbaooo") + " should be [true]");
        System.out.println(checkInclusion_rev1("ab", "eidboaoo") + " should be [false]");
        System.out.println(checkInclusion_rev1("ab", "ba") + " should be [true]");
        System.out.println(checkInclusion_rev1("adc", "dcda") + " should be [true]");
    }

    public static boolean checkInclusion_rev1(String s1, String s2) {
        int[] counts = new int[26];
        for (char c : s1.toCharArray()) {
            counts[c - 'a']++;
        }
        int start = 0, end = 0, len = s1.length();
        while (end < s2.length()) {
            if (counts[s2.charAt(end) - 'a'] > 0) {
                counts[s2.charAt(end++) - 'a']--;
            } else if (start == end) {
                start++;
                end++;
            } else {
                counts[s2.charAt(start++) - 'a']++;
            }
            if ((end - start) == len) return true;
        }
        return (end - start) == len;
    }

    public static boolean checkInclusion_optimal(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] counts = new int[26];
        for (char c : s1.toCharArray()) {
            counts[c - 'a']++;
        }
        int p1 = 0, p2 = 0;
        while (p1 < s2.length() && p2 < s2.length()) {
            char p2C = s2.charAt(p2);
            if (counts[p2C - 'a'] > 0) {
                counts[p2C - 'a']--;
                p2++;
                if (p2 - p1 == s1.length()) {
                    return true;
                }
            } else if (p1 == p2) {
                p1++;
                p2++;
            } else {
                counts[s2.charAt(p1++) - 'a']++;
            }
        }
        return false;
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int p1 = 0, p2 = 0;
        while (p1 < s2.length() && p2 < s2.length()) {
            char p2C = s2.charAt(p2);
            if (map.containsKey(p2C)) {
                int count = map.get(p2C);
                if (count == 1) map.remove(p2C);
                else map.put(p2C, count - 1);
                p2++;
            } else if (p1 == p2) {
                p1++;
                p2++;
            } else {
                map.put(s2.charAt(p1), map.getOrDefault(s2.charAt(p1), 0) + 1);
                p1++;
            }
            if (p2 - p1 == s1.length()) {
                if (map.isEmpty()) {
                    return true;
                } else {
                    map.put(s2.charAt(p1), map.getOrDefault(s2.charAt(p1), 0) + 1);
                    p1++;
                }
            }
        }
        return false;
    }
}

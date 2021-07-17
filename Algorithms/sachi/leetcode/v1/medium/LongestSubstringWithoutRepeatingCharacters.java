package leetcode.v1.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {


    public static int lengthOfLongestSubstring(String s) {

        int p1 = 0, p2 = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (p2 < s.length() && p1 < s.length()) {
            char c = s.charAt(p2);
            if (map.containsKey(c)) {
                int i = map.get(c);
                while (p1 <= i) {
                    map.remove(s.charAt(p1));
                    p1++;
                }
            } else {
                map.put(c, p2);
                max = Math.max(max, p2 - p1+1);
                p2++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}

import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Nov 26, 2020
 * Questions: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
    }

    public static int longestSubstring(String s, int k) {
        int max = 0, unique = getUnique(s), len = s.length();
        for (int i = 1; i <= unique; i++) {
//             Try making substring increasing number of unique chars.
            int[] count = new int[26];
            int charWithK = 0, curUnique = 0, p1 = 0, p2 = 0;
            while (p2 < len) {
                if (curUnique <= i) {
//                     Expand the slide
                    char c = s.charAt(p2++);
                    if (count[c - 'a']++ == 0) curUnique++;
                    if (count[c - 'a'] == k) charWithK++;
                } else {
//                     Shrink the slide
                    char c = s.charAt(p1++);
                    if (count[c - 'a'] == k) charWithK--;
                    if (--count[c - 'a'] == 0) curUnique--;
                }
                if (curUnique == charWithK && curUnique == i) {
                    max = Math.max(max, p2 - p1);
                }
            }
        }
        return max;
    }

    private static int getUnique(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }
}

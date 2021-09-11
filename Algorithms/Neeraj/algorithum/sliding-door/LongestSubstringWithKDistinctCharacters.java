import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Oct 05, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/YQQwQMWLx80
 */

public class LongestSubstringWithKDistinctCharacters {

    public static void main(String[] args) {

    }

    public static int findLength(String str, int k) {
        Map<Character, Integer> window = new HashMap<>();
        int max = 0, p1 = 0, len = str.length();
        for (int p2 = 0; p2 < len; p2++) {
            char cur = str.charAt(p2);
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            while (window.size() > k) {
                cur = str.charAt(p1);
                int count = window.remove(cur);
                if (count > 1) window.put(cur, count - 1);
                p1++;
            }
            max = Math.max(max, p2 - p1 + 1);
        }
        return max;
    }
}

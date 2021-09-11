/**
 * Created on:  Jun 01, 2020
 * Questions: https://leetcode.com/problems/minimum-window-substring/
 */

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC") + " should be [BANC]");
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int[] ans = {-1, 0, 0};
        Map<Character, Integer> window = new HashMap<>();
        int p1 = 0, p2 = 0, found = 0;
        while (p2 < s.length()) {
            char c = s.charAt(p2);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (map.containsKey(c) && window.get(c).equals(map.get(c))) {
                found++;
            }
//             If reached the found count that try to reduce the window.
            while (p1 <= p2 && found == map.size()) {
                c = s.charAt(p1);
//                 Check if this can be the new output.
                if (ans[0] == -1 || p2 - p1 + 1 < ans[0]) {
                    ans[0] = p2 - p1 + 1;
                    ans[1] = p1;
                    ans[2] = p2;
                }
                window.put(c, window.get(c) - 1);
                if (map.containsKey(c) && map.get(c) > window.get(c)) {
                    found--;
                }
                p1++;
            }
            p2++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}

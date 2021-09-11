import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Oct 05, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/3wDJAYG2pAR
 */

public class SmallestWindowContainingSubstring {

    public static void main(String[] args) {

    }

    public static String findSubstring(String str, String pattern) {
        Map<Character, Integer> countsMap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int len = str.length(), min[] = new int[]{-1, 0, 0}, p1 = 0, p2 = 0;
        for (char c : pattern.toCharArray()) countsMap.put(c, countsMap.getOrDefault(c, 0) + 1);
        int found = 0;
        while (p2 < len) {
            char cur = str.charAt(p2);
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            if (countsMap.containsKey(cur) && window.get(cur) == countsMap.get(cur)) found++;
            while (found == countsMap.size()) {
                int range = p2 - p1 + 1;
                if (min[0] == -1 || min[0] > range) {
                    min = new int[]{range, p1, p2};
                }
                char left = str.charAt(p1++);
                int count = window.remove(left);
                if (countsMap.containsKey(left) && countsMap.get(left) == count) found--;
                if (count > 1) window.put(left, count - 1);
            }
            p2++;
        }
        return min[0] == -1 ? "" : str.substring(min[1], min[2] + 1);
    }
}

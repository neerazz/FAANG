import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created on:  Jun 12, 2020
 * Questions: https://www.pramp.com/challenge/wqNo9joKG6IJm67B6z34
 */
public class SmallestSubstringOfAllCharacters {
    public static void main(String[] args) {
        System.out.println(getShortestUniqueSubstring(new char[]{'x', 'y', 'z'}, "xyyzyzyx") + " should be [zyx]");
        System.out.println(getShortestUniqueSubstring(new char[]{'A'}, "A") + " should be [A]");
        System.out.println(getShortestUniqueSubstring(new char[]{'A'}, "") + " should be []");
        System.out.println(getShortestUniqueSubstring(new char[]{'A'}, "B") + " should be []");
        System.out.println(getShortestUniqueSubstring(new char[]{'A', 'B', 'C'}, "ADOBECODEBANCDDD") + " should be [BANC]");
        System.out.println(getShortestUniqueSubstring(new char[]{'A', 'B', 'C'}, "ADOBECODEBANDDDC") + " should be [ADOBEC]");
    }

    private static String getShortestUniqueSubstring(char[] arr, String str) {
        Set<Character> chars = new HashSet<>();
        for (char c : arr) chars.add(c);
        Map<Character, Integer> map = new HashMap<>();
        int[] res = {-1, 0, 0};
        int found = 0;
        for (int p2 = 0, p1 = 0; p2 < str.length(); p2++) {
            char c = str.charAt(p2);
            if (chars.contains(c)) {
                int count = map.getOrDefault(c, 0);
                map.put(c, count + 1);
                if (count + 1 == 1) found++;
            }
            while (p1 <= p2 && found == arr.length) {
                if (res[0] == -1 || p2 - p1 + 1 < res[0]) {
                    res = new int[]{p2 - p1 + 1, p1, p2};
                }
                char p1Char = str.charAt(p1);
                if (chars.contains(p1Char)) {
                    int count = map.get(p1Char);
                    map.put(p1Char, count - 1);
                    if (count - 1 <= 0) found--;
                }
                p1++;
            }
        }
        return res[0] == -1 ? "" : str.substring(res[1], res[2] + 1);
    }
}

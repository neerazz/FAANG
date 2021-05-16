package weekly.weekly206;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created on:  Sep 12, 2020
 * Questions: https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations
 */
public class CheckIfStringIsTransformableWithSubstringSortOperations {
    public static void main(String[] args) {

    }

    /**
     * @implNote <p>
     * Intuition:
     * If ch[i] > ch[j], we can swap these characters. In other words, we can move a character freely to the left, until it hits a smaller character, e.g.:
     * "0231" > "0213" > "0123"
     * So, we do not need to sort anything, we just need to check if we can move required characters to the left to get the target string.
     * <p>
     * Note: we can also process the string right-to-left and move larger numbers right. In that case, we can just pop used indexes instead tracking them in a separate array pos. I though about it but it appeared a bit harder to get right during the contest. If interested, check the solution by 0xFFFFFFFF in the comments below.
     * <p>
     * Algorithm: Collect indexes of all characters 0-9 of the source strings in idx. For each characters, we track which indexes we have used in pos.
     * <p>
     * For each character ch in the target string, check if we have it in idx. If so, verify that there are no smaller characters in front of it. To do that, we check the current idexes of all characters less than ch.
     * <p>
     * If the character can be moved, mark its index as used by advancing pos[ch].
     */
    public static boolean isTransformable(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.computeIfAbsent(s.charAt(i) - '0', val -> new LinkedList<>()).add(i);
        }
        for (int i = 0; i < t.length(); i++) {
            int cur = t.charAt(i) - '0';
//            Check for the char in the map. If not present then it is not possible to transform
            if (!map.containsKey(cur) || map.get(cur).size() == 0) return false;
            int actual = map.get(cur).poll();
//            Check if you can move the char from actual idx to i.
//              To move the char there should not be any smaller char than cur in between actual to i.
            for (int j = 0; j < cur; j++) {
                if (map.containsKey(j) && !map.get(j).isEmpty() && map.get(j).peek() < actual) return false;
            }
        }
        return true;
    }
}

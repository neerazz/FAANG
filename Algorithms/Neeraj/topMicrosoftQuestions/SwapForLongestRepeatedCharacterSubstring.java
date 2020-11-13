import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 12, 2020
 * Questions: https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
 */

public class SwapForLongestRepeatedCharacterSubstring {

    public static void main(String[] args) {
        System.out.println(maxRepOpt1("babbaaabbbbbaa"));
    }

    public static int maxRepOpt1(String text) {
        int p1 = 0, p2 = 0, max = 0, len = text.length();
        Map<Character, List<int[]>> map = new HashMap<>();
        while (p2 < len) {
//             Keep extending if the chars are same.
            while (p2 < len && text.charAt(p1) == text.charAt(p2)) {
                max = Math.max(max, p2 - p1 + 1);
                p2++;
            }
            map.computeIfAbsent(text.charAt(p1), val -> new ArrayList<>()).add(new int[]{p1, p2 - 1});
            p1 = p2;
        }
        for (List<int[]> range : map.values()) {
            for (int i = 0; i < range.size(); i++) {
//                 If any of two ranges have only one char in between then then it can be replaced.
                if (i + 1 < range.size() && range.get(i)[1] + 2 == range.get(i + 1)[0]) {
                    int curVal;
                    if (range.size() > 2) {
//                         There are many ranges of current char. so the max value will be r1 + r2 +1;
                        curVal = (range.get(i)[1] - range.get(i)[0] + 1) + (range.get(i + 1)[1] - range.get(i + 1)[0] + 1) + 1;
                    } else {
                        curVal = (range.get(i)[1] - range.get(i)[0] + 1) + (range.get(i + 1)[1] - range.get(i + 1)[0] + 1);
                    }
                    max = Math.max(max, curVal);
                } else if (range.size() > 1) {
//                     We can just replace a char and increase the range value
                    max = Math.max(max, range.get(i)[1] - range.get(i)[0] + 2);
                }
            }
        }
        return max;
    }
}

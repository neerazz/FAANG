/*
    Created on:  Apr 12, 2020
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Questions:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {
    public static void main(String[] args) {

    }

    static Map<String, Integer> memo = new HashMap<>();

    public static int numDecodings(String s) {
        if (s.length() == 1) {
            if (s.charAt(0) != '0') return 1;
            return 0;
        }
        if (s.length() <= 1) return 1;
        if (s.charAt(0) == '0') return 0;
        if (memo.containsKey(s)) return memo.get(s);
        int result = 0;
        if (s.charAt(0) != '0') {
            result += numDecodings(s.substring(1));
        }
        int two = Integer.parseInt(s.substring(0, 2));
        if (two > 0 && two < 27)
            result += numDecodings(s.substring(2));
        memo.put(s, result);
        return result;
    }
}

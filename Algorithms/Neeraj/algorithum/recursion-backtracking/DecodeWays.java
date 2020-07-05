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
        System.out.println("*************************** Method 1 *******************************");
        System.out.println(numDecodings("12") + " should be [2]");
        System.out.println(numDecodings("226") + " should be [3]");
        System.out.println("*************************** Method 2 *******************************");
        System.out.println(numDecodings_rev1("12") + " should be [2]");
        System.out.println(numDecodings_rev1("226") + " should be [3]");
    }

    public static int numDecodings_rev1(String s) {
        if (s.length() == 0) return 1;
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        if (memo.containsKey(s)) return memo.get(s);
        if (s.charAt(0) == '0') {
            memo.put(s, 0);
            return 0;
        }
        int op = numDecodings_rev1(s.substring(1));
        if (Integer.parseInt(s.substring(0, 2)) < 27) {
            op += numDecodings_rev1(s.substring(2));
        }
        memo.put(s, op);
        return op;
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

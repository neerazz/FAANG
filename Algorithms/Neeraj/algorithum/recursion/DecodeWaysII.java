/*
    Created on:  Apr 12, 2020
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Questions:
 * Input: "*"
 * Output: 9
 * Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 * Input: "1*"
 * Output: 9 + 9 = 18
 */
public class DecodeWaysII {
    public static void main(String[] args) {
        System.out.println(numDecodings("*"));
        System.out.println(numDecodings("1*"));
    }

    static Map<String, Integer> memo = new HashMap<>();
    static int mod = (int) 1e9 + 7;

    public static int numDecodings(String s) {
        if (s.length() == 1) {
            char c = s.charAt(0);
            if (c == '0') return 0;
            else if (c == '*') return 9;
            return 1;
        }
        if (s.length() == 0) return 1;
        if (s.charAt(0) == '0') return 0;
        if (memo.containsKey(s)) return memo.get(s);
        char first = s.charAt(0), second = s.charAt(1);
        int result = 0;
        if (first == '*') {
            int multipler = 9;
            if (second == '0' || second == '1' || second == '*') {
                result += multipler * (second == '*' ? 9 : 1) * numDecodings(s.substring(2));
            } else if (second < '7') {
                result += multipler * numDecodings(s.substring(2));
            }
        }
        if (first == '1') {
            result += (second == '*' ? 9 : 1) * numDecodings(s.substring(2));
        } else if (first == '2') {
            if (second == '*') {
                result += 6 * numDecodings(s.substring(2));
            } else if (second < '7') {
                result += numDecodings(s.substring(2));
            }
        }
        result %= mod;
        memo.put(s, result);
        return result;
    }
}

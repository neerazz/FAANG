package weekly.weekly185;
/*
    Created on:  Apr 27, 2020
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Questions: https://leetcode.com/problems/restore-the-array/
 */
public class RestoreTheArray {
    public static void main(String[] args) {
        System.out.println(numberOfArrays("1000", 10000) + " should be [1].");
        System.out.println(numberOfArrays("1000", 10) + " should be [0].");
        System.out.println(numberOfArrays("1317", 2000) + " should be [8].");
        System.out.println(numberOfArrays("2020", 30) + " should be [1].");
        System.out.println(numberOfArrays("1234567890", 90) + " should be [34].");
    }

    static int mod = (int) 1e9 + 7;
    static Map<String, Integer> memo = new HashMap<>();

    public static int numberOfArrays(String s, int k) {
        if (s.length() == 0) return 1;
        if (s.charAt(0) == '0') return 0;
        if (memo.containsKey(s)) memo.get(s);
        int result = 0, cur = 0;
        for (int i = 0; i < s.length(); i++) {
            cur = (10 * cur) + (s.charAt(i) - '0');
            if (cur >= 1 && cur <= k) {
                result += numberOfArrays(s.substring(i + 1), k);
                result %= mod;
            }
        }
        memo.put(s, result);
        return result;
    }
}

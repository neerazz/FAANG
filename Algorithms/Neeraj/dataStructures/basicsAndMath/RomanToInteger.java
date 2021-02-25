import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 20, 2021
 * Questions: https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/586/week-3-february-15th-february-21st/3646/
 */

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }

    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        return romanToInt(chars, 0);
    }

    private static int romanToInt(char[] chars, int i) {
        if (i == chars.length) return 0;
        String str1 = "" + chars[i];
        String str2 = str1 + (i + 1 < chars.length ? chars[i + 1] : "");
        if (str2.length() == 2 && map.containsKey(str2)) {
            return map.get(str2) + romanToInt(chars, i + 2);
        }
        return map.get(str1) + romanToInt(chars, i + 1);
    }
}

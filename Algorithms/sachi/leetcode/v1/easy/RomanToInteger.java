package leetcode.v1.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("LVIII"));
    }

    public int romanToInt(String s) {

        int sol = 0;

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("V", 5);

        for (int i = s.length() - 1; i >= 0; i--) {
            Character p = null;
            char c = s.charAt(i);
            if (i > 0) p = s.charAt(i - 1);

            String s1 = (p == null) ? "" + c : "" + p + c;
            String s2 = "" + c;
            if (map.containsKey(s1)) {
                sol += map.get(s1);
                i--;
            } else if (map.containsKey(s2)) {
                sol += map.get(s2);
            }
        }
        return sol;
    }

}

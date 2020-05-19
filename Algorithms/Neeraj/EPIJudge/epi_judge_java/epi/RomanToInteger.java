package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    static Map<String, Integer> memo = new HashMap<>() {{
        put("I", 1);
        put("IV", 4);
        put("V", 5);
        put("VI", 6);
        put("IX", 9);
        put("X", 10);
        put("XI", 11);
        put("XL", 40);
        put("L", 50);
        put("LX", 60);
        put("XC", 90);
        put("C", 100);
        put("CX", 110);
        put("CD", 400);
        put("D", 500);
        put("DC", 600);
        put("CM", 900);
        put("M", 1000);
        put("MC", 1100);
    }};

    @EpiTest(testDataFile = "roman_to_integer.tsv")
    public static int romanToInteger(String s) {
        int op = 0;
        if (s == null || s.length() == 0) return op;
        char[] chars = s.toCharArray();
        int index = chars.length - 1;
        while (index >= 0) {
            if (index - 1 >= 0 && memo.containsKey("" + chars[index - 1] + chars[index])) {
                op += memo.get("" + chars[index - 1] + chars[index]);
                index -= 2;
            } else {
                op += memo.get("" + chars[index--]);
            }
        }
        return op;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "RomanToInteger.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

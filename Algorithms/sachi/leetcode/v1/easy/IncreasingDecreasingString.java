package leetcode.v1.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IncreasingDecreasingString {

    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc"));
    }

    public static String sortString(String s) {

        if (s == null || s.length() < 2) return s;
        Map<Character, Integer> cache = new HashMap<>();
        StringBuilder unique = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (cache.containsKey(c)) {
                cache.put(c, cache.get(c) + 1);
            } else {
                cache.put(c, 1);
                unique.append(c);
            }
        }

        char[] ar = unique.toString().toCharArray();
        Arrays.sort(ar);
        String sorted = String.valueOf(ar);
        StringBuilder sol = new StringBuilder();
        int i = 0;
        boolean forward = true, reversed = false;

        while (sol.length() < s.length()) {

            if (!reversed && i == sorted.length() - 1) {
                forward = false;
                reversed = true;
            } else if (!reversed && i == 0) {
                forward = true;
                reversed = true;
            }

            char c = sorted.charAt(i);
            if (cache.containsKey(c)) {
                sol.append(c);
                if (cache.get(c) == 1) {
                    cache.remove(c);
                } else {
                    cache.put(c, cache.get(c) - 1);
                }
            }

            if (!reversed) {
                i = forward ? i + 1 : i - 1;
            }
            if (reversed) {
                reversed = false;
            }
        }
        return sol.toString();

    }

}

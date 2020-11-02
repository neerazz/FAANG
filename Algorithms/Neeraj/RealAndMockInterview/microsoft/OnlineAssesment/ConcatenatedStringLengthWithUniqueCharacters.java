package OnlineAssesment;

import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 02, 2020
 * Questions: https://leetcode.com/discuss/interview-question/401826/
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */

public class ConcatenatedStringLengthWithUniqueCharacters {

    public static void main(String[] args) {

    }

    public static int maxLength(List<String> arr) {
        return getMaxLength(arr, "", 0, 0);
    }

    public static int getMaxLength(List<String> arr, String curr, int index, int max) {

        for (int i = index; i < arr.size(); i++) {
            String s = arr.get(i);
            if (!containsDup(s) && canAdd(curr, s)) {
                max = Math.max(max, getMaxLength(arr, curr + s, i + 1, curr.length() + s.length()));
            }
        }
        return max;
    }

    public static boolean containsDup(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) return true;
            set.add(ch);
        }
        return false;
    }

    public static boolean canAdd(String curr, String s) {
        return containsDup(curr + s);
    }
}

package ds.arraysAndString;

import java.util.Arrays;
import java.util.Comparator;

/*
https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1162/
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println("Answer is: " + longestCommonPrefix(new String[]{"flower", "flow", "flight"}) + " should be fl");
        System.out.println("Answer is: " + longestCommonPrefix(new String[]{"dog", "racecar", "car"}) + " should be <empty>");
        System.out.println("Answer is: " + longestCommonPrefix(new String[]{"", ""}) + " should be <empty>");
        System.out.println("Answer is: " + longestCommonPrefix(new String[]{"", "b"}) + " should be <empty>");
        System.out.println("Answer is: " + longestCommonPrefix(new String[]{"ca", "a"}) + " should be <empty>");
        System.out.println("Answer is: " + longestCommonPrefix(new String[]{"aca", "cba"}) + " should be <empty>");
    }

    public static String longestCommonPrefix_elegent(String[] strs) {
        if(strs.length < 1) {
            return "";
        }
        String max = strs[0];
        String min = strs[0];

        // find lexicographic max and min strings
        for(String s : strs) {
            if( max.compareTo(s) < 0 ) {
                max = s;
            }
            if( min.compareTo(s) > 0 ) {
                min = s;
            }
        }

        // count largest common prefix between min and max
        int i = 0;
        for( ; i < max.length() && i < min.length(); i++) {
            if( max.charAt(i) != min.charAt(i)) {
                break;
            }
        }
        return max.substring(0, i);
    }

    public static String longestCommonPrefix(String[] strs) {
        String max = "", current = "";
        int size = strs.length;
        if (size == 1) return strs[0];
        if (size > 1) {
            Arrays.sort(strs, Comparator.comparingInt(String::length));
            String first = strs[0];
            if (first.length() == 0) return max;
            for (int i = 0; i < first.length(); i++) {
                char c = first.charAt(i);
                current = max + c;
                if (checkValue(current, strs)) {
                    max = current.length() > max.length() ? current : max;
                } else {
                    return max;
                }
            }
        }
        return max;
    }

    public static boolean checkValue(String prefix, String[] strs) {
        for (int i = 1; i < strs.length; i++) {
            String currentString = strs[i];
            if (currentString.isEmpty()) return false;
            if (!currentString.startsWith(prefix)) return false;
        }
        return true;
    }
}

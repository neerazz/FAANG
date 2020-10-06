import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 05, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/YMzBx1gE5EO
 */

public class NoRepeatSubstring {

    public static void main(String[] args) {

    }

    public static int findLength(String str) {
        Set<Character> set = new HashSet<>();
        int max = 0, len = str.length(), p1 = 0;
        for (int p2 = 0; p2 < len; p2++) {
            char cur = str.charAt(p2);
            if (!set.add(cur)) {
                while (p1 <= p2 && str.charAt(p1) != cur) {
                    set.remove(str.charAt(p1++));
                }
                p1++;
            }
            max = Math.max(max, p2 - p1 + 1);
        }
        return max;
    }
}

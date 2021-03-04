import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 03, 2021
 * Questions: https://leetcode.com/problems/next-closest-time/
 */

public class NextClosestTime {

    public static void main(String[] args) {

    }

    public static String nextClosestTime(String time) {
        TreeSet<Integer> set = new TreeSet<>();
        for (char c : time.toCharArray()) if (c != ':') set.add(c - '0');
        char[] result = time.toCharArray();
        result[4] = next(time.charAt(4) - '0', 9, set);
        if (result[4] > time.charAt(4)) return new String(result);

        result[3] = next(time.charAt(3) - '0', 5, set);
        if (result[3] > time.charAt(3)) return new String(result);

        result[1] = next(time.charAt(1) - '0', result[0] == '2' ? 3 : 9, set);
        if (result[1] > time.charAt(1)) return new String(result);

        result[0] = next(time.charAt(0) - '0', 2, set);
        return new String(result);
    }

    private static char next(int cur, int max, TreeSet<Integer> set) {
        Integer next = set.higher(cur);
        if (next == null || next > max) next = set.first();
        // System.out.println("Nest of " + cur + " in list " + set + " with limit of " + max + " is = " + next);
        return (char) ('0' + next);
    }
}

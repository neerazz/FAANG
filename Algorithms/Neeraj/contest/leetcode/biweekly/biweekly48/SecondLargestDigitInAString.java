package biweekly.biweekly48;

import java.util.*;

/**
 * Created on:  Mar 20, 2021
 * Questions:
 */

public class SecondLargestDigitInAString {

    public static void main(String[] args) {
        System.out.println(secondHighest("ck077"));
    }

    public static int secondHighest(String s) {
        int len = s.length();
        TreeSet<Integer> set = new TreeSet<>((v1, v2) -> v1 - v2);
        for (int i = len - 1; i >= 0; i--) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                set.add(cur - '0');
            }
        }
        if (set.size() < 2) return -1;
        set.pollLast();
        return set.pollLast();
    }
}

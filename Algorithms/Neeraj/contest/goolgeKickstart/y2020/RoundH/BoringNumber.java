package y2020.RoundH;

import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 14, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff49/000000000043b0c6
 */

public class BoringNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        long[] result = new long[tests];
        for (int i = 0; i < tests; i++) {
            long l = sc.nextLong(), r = sc.nextLong();
            result[i] = getBoringCount_naive(l, r);
//            result[i] = getBoringCount(l, r);
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static long getBoringCount_naive(long l, long r) {
        long count = 0;
        while (l <= r) {
            if(isBoaringNumber(l++)){
                count++;
            }
        }
        return count;
    }

    private static long getBoringCount(long l, long r) {
//        Find the next boring from the left.
        long number = getGreaterBoaring(l, r);
        long count = 0;
        while (number <= r) {
            count++;
            number += 2;
        }
        return count;
    }

    private static long getGreaterBoaring(long start, long end) {
        while (start <= end) {
            if (isBoaringNumber(start)) {
                return start;
            }
            start++;
        }
        return end + 1;
    }

    private static boolean isBoaringNumber(long start) {
        String input = String.valueOf(start);
        int cur = 1;
        for (char c : input.toCharArray()) {
            if ((c - '0') % 2 != cur) return false;
            cur ^= 1;
        }
        return true;
    }
}

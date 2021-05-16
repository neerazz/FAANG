package biweekly.biweekly49;

import java.util.*;

/**
 * Created on:  Apr 03, 2021
 * Questions:
 */

public class CountNicePairsInAnArray {

    public static void main(String[] args) {

    }

    public static int countNicePairs(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        long result = 0, mod = 1_000_000_007;
        for (int num : nums) {
            int rev = rev(num), diff = num - rev;
            int occ = counts.getOrDefault(diff, 0);
            result += occ;
            result %= mod;
            counts.put(diff, occ + 1);
        }
        return (int) result;
    }

    private static int rev(int num) {
        int rev = 0;
        while (num > 0) {
            int rem = num % 10;
            num /= 10;
            rev = rev * 10 + rem;
        }
        return rev;
    }
}

package weekly.weekly247;

import java.util.Arrays;

/**
 * Created on:  Jun 26, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-247/problems/number-of-wonderful-substrings/
 */

public class NumberOfWonderfulSubstrings {

    public static void main(String[] args) {

    }

    public static long wonderfulSubstrings(String word) {
        long count = 0;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            count++;
            int[] counts = new int[10];
            counts[word.charAt(i) - 'a']++;
            for (int j = i + 1; j < len; j++) {
                counts[word.charAt(j) - 'a']++;
                if (isWonderful(counts)) count++;
            }
        }
        return count;
    }

    private static boolean isWonderful(int[] counts) {
        return Arrays.stream(counts).filter(val -> val == 1).count() <= 1;
    }
}

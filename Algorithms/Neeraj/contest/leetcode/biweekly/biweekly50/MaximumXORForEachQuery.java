package biweekly.biweekly50;

import java.util.*;

/**
 * Created on:  Apr 17, 2021
 * Questions: https://leetcode.com/contest/biweekly-contest-50/problems/maximum-xor-for-each-query/
 */

public class MaximumXORForEachQuery {

    public static void main(String[] args) {
        System.out.println("****************************** Solution 1 ****************************");
        System.out.println(Arrays.toString(getMaximumXor(new int[]{0, 1, 1, 3}, 2)));
        System.out.println(Arrays.toString(getMaximumXor(new int[]{2, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(getMaximumXor(new int[]{0, 1, 2, 2, 5, 7}, 3)));

        System.out.println("****************************** Solution 2 ****************************");
        System.out.println(Arrays.toString(getMaximumXor_optimal(new int[]{0, 1, 1, 3}, 2)));
        System.out.println(Arrays.toString(getMaximumXor_optimal(new int[]{2, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(getMaximumXor_optimal(new int[]{0, 1, 2, 2, 5, 7}, 3)));

        System.out.println("****************************** Solution 3 ****************************");
        System.out.println(Arrays.toString(getMaximumXor_optimal2(new int[]{0, 1, 1, 3}, 2)));
        System.out.println(Arrays.toString(getMaximumXor_optimal2(new int[]{2, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(getMaximumXor_optimal2(new int[]{0, 1, 2, 2, 5, 7}, 3)));
    }

    public static int[] getMaximumXor_optimal(int[] nums, int maximumBit) {
        int soFar = 0, len = nums.length;
        int[] xors = new int[len];
        for (int i = 0; i < len; i++) {
            xors[i] = soFar ^= nums[i];
        }
        int max = (int) Math.pow(2, maximumBit) - 1;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int xor = xors[len - i - 1];
            int curBest = xor ^ max;
            result[i] = curBest;
        }
        return result;
    }

    public static int[] getMaximumXor_optimal2(int[] nums, int maximumBit) {
        int soFar = 0, len = nums.length;
        int[] xors = new int[len];
        for (int i = 0; i < len; i++) {
            xors[i] = soFar ^= nums[i];
        }
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int xor = xors[len - i - 1];
            int best = getBest(xor, maximumBit);
            result[i] = best;
        }
        return result;
    }

    private static int getBest(int value, int maximumBit) {
        char[] kBits = new char[maximumBit];
        Arrays.fill(kBits, '1');
        int i = maximumBit;
//        Set the kth bit as 0 or 1, such that. The resulting value is all 1 bits.
        while (value > 0 && i > 0) {
            int curBit = value % 2;
            value >>= 1;
            kBits[--i] = curBit == 1 ? '0' : '1';
        }
        int k = 0;
        for(char cur: kBits){
            k <<= 1;
            k += cur - '0';
        }
        return k;
    }

    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int soFar = 0, len = nums.length;
        int[] xors = new int[len];
        for (int i = 0; i < len; i++) {
            xors[i] = soFar ^= nums[i];
        }
        int start = 0, end = (int) Math.pow(2, maximumBit);
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int xor = xors[len - i - 1];
            int best = getBest(xor, start, end);
            result[i] = best;
        }
        return result;
    }

    private static int getBest(int value, int start, int end) {
        int best = 0, max = 0;
        for (int i = start; i < end; i++) {
            int xor = value ^ i;
            if (xor > max) {
                best = i;
                max = xor;
            }
        }
        return best;
    }
}

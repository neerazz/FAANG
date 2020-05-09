/*
    Created on:  May 07, 2020
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * Questions: https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/can-you-solve-it/
 */
public class CanYouSolveIt {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int tests = fr.nextInt();
        for (int i = 0; i < tests; i++) {
            int n = fr.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = fr.nextInt();
            }
            System.out.println(solve(nums));
        }
    }

    private static int solve(int[] nums) {
        int len = nums.length;
        int[] plus = new int[len], minus = new int[len];
//        There are total four possibilities if we remove the mode factor.
        for (int i = 0; i < len; i++) {
            plus[i] = nums[i] + i;
            minus[i] = nums[i] - i;
        }
//        Find the maximum difference in both the plus and minus array.
        int plusMax = Integer.MIN_VALUE, plusMin = Integer.MAX_VALUE, minusMax = Integer.MIN_VALUE, minusMin = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            plusMax = Math.max(plusMax, plus[i]);
            plusMin = Math.min(plusMin, plus[i]);
            minusMax = Math.max(minusMax, minus[i]);
            minusMin = Math.min(minusMin, minus[i]);
        }
        return Math.max(plusMax - plusMin, minusMax - minusMin);
    }
}

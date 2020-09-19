package y2020.RoundE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on:  Aug 22, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff47/00000000003bf4ed
 */
public class LongestArithmetic {
    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = fr.nextInt();
        int[] result = new int[tests];
        for (int i = 0; i < tests; i++) {
            int n = fr.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = fr.nextInt();
            }
            result[i] = getLongestContinuesSubArray(n, nums);
        }

        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static int getLongestContinuesSubArray(int len, int[] nums) {
        int max = 0;
//        Get the difference between the next number.
        for (int i = 0; i < len - 1; i++) {
            nums[i] = nums[i + 1] - nums[i];
        }
        int[] pre = {Integer.MAX_VALUE, -1};
//        Keep a track of previous number, that way you can calculate the length.
        System.out.println("nums = " + Arrays.toString(nums));
        for (int i = 0; i < len - 1; i++) {
            if (pre[0] != nums[i]) pre = new int[]{nums[i], i};
            max = Math.max(max, i - pre[1] + 2);
        }
        return max;
    }
}

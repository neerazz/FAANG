package y2020.RoundB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created on:  Aug 11, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc8/00000000002d82e6
 * Problem
 * Li has planned a bike tour through the mountains of Switzerland. His tour consists of N checkpoints, numbered from 1 to N in the order he will visit them. The i-th checkpoint has a height of Hi.
 * <p>
 * A checkpoint is a peak if:
 * It is not the 1st checkpoint or the N-th checkpoint, and
 * The height of the checkpoint is strictly greater than the checkpoint immediately before it and the checkpoint immediately after it.
 * <p>
 * Please help Li find out the number of peaks.
 * <p>
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a line containing the integer N. The second line contains N integers. The i-th integer is Hi.
 * <p>
 * Output
 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the number of peaks in Li's bike tour.
 * <p>
 * Limits
 * Time limit: 10 seconds per test set.
 * Memory limit: 1GB.
 * 1 ≤ T ≤ 100.
 * 1 ≤ Hi ≤ 100.
 * <p>
 * Test set 1
 * 3 ≤ N ≤ 5.
 * <p>
 * Test set 2
 * 3 ≤ N ≤ 100.
 * <p>
 * Sample
 * <p>
 * Input
 * <p>
 * Output
 * <p>
 * 4
 * 3
 * 10 20 14
 * 4
 * 7 7 7 7
 * 5
 * 10 90 20 90 10
 * 3
 * 10 3 10
 */
public class BikeTour {
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
            result[i] = getPeaks(n, nums);
        }

        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static int getPeaks(int len, int[] nums) {
        boolean[] left = new boolean[len];
        for (int i = 1; i < len - 1; i++) {
            left[i] = nums[i] > nums[i - 1];
        }
        int count = 0;
        for (int i = len - 2; i > 0; i--) {
            if (nums[i] > nums[i + 1] && left[i]) count++;
        }
        return count;
    }
}

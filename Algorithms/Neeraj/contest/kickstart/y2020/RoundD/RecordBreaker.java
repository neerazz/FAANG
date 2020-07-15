package y2020.RoundD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created on:  Jul 12, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff08/0000000000387171
 */
public class RecordBreaker {
    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = fr.nextInt();
        int[] result = new int[tests];
        for (int i = 0; i < tests; i++) {
            int n = fr.nextInt();
            int[] vals = new int[n];
            for (int j = 0; j < n; j++) {
                vals[j] = fr.nextInt();
            }
            result[i] = getRecordCount(vals, n);
        }

        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static int getRecordCount(int[] nums, int n) {
        int count = 0, max = 0;
        for (int i = 0; i < n; i++) {
            boolean cond1 = i == 0 || nums[i] > max;
            boolean cond2 = i == n - 1 || nums[i] > nums[i + 1];
            max = Math.max(nums[i], max);
            if (cond1 && cond2) count++;
        }
        return count;
    }
}

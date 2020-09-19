package y2020.RoundC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created on:  Sep 16, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff43/00000000003380d2
 */
public class Countdown {
    public static void main(String[] args) {
        Scanner fr = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = fr.nextInt();
        int[] result = new int[tests];
        for (int i = 0; i < tests; i++) {
            int n = fr.nextInt(), k = fr.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = fr.nextInt();
            }
            result[i] = getCountDown(n, k, nums);
        }

        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static int getCountDown(int n, int k, int[] nums) {
        int p1 = 0, found = 0;
        for (int p2 = 1; p2 < n; p2++) {
            if (nums[p2 - 1] != nums[p2] + 1) {
                p1 = p2;
            }
            if (nums[p2] == 1 && p2 - p1 + 1 >= k) {
                p1 = p2;
                found++;
            }
        }
        return found;
    }
}

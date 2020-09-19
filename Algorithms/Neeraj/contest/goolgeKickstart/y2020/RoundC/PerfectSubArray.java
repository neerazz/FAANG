package y2020.RoundC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created on:  Sep 16, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff43/00000000003381cb
 */
public class PerfectSubArray {
    static Map<Long, Boolean> squares = new HashMap<>();

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
            result[i] = getPerfectSquareSubArray(n, nums);
        }

        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static int getPerfectSquareSubArray(int n, int[] nums) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            long cur = nums[i];
            if (isPerfectSquare(cur)) {
//                System.out.println("cur = " + cur);
                count++;
            }
            for (int j = i + 1; j < n; j++) {
                if (isPerfectSquare(cur += nums[j])) {
                    count++;
//                    System.out.println("cur = " + cur);
                }
            }
        }
        return count;
    }

    private static boolean isPerfectSquare(long num) {
        if (squares.containsKey(num)) return squares.get(num);
        int sqrt = (int) Math.sqrt(num);
        boolean isPerfect = sqrt * sqrt == num;
        squares.put(num, isPerfect);
        return isPerfect;
    }
}

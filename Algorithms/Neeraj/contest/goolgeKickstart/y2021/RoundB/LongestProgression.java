package y2021.RoundB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on:  May 16, 2021
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435a5b/000000000077a3a5
 */

public class LongestProgression {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        int[] result = new int[tests];
        for (int i = 0; i < tests; i++) {
            int len = sc.nextInt();
            int[] nums = new int[len];
            for (int j = 0; j < len; j++) {
                nums[j] = sc.nextInt();
            }
            result[i] = getLongestProgressing(nums, len);
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static int getLongestProgressing(int[] nums, int len) {
        int max = 0;
        for (int i = 0; i < len; i++) {
            int value = getLongestInRight(Arrays.copyOf(nums, len), i, len, 1);
            max = Math.max(max, value);
            value = getLongestInLeft(Arrays.copyOf(nums, len), i, len, 1);
            max = Math.max(max, value);
        }
        return max;
    }

    private static int getLongestInLeft(int[] nums, int start, int len, int ignore) {
        if (start <= 1) return start + 1;
        int diff = nums[start] - nums[start - 1];
        int end = start;
        while (end > 0 && (nums[end] - nums[end - 1] == diff || ignore > 0)) {
            if (nums[end] - nums[end - 1] != diff) {
                ignore--;
                nums[end - 1] = nums[end] - diff;
            }
            end--;
        }
        return start - end + 1;
    }

    private static int getLongestInRight(int[] nums, int start, int len, int ignore) {
        if (start >= len - 2) return len - start;
        int diff = nums[start + 1] - nums[start];
        int end = start;
        while (end + 1 < len && (nums[end + 1] - nums[end] == diff || ignore > 0)) {
            if (nums[end + 1] - nums[end] != diff) {
                ignore--;
                nums[end + 1] = nums[end] + diff;
            }
            end++;
        }
        return end - start + 1;
    }
}

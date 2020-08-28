package y2020.RoundE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        for (int i = 0; i < len - 1; i++) {
            int count = 0, dif = nums[i + 1] - nums[i];
            for (int j = i + 1; j < len - 1; j++) {
                if (nums[j + 1] - nums[j] == dif) {
                    max = Math.max(max, j - i + 2);
                } else break;
            }
        }
        return max;
    }

    private static int getLongestContinuesSubArray_wrong(int len, int[] nums) {
        int max = 0;
        for (int i = 1; i < len - 1; i++) {
            int expanded = expand(nums, i);
            max = Math.max(max, expanded);
        }
        return max;
    }

    private static int expand(int[] nums, int mid) {
        int left = nums[mid] - nums[mid - 1], right = nums[mid + 1] - nums[mid];
        if (left != right) return 0;
//        Move towards the left till teh difference is same.
        int l = mid, r = mid;
        while (l > 0 && nums[l] - nums[l - 1] == left) {
            l--;
        }
        while (r < nums.length - 1 && nums[r + 1] - nums[r] == right) {
            r++;
        }
        return r - l + 1;
    }
}

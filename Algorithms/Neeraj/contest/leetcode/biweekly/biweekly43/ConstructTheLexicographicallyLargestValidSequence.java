package biweekly.biweekly43;

import java.util.*;

/**
 * Created on:  Jan 09, 2021
 * Questions:
 */

public class ConstructTheLexicographicallyLargestValidSequence {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(constructDistancedSequence(3)));
        System.out.println(Arrays.toString(constructDistancedSequence(5)));
        System.out.println(Arrays.toString(constructDistancedSequence(13)));
    }

    static int[] ans;

    public static int[] constructDistancedSequence(int n) {
        int len = n * 2 - 1, inital[] = new int[len];
        ans = new int[len];
        boolean[] taken = new boolean[n + 1];
        helper(inital, 0, n, taken);
        return ans;
    }

    private static boolean helper(int[] nums, int i, int n, boolean[] taken) {
        if (i == nums.length) {
            if (Arrays.compare(ans, nums) < 0) {
                ans = Arrays.copyOf(nums, nums.length);
            }
            return true;
        } else if (nums[i] != 0) {
            return helper(nums, i + 1, n, taken);
        } else {
            for (int j = n; j > 0; j--) {
//                Loop from n to i and try to place the number at the current index.
                if (j == 1) {
                    if (taken[j] || nums[i] != 0) continue;
                    taken[j] = true;
                    nums[i] = j;
                    if (helper(nums, i + 1, n, taken)) return true;
                    nums[i] = 0;
                    taken[j] = false;
                } else {
                    if (taken[j] || nums[i] != 0) continue;
                    if (i + j >= nums.length || nums[i + j] != 0) continue;
                    nums[i] = nums[i + j] = j;
                    taken[j] = true;
                    if (helper(nums, i + 1, n, taken)) return true;
                    nums[i] = nums[i + j] = 0;
                    taken[j] = false;
                }
            }
            return false;
        }
    }
}

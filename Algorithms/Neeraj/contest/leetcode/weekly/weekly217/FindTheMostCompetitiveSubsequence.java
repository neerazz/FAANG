package weekly.weekly217;

import java.util.*;

/**
 * Created on:  Nov 28, 2020
 * Questions:
 */

public class FindTheMostCompetitiveSubsequence {

    static int[] result;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mostCompetitive(new int[]{3, 5, 2, 6}, 2)));
        System.out.println(Arrays.toString(mostCompetitive(new int[]{70, 3, 34, 32, 18, 67, 51, 79, 44, 69, 16, 0, 20, 89, 43, 4, 13, 22, 62, 54, 61, 64, 18, 53, 98, 84, 48, 17, 73}, 26)));

        System.out.println(Arrays.toString(mostCompetitive_sol1(new int[]{3, 5, 2, 6}, 2)));
        System.out.println(Arrays.toString(mostCompetitive_sol1(new int[]{70, 3, 34, 32, 18, 67, 51, 79, 44, 69, 16, 0, 20, 89, 43, 4, 13, 22, 62, 54, 61, 64, 18, 53, 98, 84, 48, 17, 73}, 26)));

        System.out.println(Arrays.toString(mostCompetitive_optimal(new int[]{3, 5, 2, 6}, 2)));
        System.out.println(Arrays.toString(mostCompetitive_optimal(new int[]{70, 3, 34, 32, 18, 67, 51, 79, 44, 69, 16, 0, 20, 89, 43, 4, 13, 22, 62, 54, 61, 64, 18, 53, 98, 84, 48, 17, 73}, 26)));
    }

    public static int[] mostCompetitive_optimal(int[] nums, int k) {
        int[] result = new int[k];
        int j = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            while (j > 0 && result[j - 1] > nums[i] && i <= len - k + j - 1) {
//                Remove an element from result when there is one && the last element is greater then current and there are enough number of elements remaining.
                j--;
            }
            if (j < k) result[j++] = nums[i];
        }
        return result;
    }

    public static int[] mostCompetitive_sol1(int[] nums, int k) {
        int[] result = new int[k];
        int len = nums.length, start = 0;
        for (int i = 0; i < k; i++) {
            int[] cur = getSmallest(nums, start, len - k + i);
            result[i] = cur[0];
            start = cur[1] + 1;
        }
        return result;
    }

    private static int[] getSmallest(int[] nums, int start, int end) {
        int minVal = Integer.MAX_VALUE, minIdx = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] < minVal) {
                minVal = nums[i];
                minIdx = i;
            }
        }
        return new int[]{minVal, minIdx};
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        result = new int[k];
        Arrays.fill(result, Integer.MAX_VALUE);
        helper(nums, 0, 0, k, new int[k]);
        return result;
    }

    private static void helper(int[] nums, int idx, int curK, int k, int[] curRes) {
        if (curK == k) {
//            Then compare both the arrays and take the lowest one.
            int[] copy = Arrays.copyOf(curRes, k);
            if (isCompetitive(result, copy)) {
                result = copy;
            }
            return;
        }
        if (idx > nums.length || curK > k) return;
        for (int i = idx; i < nums.length; i++) {
            curRes[curK] = nums[i];
            helper(nums, i + 1, curK + 1, k, curRes);
        }
    }

    private static boolean isCompetitive(int[] result, int[] cur) {
        for (int i = 0; i < result.length; i++) {
            if (result[i] == cur[i]) continue;
//            If the first different number of the result is less then it is not competitive
            if (result[i] < cur[i]) return false;
            else return true;
        }
        return false;
    }
}

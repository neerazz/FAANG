package weekly.weekly218;

import java.util.*;

/**
 * Created on:  Dec 05, 2020
 * Questions:
 */

public class MinimumIncompatibility {

    static int minVal;

    public static void main(String[] args) {
//        System.out.println(minimumIncompatibility(new int[]{6, 3, 8, 1, 3, 1, 2, 2}, 4));
//        System.out.println(minimumIncompatibility(new int[]{1,2,1,4}, 2));
//        System.out.println(minimumIncompatibility(new int[]{7,3,3,9,4,4,9,9,3,8,5}, 11));
        System.out.println(minimumIncompatibility(new int[]{2, 9, 4, 7, 6, 8, 2, 1, 10, 1, 5, 4}, 2));
    }

    public static int minimumIncompatibility(int[] nums, int k) {
        minVal = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int maxOcc = 0, setSize = nums.length / k;
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
            maxOcc = Math.max(maxOcc, count + 1);
        }
        if (maxOcc > k) return -1;
        if (setSize == 1) return 0;
        Set[] sets = new HashSet[k];
        for (int i = 0; i < k; i++) {
            sets[i] = new HashSet<Integer>();
        }
        boolean[] taken = new boolean[nums.length];
        helper(nums, taken, 0, 0, setSize, k, sets, 0, null, null);
        return minVal == Integer.MAX_VALUE ? -1 : minVal;
    }

    private static void helper(int[] nums, boolean[] taken, int col, int row, int cols, int rows, Set[] sets, int sum, Integer min, Integer max) {
        if (col == cols) {
//            Calculate the val of pre row
            sum += max - min;
            min = max = null;
            col = 0;
            row++;
        }
        if (row == rows) {
            minVal = Math.min(minVal, sum);
            System.out.println("sets = " + Arrays.toString(sets) + " minVal = " + minVal);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (taken[i]) continue;
            if (sets[row].contains(nums[i])) continue;
            sets[row].add(nums[i]);
            taken[i] = true;
            if (min == null && max == null) {
                helper(nums, taken, col + 1, row, cols, rows, sets, sum, nums[i], nums[i]);
            } else {
                helper(nums, taken, col + 1, row, cols, rows, sets, sum, Math.min(min, nums[i]), Math.max(nums[i], max));
            }
            taken[i] = false;
            sets[row].remove(nums[i]);
        }
    }

}

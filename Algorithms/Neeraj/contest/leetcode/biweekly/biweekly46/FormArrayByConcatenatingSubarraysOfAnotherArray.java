package biweekly.biweekly46;

import java.util.*;

/**
 * Created on:  Feb 20, 2021
 * Questions:
 */

public class FormArrayByConcatenatingSubarraysOfAnotherArray {

    public static void main(String[] args) {
//        System.out.println(canChoose_rev2(new int[][]{{1, 2, 3}, {3, 4}}, new int[]{7, 7, 1, 2, 3, 4, 7, 7}));
        System.out.println(canChoose_rev2(
                new int[][]{{6636698, 4693069, -2178984, -2253405, -2732131, 8550889, -2324014, -2561263}, {-8973571, -9146179, 7704305, -1063430, -6569826}, {2791091}, {-9691134, 651171, 9835817, 4163881, 4944714, 8166788, -9025553, -9250995, 1599781}},
                new int[]{8550889, -2178984, 6636698, 4693069, -2178984, -2253405, -2732131, 8550889, -2324014, -2561263, -2324014, 8550889, -8973571, -9146179, 7704305, -1063430, -6569826, 2791091, -9691134, 651171, 9835817, 4163881, 4944714, 8166788, -9025553, -9250995, 1599781}));
    }

    public static boolean canChoose_rev2(int[][] groups, int[] nums) {
        int glen = groups.length, len = nums.length, gr = 0, i = 0;
        while (i < len && gr < glen) {
            if (nums[i] == groups[gr][0]) {
//                First number is matching.
                int gc = 0;
                int j = i;
                while (gc < groups[gr].length && j < len && groups[gr][gc] == nums[j]) {
                    gc++;
                    j++;
                }
//                if all the elements in the row is covered, then increase the group row.
                if (gc == groups[gr].length) {
//                    increase the group index, and i as well.
                    gr++;
                    i = j - 1;
                }
            }
            i++;
        }
        return gr == glen;
    }

    public static boolean canChoose(int[][] groups, int[] nums) {
        long n = groups.length, len = nums.length, total = n * n;
        for (int i = 0; i < len && i - total >= 0; i++) {
            if (nums[i] == groups[0][0] && isPresent(groups, nums, i, n)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPresent(int[][] groups, int[] nums, int start, long n) {
//                Start looking for the rows
        for (int row = 0; row < n; row++) {
            int nextStart = isPresent(groups[row], nums, row, start, n);
            if (nextStart == -1) return false;
            start = nextStart;
        }
        return false;
    }

    private static int isPresent(int[] group, int[] nums, int row, int start, long n) {
//                Start looking for the numbers
        long remain = (n - row) * n;
        for (int i = start; i < nums.length - remain; i++) {
            if (Arrays.equals(group, Arrays.copyOfRange(nums, i, (int) (i + n)))) return (int) (i + n);
        }
        return -1;
    }
}

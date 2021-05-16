package weekly.weekly212;

import java.util.*;

/**
 * Created on:  Oct 24, 2020
 * Questions:
 */

public class ArithmeticSubarrays {

    public static void main(String[] args) {
        System.out.println(checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}));
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            result.add(isAsthmaticSubArray(Arrays.copyOfRange(nums, l[i], r[i] + 1)));
        }
        return result;
    }

    private static boolean isAsthmaticSubArray(int[] nums) {
        Arrays.sort(nums);
        int diff = nums[1] - nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] != diff) return false;
        }
        return true;
    }
}

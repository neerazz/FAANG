package biweekly.biweekly40;

/**
 * Created on:  Nov 28, 2020
 * Questions:
 */

public class MinimumNumberOfRemovalsToMakeMountainArray {

    public static void main(String[] args) {
//        System.out.println(minimumMountainRemovals(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
//        System.out.println(minimumMountainRemovals(new int[]{1, 16, 84, 9, 29, 71, 86, 79, 72, 12}));
//        System.out.println(minimumMountainRemovals(new int[]{4, 3, 2, 1, 1, 2, 3, 1}));

        System.out.println(minimumMountainRemovals_optimal(new int[]{1, 3, 1}));
        System.out.println(minimumMountainRemovals_optimal(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(minimumMountainRemovals_optimal(new int[]{1, 16, 84, 9, 29, 71, 86, 79, 72, 12}));
        System.out.println(minimumMountainRemovals_optimal(new int[]{4, 3, 2, 1, 1, 2, 3, 1}));
    }

    public static int minimumMountainRemovals_optimal(int[] nums) {
        int len = nums.length;
        int[] left = new int[len], right = new int[len];
//        Get number of elements less then current on the left side.
        for (int i = 0; i < len; i++) {
            left[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }
//        Get number of elements less then current on the left side.
        for (int i = len - 1; i >= 0; i--) {
            right[i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[i]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (left[i] >= 2 && right[i] >= 2) {
//                If there is atlest one element in the left less than current and one element in the right less than cur. then that forms a peek
//                System.out.println("Left = " + left[i] + " num = " + nums[i] + " right =" + right[i]);
                max = Math.max(max, left[i] + right[i] - 1);
            }
        }
        return max >= 3 ? len - max : len;
    }

    public static int minimumMountainRemovals(int[] nums) {
        int len = nums.length, max = 0;
        for (int i = 0; i < len; i++) {
            int left = getIncreasing(nums, 0, i - 1, nums[i]), right = getDecreasing(nums, i + 1, len - 1, nums[i]);
            System.out.println("Left = " + left + " num = " + nums[i] + " right =" + right);
            if (left > 0 && right > 0) {
                max = Math.max(max, left + right + 1);
            }
        }
        return max >= 3 ? len - max : len;
    }

    /*      i
     *       4, 3, 2, 1, 1, 2, 3, 1
     *
     * */
    private static int getIncreasing(int[] nums, int start, int end, int max) {
        int result = 0;
        int[] dp = new int[nums.length];
        for (int i = start; i <= end; i++) {
            if (nums[i] >= max) continue;
            dp[i] = 1;
            for (int j = start; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    private static int getDecreasing(int[] nums, int start, int end, int max) {
        int result = 0;
        int[] dp = new int[nums.length];
        for (int i = start; i <= end; i++) {
            if (nums[i] >= max) continue;
            dp[i] = 1;
            for (int j = start; j < i; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}

package weekly.weekly204;

/**
 * Created on:  Aug 29, 2020
 * Questions: https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
 */
public class MaximumLengthOfSubarrayWithPositiveProduct {
    public static void main(String[] args) {
        System.out.println(getMaxLen(new int[]{1, -2, -3, 4}) + " = 4");
        System.out.println(getMaxLen(new int[]{1, -2}) + " = 1");
        System.out.println(getMaxLen(new int[]{-1, 2}) + " = 1");
        System.out.println(getMaxLen(new int[]{0, -1, -2, -4}) + " = 2");
        System.out.println(getMaxLen(new int[]{0, 1, -2, -3, -4}) + " = 3");
        System.out.println(getMaxLen(new int[]{1, -6, 4, 0, 10, 2, 3, 5}) + " = 4");
        System.out.println(getMaxLen(new int[]{1, 2, 3, 5, -6, 4, 0, 10}) + " = 4");
        System.out.println(getMaxLen(new int[]{5, -20, -20, -39, -5, 0, 0, 0, 36, -32, 0, -7, -10, -7, 21, 20, -12, -34, 26, 2}) + " = 8");
        System.out.println(getMaxLen(new int[]{70, -18, 75, -72, -69, -84, 64, -65, 0, -82, 62, 54, -63, -85, 53, -60, -59, 29, 32, 59, -54, -29, -45, 0, -10, 22, 42, -37, -16, 0, -7, -76, -34, 37, -10, 2, -59, -24, 85, 45, -81, 56, 86}) + " = 14");
    }

    public static int getMaxLen(int[] nums) {
        Integer[] idx = {-1, null};
        Integer max = 0;
        Integer negatives = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (negatives % 2 == 0) {
//                    If even number of negatives are present. All the vales from start, or the index with zero value till now can be a valid su-array.
                    max = Math.max(max, i - idx[0]);
                } else {
//                    Considering numbers except first negative (means removing one negative, that will either be an even negatives or zero negatives).
//                      Note: this also covers the case of odd negatives.
                    max = Math.max(max, i - idx[1]);
                }
            } else if (nums[i] == 0) {
                idx[0] = i;
                idx[1] = null;
                negatives = 0;
            } else {
                negatives++;
//                Set the negative integer index in case of null.
                if (idx[1] == null) idx[1] = i;
//                And check by including this number can the sub-array size be increased.
                if (negatives % 2 == 0) max = Math.max(max, i - idx[0]);
                else max = Math.max(max, i - idx[1]);
            }
        }
        return max;
    }
}

package weekly.weekly191;

/**
 * Created on:  May 30, 2020
 * Questions: https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array
 */
public class MaximumProductOfTwoElementsInAnArray {
    public static void main(String[] args) {

    }

    public static int maxProduct_Optimal(int[] nums) {
        int max = Integer.MIN_VALUE, neg1 = Integer.MAX_VALUE, neg2 = Integer.MAX_VALUE, pos1 = Integer.MIN_VALUE, pos2 = Integer.MIN_VALUE;
        for (int num : nums) {
            int cur = num - 1;
            if (cur < 0) {
                if (cur < neg1) {
                    neg2 = neg1;
                    neg1 = cur;
                } else if (cur < neg2) {
                    neg2 = cur;
                }
            } else if (cur > 0) {
                if (cur > pos1) {
                    pos2 = pos1;
                    pos1 = cur;
                } else if (cur > pos2) {
                    pos2 = cur;
                }
            } else {
                max = 0;
            }
        }
        if (neg1 != Integer.MAX_VALUE && neg2 != Integer.MAX_VALUE) max = Math.max(neg1 * neg2, max);
        if (pos1 != Integer.MIN_VALUE && pos2 != Integer.MIN_VALUE) max = Math.max(pos1 * pos2, max);
        return max;
    }

    public static int maxProduct(int[] nums) {
        int len = nums.length, op = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                op = Math.max(op, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        return op;
    }
}

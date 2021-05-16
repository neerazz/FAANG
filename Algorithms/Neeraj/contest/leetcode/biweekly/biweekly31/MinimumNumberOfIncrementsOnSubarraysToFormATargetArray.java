package biweekly.biweekly31;

/**
 * Created on:  Jul 25, 2020
 * Questions: https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array
 */
public class MinimumNumberOfIncrementsOnSubarraysToFormATargetArray {
    public static void main(String[] args) {
        System.out.println(minNumberOperations_optimal(new int[]{1, 2, 3, 2, 1}) + " = " + minNumberOperations(new int[]{1, 2, 3, 2, 1}));
    }

    public static int minNumberOperations_optimal(int[] target) {
//        Observe the growing pattern. For every growth there will be a cost.
        int res = 0, pre = 0;
        for (int cur : target) {
            res += Math.max(cur - pre, 0);
            pre = cur;
        }
        return res;
    }

    public static int minNumberOperations(int[] target) {
        int totalMax = 0, len = target.length, curMax = 0, start = 0, i = 0, op = 0;
        int[] temp = new int[len];
        for (int num : target) {
            totalMax = Math.max(totalMax, num);
        }
        while (true) {
            i = start;
            while (i < len && target[i] > temp[i]) {
                curMax = Math.max(++temp[i++], curMax);
            }
            if (i != start) op++;
            if (i == len - 1 && curMax == totalMax) break;
            if (i + 1 < len) {
                start = i + 1;
            } else {
                start = 0;
            }
        }
        return op;
    }
}

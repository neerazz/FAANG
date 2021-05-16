package weekly.weekly220;

import java.util.*;

/**
 * Created on:  Dec 19, 2020
 * Questions:
 */

public class MaximumErasureValue {

    public static void main(String[] args) {

    }

    public static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> window = new HashSet<>();
        int max = 0, p1 = 0, curSum = 0;
        for (int p2 = 0; p2 < nums.length; p2++) {
            while (window.contains(nums[p2])) {
                curSum -= nums[p1];
                window.remove(nums[p1++]);
            }
            curSum += nums[p2];
            max = Math.max(max, curSum);
            window.add(nums[p2]);
        }
        return max;
    }
}

package grokking.twopointer;

import java.util.*;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 * <p>
 * Example 1:
 * <p>
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 * Example 2:
 * <p>
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 * Explanation: There are two unique triplets whose sum is equal to zero.
 */
public class TripletSumToZero {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    /**
     * Sort Arrays, Use two pointers
     * Use Set<List> for uniqueness
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> sol = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            int start = i + 1, end = nums.length - 1;
            while (end < nums.length && start < end) {
                int sum = nums[start] + nums[end];
                if (sum + target == 0) {
                    sol.add(Arrays.asList(target, nums[start], nums[end]));
                    start++;
                    end--;
                } else if (sum + target > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return new ArrayList<>(sol);
    }
}

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Oct 31, 2020
 * Questions: https://leetcode.com/discuss/interview-question/406031/
 */

public class LargestKSuchThatBothKAndKExistInArray {

    public static void main(String[] args) {
        System.out.println(largestK(new int[]{3, 2, -2, 5, -3}));
        System.out.println(largestK(new int[]{1, 2, 3, -4}));
    }

    private static int largestK_optimal(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            if (set.contains(-1 * num)) {
                max = Math.max(max, Math.abs(num));
            }
            set.add(num);
        }
        return max;
    }

    private static int largestK(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] > 0 || nums[end] < 0) break;
            int abs = Math.abs(nums[start]);
            if (abs == nums[end]) return abs;
            if (abs < nums[end]) {
                end--;
            } else {
                start++;
            }
        }
        return 0;
    }
}

import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Sep 30, 2020
 * Questions:https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive_optimal(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive_optimal(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(firstMissingPositive_optimal(new int[]{7, 8, 9, 11, 12}));
    }

    public static int firstMissingPositive_optimal(int[] nums) {
        int len = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len) nums[i] = len + 1;
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min > 1) return 1;
//        Now the array will have only number between 1 to n+1
        for (int i = 0; i < len; i++) {
            int cur = Math.abs(nums[i]);
            if (cur > len) continue;
//            Convert the number at the cur index to negative. Convert only if the number is positive.
            if (nums[cur - 1] > 0) {
                nums[cur - 1] *= -1;
            }
        }
//        Now loop through the array and find the first index that doesn't have a negative value
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return max + 1;
    }

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num <= 0) continue;
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }
        if (min > 1) return 1;
        // if(max-min+1 <= count) return max+1;
        for (int i = min; i <= max; i++) {
            if (set.contains(i)) continue;
            return i;
        }
        return max + 1;
    }
}

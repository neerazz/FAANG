import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Aug 18, 2020
 * Questions: https://www.algoexpert.io/questions/Three%20Number%20Sum
 */
public class ThreeNumberSum {
    static List<Integer[]> op;

    public static void main(String[] args) {
        threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        op = new ArrayList<>();
        Arrays.sort(array);
        getNSum(array, 0, targetSum, 3, 0, new Integer[3]);
        return op;
    }

    private static void getNSum(int[] nums, int start, int target, int n, int val, Integer[] soFar) {
        if (n - val == 2) {
            if (start >= nums.length - 1) return;
            int left = start, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    soFar[val] = nums[left++];
                    soFar[val + 1] = nums[right--];
                    op.add(Arrays.copyOf(soFar, 3));
                } else if (sum > target) {
                    right--;
                } else left++;
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                soFar[val] = nums[i];
                getNSum(nums, i + 1, target - nums[i], n, val + 1, soFar);
            }
        }
    }
}

import java.util.Arrays;

/**
 * Created on:  Aug 08, 2020
 * Questions: https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1, 1, -1, -1, 3}, 1) + " = 1");
        System.out.println(threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82) + " = 82");
    }

    public static int threeSumClosest(int[] nums, int target) {
        int op = Integer.MAX_VALUE, diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (sum == target) return sum;
                if (sum > target) end--;
                else start++;
                if (Math.abs(target - sum) < diff) {
                    diff = Math.abs(target - sum);
                    op = sum;
                }
            }
        }
        return op;
    }
}

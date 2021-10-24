import java.util.Arrays;

/**
 * Created on:  Sep 24, 2021
 * Ref: https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}) + " = 6");

    }

    public static int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len], right = new int[len];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            left[i] = max;
            max = Math.max(max, height[i]);
        }
        System.out.println("left = " + Arrays.toString(left));
        max = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            right[i] = max;
            max = Math.max(max, height[i]);
        }
        System.out.println("right = " + Arrays.toString(right));
        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            int water = Math.min(left[i], right[i]) - height[i];
            sum += water > 0 ? water : 0;
        }
        return sum;
    }
}

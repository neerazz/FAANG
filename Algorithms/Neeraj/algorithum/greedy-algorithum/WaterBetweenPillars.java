/**
 * Created on:  Sep 24, 2021
 * Ref: https://leetcode.com/discuss/interview-question/1471501/FacebookorVirtual-Onsiteor-Water-between-pillarsor-Java
 */
public class WaterBetweenPillars {
    public static void main(String[] args) {
        System.out.println(getWater(new int[]{1, 2, 3, 4, 5}) + " = 10");
        System.out.println(getWater(new int[]{5, 2, 1, 2, 5}) + " = 30");
        System.out.println(getWater(new int[]{6, 1, 5, 1, 3}) + " = 22");
        System.out.println(getWater(new int[]{5, 1, 0, 2, 6}) + " = 32");
    }

    private static int getWater(int[] nums) {
        int sum = 0, len = 0;
        if (len < 2) return sum;
        int[] left = new int[len], right = new int[len];
        left[0] = nums[0];
        right[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(nums[i - 1], nums[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], nums[i + 1]);
        }
        return sum;
    }
}

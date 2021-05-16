package weekly.weekly227;

/**
 * Created on:  Feb 06, 2021
 * Questions:
 */

public class CheckIfArrayIsSortedAndRotated {

    public static void main(String[] args) {
        System.out.println(check(new int[]{3, 4, 5, 1, 2}));
    }

    public static boolean check(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (isRotated(nums, i, len)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isRotated(int[] nums, int start, int len) {
        int count = 0;
        while (count < len-1) {
            int next = start + 1;
            if (next >= len) next = 0;
            if (nums[start] > nums[next]) return false;
            start = next;
            count++;
        }
        return true;
    }
}

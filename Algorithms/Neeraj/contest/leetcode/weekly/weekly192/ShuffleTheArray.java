package weekly.weekly192;

import java.util.Arrays;

/**
 * Created on:  Jun 06, 2020
 * Questions: https://leetcode.com/problems/shuffle-the-array
 */
public class ShuffleTheArray {
    public static void main(String[] args) {
        System.out.println("**************************** Solution 1 *********************************");
        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)) + " should be [2,3,5,4,1,7].");
        System.out.println(Arrays.toString(shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)) + " should be [1,4,2,3,3,2,4,1].");
        System.out.println(Arrays.toString(shuffle(new int[]{1, 1, 2, 2}, 2)) + " should be [1,2,1,2].");
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] op = new int[2 * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            op[index++] = nums[i];
            op[index++] = nums[n + i];
        }
        return op;
    }
}

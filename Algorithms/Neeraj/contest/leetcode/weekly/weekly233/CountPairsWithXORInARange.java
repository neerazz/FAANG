package weekly.weekly233;

import java.util.*;

/**
 * Created on:  Mar 20, 2021
 * Questions:
 */

public class CountPairsWithXORInARange {

    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{1,4,2,7}, 2,6) + " = 6");
        System.out.println(countPairs(new int[]{9,8,4,2,1}, 5,14) + " = 8");
        System.out.println(countPairs(new int[]{7881,760,709,2937,1245,720,5187,6361,3793,141,7238}, 1492,3832) + " = 16");
    }

    public static int countPairs(int[] nums, int low, int high) {
        Arrays.sort(nums);
        int len = nums.length;
        long pairs = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int xor = nums[i] ^ nums[j];
                if (low <= xor && xor <= high) pairs++;
                else if (xor > high) break;
            }
        }
        return (int) pairs;
    }
}

package biweekly.biweekly42;

/**
 * Created on:  Dec 26, 2020
 * Questions:
 */

public class MinimumAdjacentSwapsForKConsecutiveOnes {

    public static void main(String[] args) {

    }

    public static int minMoves(int[] nums, int k) {
        int max = 0, con = 0;
        for (int num : nums) {
            if (num == 1) {
                con++;
            } else {
                max = Math.max(max, con);
                con = 0;
            }
        }
        return max;
    }
}

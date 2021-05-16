package weekly.weekly196;

import java.util.Arrays;

/**
 * Created on:  Jul 04, 2020
 * Questions: https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence
 */
public class CanMakeArithmeticProgressionFromSequence {
    public static void main(String[] args) {

    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] - arr[i - 1] != arr[i + 1] - arr[i]) {
                return false;
            }
        }
        return true;
    }
}

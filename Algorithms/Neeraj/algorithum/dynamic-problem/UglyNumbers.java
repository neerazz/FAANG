import java.util.Arrays;

/**
 * Crated on:  Apr 09, 2020
 */

/*
Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.
Given a number n, the task is to find n’th Ugly number.
Examples:
Input  : n = 7
Output : 8
Input  : n = 10
Output : 12
Input  : n = 15
Output : 24
Input  : n = 150
Output : 5832
 */
public class UglyNumbers {
    public static void main(String[] args) {
        System.out.println(getNthUglyNo(10));
        System.out.println(getNthUglyNo(11));
    }

    private static int getNthUglyNo(int n) {
        int[] nums = new int[n];
        int i2 = 0, i3 = 0, i5 = 0, next_multiple_of_2 = 2, next_multiple_of_3 = 3, next_multiple_of_5 = 5;
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            int curVal = Math.min(next_multiple_of_2, Math.min(next_multiple_of_3, next_multiple_of_5));
            nums[i] = curVal;
//            When the two,three, or four values are consumed, then get the next increase the index.
//            Edge Case: Same value can occur two time, so both of the index counter needs to be increased.
//              Ex: 2*3 (6) and 3*2 (6), In that case both i2 & i3 counter needs to be increased.
            if (curVal == next_multiple_of_2) {
                next_multiple_of_2 = nums[++i2] * 2;
            }
            if (curVal == next_multiple_of_3) {
                next_multiple_of_3 = nums[++i3] * 3;
            }
            if (curVal == next_multiple_of_5) {
                next_multiple_of_5 = nums[++i5] * 5;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums[n - 1];
    }
}

/**
 * Created on:  Jul 13, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/mE2LVDE3wp0
 * Find the Corrupt Pair (easy) #
 * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array originally contained all the numbers from 1 to ‘n’, but due to a data error, one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.
 * <p>
 * Example 1:
 * <p>
 * Input: [3, 1, 2, 5, 2]
 * Output: [2, 4]
 * Explanation: '2' is duplicated and '4' is missing.
 * Example 2:
 * <p>
 * Input: [3, 1, 2, 3, 6, 4]
 * Output: [3, 5]
 * Explanation: '3' is duplicated and '5' is missing.
 */

public class FindCorruptNums {

    public static void main(String[] args) {

    }

    public static int[] findNumbers(int[] nums) {
        int dub = -1, missing = -1, len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i + 1) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
                if (nums[i] == temp) {
                    dub = nums[i];
                    break;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                missing = i + 1;
                break;
            }
        }
        return new int[]{dub, missing};
    }
}

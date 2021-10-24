import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Jul 13, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/Y52qNM0ljWK
 */

public class AllMissingNumbers {

    public static void main(String[] args) {

    }

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int cur = Math.abs(nums[i]) - 1;
            if (nums[cur] < 0) continue;
            nums[cur] *= -1;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                missingNumbers.add(i + 1);
            }
        }
        return missingNumbers;
    }
}

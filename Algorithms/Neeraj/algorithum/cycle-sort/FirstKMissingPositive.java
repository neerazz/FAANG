import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on:  Jul 13, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/q2LA7G0ANX0
 */

public class FirstKMissingPositive {

    public static void main(String[] args) {

    }

    /*
        2, 3, 4
        0  1   2  3  4
        4, 2, 3
                 i
     */

    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> greater = new HashSet<>();
        int len = nums.length, i = 0;
        while (i < len) {
//            If the current element is in 1 to len range, then swap with that index.
            if (nums[i] > 0 && nums[i] <= len && nums[i] != i + 1) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
                if (nums[i] == temp) {
//                    If the current element is duplicates, then move to next position.
                    i++;
                }
            } else {
                if (nums[i] > len) greater.add(nums[i]);
                i++;
            }
        }
//        Collect the missing numbers between 1 to len.
        for (int j = 0; j < len && k > 0; j++) {
            if (nums[j] != j + 1) {
                missingNumbers.add(j + 1);
                k--;
            }
        }
//        If more missing numbers are required then start taking number from len+1;
        int cur = len + 1;
        while (k > 0) {
            if (greater.add(cur)) {
                missingNumbers.add(cur);
                k--;
            }
            cur++;
        }
        return missingNumbers;
    }
}

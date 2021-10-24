import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Sep 15, 2021
 * Ref: https://leetcode.com/problems/missing-ranges/
 * <p>
 * You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.
 * <p>
 * A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
 * <p>
 * Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.
 * <p>
 * Each range [a,b] in the list should be output as:
 * <p>
 * "a->b" if a != b
 * "a" if a == b
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,3,50,75], lower = 0, upper = 99
 * Output: ["2","4->49","51->74","76->99"]
 * Explanation: The ranges are:
 * [2,2] --> "2"
 * [4,49] --> "4->49"
 * [51,74] --> "51->74"
 * [76,99] --> "76->99"
 * Example 2:
 * <p>
 * Input: nums = [], lower = 1, upper = 1
 * Output: ["1"]
 * Explanation: The only missing range is [1,1], which becomes "1".
 * Example 3:
 * <p>
 * Input: nums = [], lower = -3, upper = -1
 * Output: ["-3->-1"]
 * Explanation: The only missing range is [-3,-1], which becomes "-3->-1".
 * Example 4:
 * <p>
 * Input: nums = [-1], lower = -1, upper = -1
 * Output: []
 * Explanation: There are no missing ranges since there are no missing numbers.
 * Example 5:
 * <p>
 * Input: nums = [-1], lower = -2, upper = -1
 * Output: ["-2"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -109 <= lower <= upper <= 109
 * 0 <= nums.length <= 100
 * lower <= nums[i] <= upper
 * All the values of nums are unique.
 */
public class MissingRanges {
    public static void main(String[] args) {

    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int next = lower;
        for (int cur : nums) {
            if (cur < next) continue;
            if (next == cur) {
                next++;
            } else {
                result.add(format(next, cur - 1));
                next = cur + 1;
            }
        }
        if (next <= upper) result.add(format(next, upper));
        return result;
    }

    String format(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }
}

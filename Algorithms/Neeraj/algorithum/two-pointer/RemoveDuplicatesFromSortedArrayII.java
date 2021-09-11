/**
 * Created on:  Dec 11, 2020
 * Questions: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3562/
 */

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        int pre = Integer.MIN_VALUE, count = 0, preIdx = 0;
        for (int cur : nums) {
            if (pre == cur) {
                if (count++ < 2) {
                    nums[preIdx++] = cur;
                }
            } else {
                nums[preIdx++] = cur;
                count = 1;
                pre = cur;
            }
        }
        return preIdx;
    }
}

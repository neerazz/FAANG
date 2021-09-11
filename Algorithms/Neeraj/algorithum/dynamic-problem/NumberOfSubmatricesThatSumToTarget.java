/**
 * Created on:  Apr 17, 2021
 * Questions: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3711/
 */

public class NumberOfSubmatricesThatSumToTarget {

    public static void main(String[] args) {

    }

    public int minOperations(int[] nums) {
        int pre = nums[0], len = nums.length, oper = 0;
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            if (cur <= pre) {
                int diff = pre - cur + 1;
                oper += diff;
                cur += diff;
            }
            pre = cur;
        }
        return oper;
    }
}

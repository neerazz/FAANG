import java.util.*;

/**
 * Created on:  Sep 10, 2021
 * Ref: https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        int can = 0, count = 0, len = nums.length;
        for (int num : nums) {
            if (count == 0) can = num;
            count += (num == can) ? 1 : -1;
        }
        return can;
    }
}

/*
    Created on:  Apr 13, 2020
 */

import java.util.HashMap;

/**
 * Questions:
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class ContiguousArray {
    public static void main(String[] args) {

    }
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
//        Initialize the map with zero (as we are starting with zero sum) and
//          set the value to -1 (So that when calculating the difference at an index) it includes that element.
        map.put(0,-1);
        int sum =0, maxLen =0;
        for(int i =0; i < nums.length; i++){
//            Set the current value to -1 if zero. So that the sum (0(-1), 1) will be zero.
            int cur = nums[i] == 0 ? -1 : 1;
//            Keep adding the current value to sum.
            sum += cur;
            if(map.containsKey(sum)){
//                Check if the sum exists, and if exists.
//                We are checking irrespective to the sum value is zero because,
//                     even it is -1 or 1 we calculating the maxlength from the previous index of -1 and 1 respectively.
//                     Consider if sum = -1, that means all the elements from current to element that produced -1 previously
                maxLen = Math.max(maxLen, i-map.get(sum));
            }
//            insert the current element if the sum is not present.
//            Note: we will insert only if it is not present, that way we are maintaining the previous index that gave that sum.
            map.putIfAbsent(sum,i);
        }
        return maxLen;
    }
}

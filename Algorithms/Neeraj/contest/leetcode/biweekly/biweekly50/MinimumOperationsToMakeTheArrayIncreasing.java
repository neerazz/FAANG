package biweekly.biweekly50;

/**
 * Created on:  Apr 17, 2021
 * Questions: https://leetcode.com/contest/biweekly-contest-50/problems/minimum-operations-to-make-the-array-increasing/
 */

public class MinimumOperationsToMakeTheArrayIncreasing {

    public static void main(String[] args) {

    }
    public int minOperations(int[] nums) {
        int pre = nums[0], len = nums.length, oper =0;
        for(int i=1; i<len; i++){
            int cur = nums[i];
            if(cur <= pre){
                int diff = pre - cur +1;
                oper += diff;
                cur += diff;
            }
            pre = cur;
        }
        return oper;
    }
}

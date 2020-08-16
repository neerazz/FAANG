/**
 * Created on:  Aug 15, 2020
 * Questions: https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
    public static void main(String[] args) {

    }

    public static int missingNumber(int[] nums) {
        int len = nums.length, xor = 0;
        for (int i = 0; i < len; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ len;
    }
}

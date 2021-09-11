/**
 * Created on:  Jun 18, 2021
 * Ref: https://leetcode.com/problems/sign-of-the-product-of-an-array/
 */

public class SignOfTheProductOfAnArray {

    public static void main(String[] args) {

    }

    public int arraySign(int[] nums) {
        int neg = 0, zero = 0;
        for (int num : nums) {
            if (num < 0) neg++;
            else if (num == 0) zero++;
        }
        if (zero > 0) return 0;
        return neg % 2 == 0 ? 1 : -1;
    }
}

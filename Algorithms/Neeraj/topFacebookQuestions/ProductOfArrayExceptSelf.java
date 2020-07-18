/**
 * Created on:  Jul 17, 2020
 * Questions:
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {

    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len == 0) return nums;
        int[] left = new int[len], res = new int[len];
        left[0] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int prod = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = left[i] * prod;
            prod *= nums[i];
        }
        return res;
    }
}

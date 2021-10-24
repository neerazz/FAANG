/*
    Created on:  May 04, 2020
 */

/**
 * Questions:
 */
public class FindOdd {
    public static void main(String[] args) {
        System.out.println(findOdd(new int[]{12, 12, 14, 90, 14, 14, 14}));
    }

    private static int findOdd(int[] nums) {
        int op = 0;
        for (int num : nums) {
            op ^= num;
        }
        return op;
    }
}

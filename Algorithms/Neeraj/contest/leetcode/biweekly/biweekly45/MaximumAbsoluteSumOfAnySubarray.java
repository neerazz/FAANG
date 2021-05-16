package biweekly.biweekly45;

/**
 * Created on:  Feb 06, 2021
 * Questions:
 */

public class MaximumAbsoluteSumOfAnySubarray {

    public static void main(String[] args) {
        System.out.println(maxAbsoluteSum(new int[]{1, -3, 2, 3, -4}));
        System.out.println(maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2}));
    }

    //    https://www.youtube.com/watch?v=gjCFVr_nJtU&feature=emb_title
    public static int maxAbsoluteSum(int[] nums) {
        int min = 0, max = 0, result = 0;
        for (int num : nums) {
            min += num;
            max += num;
            result = Math.max(result, Math.max(Math.abs(min), max));
            if (min > 0) min = 0;
            if (max < 0) max = 0;
        }
        return result;
    }
}

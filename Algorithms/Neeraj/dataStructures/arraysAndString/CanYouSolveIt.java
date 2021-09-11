/*
    Created on:  May 07, 2020
 */

/**
 * Questions: https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/can-you-solve-it/
 */
public class CanYouSolveIt {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int tests = fr.nextInt();
        for (int i = 0; i < tests; i++) {
            int n = fr.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = fr.nextInt();
            }
            System.out.println(solve(nums));
        }
    }

    private static int solve(int[] nums) {
        int len = nums.length;
//        There are total four possibilities if we remove the mode factor.
//        Find the maximum difference in both the plus and minus array.
        int plusMax = Integer.MIN_VALUE, plusMin = Integer.MAX_VALUE, minusMax = Integer.MIN_VALUE, minusMin = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            plusMax = Math.max(plusMax, nums[i] + i);
            plusMin = Math.min(plusMin, nums[i] + i);
            minusMax = Math.max(minusMax, nums[i] - i);
            minusMin = Math.min(minusMin, nums[i] - i);
        }
        return Math.max(plusMax - plusMin, minusMax - minusMin);
    }
}

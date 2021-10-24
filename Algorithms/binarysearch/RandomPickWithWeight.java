import java.util.Arrays;

/**
 * Created on:  Jun 05, 2020
 * Questions: https://leetcode.com/problems/random-pick-with-weight/
 * <p>
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.
 * <p>
 * Note:
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 */
public class RandomPickWithWeight {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 3});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }

    static class Solution {
        //    Take a range scale and plot it based on the weight ration (cur weight/total weight)
        double[] ranges;

        public Solution(int[] w) {
            ranges = new double[w.length];
            long sum = Arrays.stream(w).sum(), curSum = 0;
            for (int i = 0; i < w.length; i++) {
                curSum += w[i];
                ranges[i] = (double) curSum / sum;
            }
        }

        public int pickIndex() {
            return Math.abs(Arrays.binarySearch(ranges, Math.random())) - 1;
        }
    }
}


import java.util.Arrays;
import java.util.Random;

/**
 * Created on:  Jul 20, 2020
 * Questions: https://leetcode.com/problems/random-pick-with-weight/
 */
public class RandomPickWithWeight {
    public static void main(String[] args) {
        Solution sol = new Solution(new int[]{1, 3});
        System.out.println(sol.pickIndex());
        System.out.println(sol.pickIndex());
        System.out.println(sol.pickIndex());
        System.out.println(sol.pickIndex());
        System.out.println(sol.pickIndex());
    }

    static class Solution {
        double[] ratio;
        Random random;

        public Solution(int[] w) {
            int len = w.length;
            this.random = new Random();
            long sum = Arrays.stream(w).sum();
            ratio = new double[len];
            double cur = 0;
            int i = 0;
            for (int num : w) {
                cur += num;
                ratio[i++] = cur / sum;
            }
        }

        public int pickIndex() {
            double random = Math.random();
            int start = 0, end = ratio.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (ratio[mid] == random) return mid;
                if (ratio[mid] < random) start = mid + 1;
                else end = mid - 1;
            }
            return start;
        }
    }

}

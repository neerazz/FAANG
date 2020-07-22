import java.util.Arrays;

/**
 * Created on:  Jul 20, 2020
 * Questions:
 */
public class RandomPickWithWeight {
    public static void main(String[] args) {

    }

    static class Solution {

        double[] weights;
        int[] w;

        public Solution(int[] w) {
            this.w = w;
            double sum = 0;
            weights = new double[w.length];
//            Calculate the sum of all the weights and save the portion of weights in the weights.
            for (int num : w) {
                sum += num;
            }
            double carry = 0;
            for (int i = 0; i < w.length; i++) {
                weights[i] = carry += w[i] / sum;
            }
        }

        public int pickIndex() {
            double val = Math.random();
            int start = 0, end = w.length;
//            Find the closes index of val in the weights array.
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (weights[mid] == val) return mid;
                if (weights[mid] < val) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return start;
        }
    }

}

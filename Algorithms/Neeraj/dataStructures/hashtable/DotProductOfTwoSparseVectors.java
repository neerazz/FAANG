import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Aug 16, 2021
 * Ref : https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
 */
public class DotProductOfTwoSparseVectors {
    public static void main(String[] args) {

    }

    static class SparseVector {
        Set<Integer> idxs = new HashSet<>();
        int[] nums;

        SparseVector(int[] nums) {
            int len = nums.length;
            this.nums = nums;
            for (int i = 0; i < len; i++) {
                if (nums[i] != 0) {
                    idxs.add(i);
                }
            }
        }

        public int get(int idx) {
            return nums[idx];
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int product = 0;
            for (int idx : idxs) {
                product += get(idx) * vec.get(idx);
            }
            return product;
        }
    }
}

/**
 * Created on:  Aug 16, 2021
 * Ref : https://leetcode.com/problems/range-sum-query-immutable/
 */
public class RangeSumQueryImmutable {
    public static void main(String[] args) {

    }

    static class NumArray {
        int[] sTree;
        int[] nums;

        public NumArray(int[] nums) {
            int len = nums.length, sLen = 4 * len;
            sTree = new int[sLen];
            buildTree(nums, 0, len - 1, 0);
            this.nums = nums;
        }

        void buildTree(int[] nums, int start, int end, int i) {
            if (start == end) {
                sTree[i] = nums[start];
            } else {
                int mid = (end + start) / 2;
                int left = 2 * i + 1, right = 2 * i + 2;
                buildTree(nums, start, mid, left);
                buildTree(nums, mid + 1, end, right);
                sTree[i] = sTree[left] + sTree[right];
            }
        }

        int query(int s, int e, int qs, int qe, int i) {
            if (e < qs || qe < s) return 0;
            if (qs <= s && e <= qe) return sTree[i];
            int mid = (s + e) / 2;
            int left = 2 * i + 1, right = 2 * i + 2;
            return query(s, mid, qs, qe, left) + query(mid + 1, e, qs, qe, right);
        }

        public int sumRange(int left, int right) {
            return query(0, nums.length - 1, left, right, 0);
        }
    }
}

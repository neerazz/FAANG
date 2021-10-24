/**
 * Created on:  Oct 07, 2020
 * Questions: https://leetcode.com/problems/range-sum-query-mutable/
 * <p>
 * https://www.youtube.com/watch?v=ZBHKZF5w4YU
 */

public class RangeSumQueryMutable {

    public static void main(String[] args) {
        NumArray numarray = new NumArray(new int[]{-1});
        System.out.println(numarray.sumRange(0, 0));
        numarray.update(0, 1);
        System.out.println(numarray.sumRange(0, 1));
    }

    static class NumArray {

        int[] segmentTree, nums;

        public NumArray(int[] nums) {
            int len = nums.length;
            if (len == 0) return;
            segmentTree = new int[4 * len];
            this.nums = nums;
            buildSegmentTree(nums, segmentTree, 0, len - 1, 0);
        }

        private void buildSegmentTree(int[] nums, int[] tree, int low, int high, int idx) {
            if (low == high) {
                tree[idx] = nums[low];
            } else {
                int mid = (low + high) / 2;
//                Left idx = 2n+1, Right idx = 2n+2
                buildSegmentTree(nums, tree, low, mid, 2 * idx + 1);
                buildSegmentTree(nums, tree, mid + 1, high, 2 * idx + 2);
                tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
            }
        }

        public void update(int i, int val) {
            int diff = val - nums[i];
            nums[i] = val;
            updateSegmentTree(i, 0, nums.length - 1, 0, diff);
        }

        private void updateSegmentTree(int idx, int start, int end, int point, int diff) {
            if (idx < start || idx > end) return;
            segmentTree[point] += diff;
            if (start == end) return;
//            Don't make recursive calls when both of them are same.
            int mid = (start + end) / 2;
//            Go left
            updateSegmentTree(idx, start, mid, 2 * point + 1, diff);
//            Go right
            updateSegmentTree(idx, mid + 1, end, 2 * point + 2, diff);
        }

        public int sumRange(int i, int j) {
            return getSegmentValue(i, j, 0, nums.length - 1, 0);
        }

        private int getSegmentValue(int qs, int qe, int s, int e, int i) {
//            If the query range is completely out  of the range.
            if (qs > e || qe < s) return 0;
//            If query value is with in the range then return the value.
            if (qs <= s && qe >= e) {
                return segmentTree[i];
            }
//            If the query range is in both left and right side.
            int mid = (s + e) / 2;
            return getSegmentValue(qs, qe, s, mid, 2 * i + 1) + getSegmentValue(qs, qe, mid + 1, e, 2 * i + 2);
        }
    }
}

/**
 * Created on:  Jul 23, 2020
 * Questions: https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST {
    int op = 0;

    public static void main(String[] args) {

    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        helper(root, L, R);
        return op;
    }

    private void helper(TreeNode root, int min, int max) {
        if (root == null) return;
        if (root.val >= min && root.val <= max) {
            op += root.val;
            helper(root.left, min, max);
            helper(root.right, min, max);
        } else if (root.val < min && root.right != null) {
            helper(root.right, min, max);
        } else if (root.val > max && root.left != null) {
            helper(root.left, min, max);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val +
                    ", left=" + left +
                    ", right=" + right;
        }
    }
}

/**
 * Created on:  Jul 19, 2020
 * Questions: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
    static int max;

    public static void main(String[] args) {

    }

    public static int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }

    private static int helper(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int left = helper(root.left), right = helper(root.right);
        int cur = root.val, path = cur, combined = cur;
        if (left != Integer.MIN_VALUE) {
//            Check if only left or cur+left can be max.
            max = Math.max(max, left);
            max = Math.max(max, cur + left);
            combined += left;
            path = Math.max(path, cur + left);
        }
        if (right != Integer.MIN_VALUE) {
            max = Math.max(max, right);
            max = Math.max(max, cur + right);
            combined += right;
            path = Math.max(path, cur + right);
        }
        max = Math.max(max, Math.max(cur, combined));
        return path;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}

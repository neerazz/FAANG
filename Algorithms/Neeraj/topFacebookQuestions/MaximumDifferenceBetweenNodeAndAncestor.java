/**
 * Created on:  Jul 27, 2020
 * Questions: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
    static int op;

    public static void main(String[] args) {

    }

    public static int maxAncestorDiff(TreeNode root) {
        op = Integer.MIN_VALUE;
        dfs(root, root.val, root.val);
        return op;
    }

    private static void dfs(TreeNode root, int min, int max) {
        if (root == null) return;
        op = Math.max(op, Math.abs(root.val - min));
        op = Math.max(op, Math.abs(root.val - max));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }

    static class TreeNode {
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

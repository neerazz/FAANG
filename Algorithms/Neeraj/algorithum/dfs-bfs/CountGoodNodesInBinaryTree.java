/**
 * Created on:  Jun 18, 2021
 * Ref: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */

public class CountGoodNodesInBinaryTree {

    public static void main(String[] args) {

    }

    static int count;

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        count = 0;
        helper(root, root.val);
        return count;
    }

    private void helper(TreeNode root, int max) {
        if (root == null) return;
        if (max <= root.val) count++;
        int curMax = Math.max(max, root.val);
        helper(root.left, curMax);
        helper(root.right, curMax);
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

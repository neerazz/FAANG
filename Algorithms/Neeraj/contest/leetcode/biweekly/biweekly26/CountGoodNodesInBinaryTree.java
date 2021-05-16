package biweekly.biweekly26;
/*
    Created on:  May 16, 2020
 */

/**
 * Questions: https://leetcode.com/contest/biweekly-contest-26/problems/count-good-nodes-in-binary-tree/
 */
public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {

    }

    static int count;

    public static int goodNodes(TreeNode root) {
        count = 0;
        if (root == null) return 0;
        helper(root, root.val);
        return count;
    }

    private static void helper(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) count++;
        max = Math.max(max, root.val);
        helper(root.left, max);
        helper(root.right, max);
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

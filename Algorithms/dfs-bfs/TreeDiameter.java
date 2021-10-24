/**
 * Created on:  Jul 16, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/xVV1jA29YK9
 * Given a binary tree, find the length of its diameter. The diameter of a tree is the number of nodes on the longest path between any two leaf nodes. The diameter of a tree may or may not pass through the root.
 * <p>
 * Note: You can always assume that there are at least two leaf nodes in the given tree.
 */

public class TreeDiameter {

    static int max;

    public static int findDiameter(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }

    static int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left), right = helper(root.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
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

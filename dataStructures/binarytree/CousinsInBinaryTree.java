/*
    Created on:  May 07, 2020
 */

/**
 * Questions: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3322/
 */
public class CousinsInBinaryTree {
    public static void main(String[] args) {

    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        int[] xParents = {0, 0}, yParents = {0, 0};
        if (getParent(root, x, xParents, 0) && getParent(root, y, yParents, 0)) {
            return xParents[0] != yParents[0] && xParents[1] == yParents[1];
        }
        return false;
    }

    private static boolean getParent(TreeNode root, int val, int[] vals, int level) {
        if (root == null || (root.left == null && root.right == null)) return false;
        if ((root.left != null && root.left.val == val) || (root.right != null && root.right.val == val)) {
            vals[0] = root.val;
            vals[1] = level;
            return true;
        }
        return getParent(root.left, val, vals, level + 1) || getParent(root.right, val, vals, level + 1);
    }

}

package trees;

import util.TreeNode;
import util.Util;

/*
https://leetcode.com/problems/invert-binary-tree/ 
F 
 
Given the root of a binary tree, invert the tree, and return its root.
 
Input: root = [4,2,7,1,3,6,9] 
Output: [4,7,2,9,6,3,1]
 
Input: root = [2,1,3] 
Output: [2,3,1]
*/

public class InvertTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode root = Util.createTree(input);
        TreeNode sol = invertTree(root);
        Util.print(sol);
    }
}

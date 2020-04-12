/**
 * Crated on:  Apr 11, 2020
 */
/*
Given a binary tree, you need to compute the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.
Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {

    }
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        // System.out.println("max =" + max);
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(left+right, max);
        return Math.max(left,right)+1;
    }
}

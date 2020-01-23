/*
LC: EASY
https://leetcode.com/problems/balanced-binary-tree/
Problem : 110

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:
A binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Example 1:
Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:
Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.

*/

public class IsTreeBalanced {

    public static void main(String[] args) {
        TreeNode n7 = new TreeNode(7);
        TreeNode n6 = new TreeNode(15);
        TreeNode n3 = new TreeNode(20);
        n3.left = n6;
        n3.right = n7;
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = n3;
        Util.print(root);
        System.out.println((isBalanced(root)));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return height(root) != -1;
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        int lH = height(root.left);
        int rH = height(root.right);
        //Need to check if anywhere -1 was returned, keep returning i
        if (lH == -1 || rH == -1 || lH - rH < -1 || lH - rH > 1) {
            return -1;
        }
        //Same as depth calculation - You increment by 1 for every node
        return Math.max(lH, rH) + 1;
    }

}

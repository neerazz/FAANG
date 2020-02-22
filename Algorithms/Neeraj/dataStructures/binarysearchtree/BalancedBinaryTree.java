/*
https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/143/appendix-height-balanced-bst/1027/
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
public class BalancedBinaryTree {
    static boolean isBalanced = true;

    public static void main(String[] args) {
        System.out.println(isBalanced(ValidateBinarySearchTree.createTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(isBalanced(ValidateBinarySearchTree.createTreeNode(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
    }

    public static boolean isBalanced(TraverseATree.TreeNode root) {
        if (root == null) return true;
        isBalancedHelper(root, 0);
        return isBalanced;
    }

    private static int isBalancedHelper(TraverseATree.TreeNode root, int height) {
        if (root == null) return height;
        int leftCounter = 1, rightCounter = 1;
        if (root.left != null) leftCounter += isBalancedHelper(root.left, height);
        if (root.right != null) rightCounter += isBalancedHelper(root.right, height);
        isBalanced = isBalanced ? Math.abs(leftCounter - rightCounter) <= 1 : isBalanced;
        return height + Math.max(leftCounter, rightCounter);
    }
}

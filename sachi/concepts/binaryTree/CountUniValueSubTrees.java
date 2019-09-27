/*
Count Univalue Subtrees
Solution
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

Example :
Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

Output: 4
 */

public class CountUniValueSubTrees {
    private static int count = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(countUnivalSubtrees(root));

    }

    private static int countUnivalSubtrees(TreeNode root) {
        if (root == null) return count;
        if (root.left == null && root.right == null)  ++count;
        if (root.left.val == root.right.val) return ++count;
        return countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
    }

}

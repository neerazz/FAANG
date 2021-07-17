package concepts.binaryTree;

import util.TreeNode;

/*
Path Sum
Solution
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
Note: A leaf is a node with no children.

Example:
Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 */
public class PathSum {
    public static void main(String[] args) {

    }

    private static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum = sum - root.val;
        if (root.left == null && root.right == null && sum == 0)
            return true;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    //TODO: Iteration
}

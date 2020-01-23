/*
LC: EASY
https://leetcode.com/problems/maximum-depth-of-binary-tree/
Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Note: A leaf is a node with no children.

Example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its depth = 3.

 */
public class MaxDepthOfBinaryTree {
    private static int answer = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        //System.out.println(maxDepth(root));
        //System.out.println(maxDepthPreOrder(root));
        System.out.println(maxDepth(root, 1));
    }

    //My Solution
    public static int maxDepth(TreeNode node, int d){
        if(node == null) return --d;
        ++d;
        return Math.max(maxDepth(node.left, d), maxDepth(node.right, d));
    }

    //Post Order - Bottom Up
    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }

    //PreOrder - Top Down
    private static int maxDepthPreOrder(TreeNode root) {
        answer = 0;
        if (root == null) return 0;
        maxDepthPreOrderHelper(root, 0);
        return ++answer;
    }

    //PreOrder - Top Down HELPER
    private static void maxDepthPreOrderHelper(TreeNode root, int depth) {
        if (root == null) return;
        //Optimization
        if (root.left == null || root.right == null) {
            answer = Math.max(answer, depth);
        }
        maxDepthPreOrderHelper(root.left, depth + 1);
        maxDepthPreOrderHelper(root.right, depth + 1);
    }

}

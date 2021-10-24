package trees;

import util.TreeNode;

/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/
P
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node
down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2

Example 3:
Input: root = []
Output: 0

Example 4:
Input: root = [0]
Output: 1

 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode node) {
        int max = 0, leftMax, rightMax;

        if (node == null) return 0;

        if (node.left == null) {
            leftMax = 0;
        } else {
            leftMax = maxDepth(node.left);
        }

        if (node.right == null) {
            rightMax = 0;
        } else {
            rightMax = maxDepth(node.right);
        }

        max = Math.max(leftMax, rightMax);
        return max + 1;
    }


}

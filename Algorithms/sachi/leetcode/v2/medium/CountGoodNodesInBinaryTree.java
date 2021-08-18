package leetcode.v2.medium;

import util.TreeNode;

/*
https://leetcode.com/problems/count-good-nodes-in-binary-tree/
P
Given a binary tree root, a node X in the tree is named good if in the path from root to X
there are no nodes with a value greater than X.
Return the number of good nodes in the binary tree.

Example 1:
Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
*/

public class CountGoodNodesInBinaryTree {

    int sol = 0;

    public int goodNodes(TreeNode root) {
        goodNodes(root, Integer.MIN_VALUE);
        return sol;
    }
    
    public void goodNodes(TreeNode node, int maxVal) {
        if (node == null) return;
        if (node.val >= maxVal) sol++;
        maxVal = Math.max(node.val, maxVal);
        goodNodes(node.left, maxVal);
        goodNodes(node.right, maxVal);
    }
}

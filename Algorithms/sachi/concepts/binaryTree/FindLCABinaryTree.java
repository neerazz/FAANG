package concepts.binaryTree;

import util.TreeNode;

/*
LC: 236 Medium

https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia:

“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
(where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


 */
public class FindLCABinaryTree {

    public static void main(String[] args) {
        TreeNode root = null;
        TreeNode p = null;
        TreeNode q = null;

        findLCA(root, p, q);
    }

    public static TreeNode findLCA(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }

        if (node.equals(p) || node.equals(q)) {
            return node;
        }

        TreeNode leftTree = findLCA(node.left, p, q);
        TreeNode rightTree = findLCA(node.right, p, q);

        if (leftTree != null && rightTree != null) {
            return node;
        }

        return leftTree != null ? leftTree : rightTree;
    }
}

package problems.binarysearchtree;

import static problems.binarysearchtree.ValidateBinarySearchTree.createTreeNode;

/*
https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/142/conclusion/1012/
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Note:
All of the nodes' values will be unique.
p and q are different and both values will exist in the BST.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        System.out.println("Answer is : " + lowestCommonAncestor(createTreeNode(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}),
                new TreeNode(2), new TreeNode(8)) + " should be [6].");
        System.out.println("Answer is : " + lowestCommonAncestor(createTreeNode(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}),
                new TreeNode(2), new TreeNode(4)) + " should be [2].");
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }
}

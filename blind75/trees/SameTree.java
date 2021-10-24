package trees;

/*
https://leetcode.com/problems/same-tree/
F

Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Input: p = [1,2,3], q = [1,2,3]
Output: true

Input: p = [1,2], q = [1,null,2]
Output: false

Input: p = [1,2,1], q = [1,1,2]
Output: false
*/

import util.TreeNode;

public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        boolean leftMatch = isSameTree(p.left, q.left);
        boolean valMatch = p.val == q.val;
        boolean rightMatch = isSameTree(p.right, q.right);
        return leftMatch && valMatch && rightMatch;
    }

}

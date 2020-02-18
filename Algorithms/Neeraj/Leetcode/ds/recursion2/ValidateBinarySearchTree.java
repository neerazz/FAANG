package ds.recursion2;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2874/
Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Input: [2,1,3]
Output: true
Example 2:
    5
   / \
  1   4
     / \
    3   6
Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        System.out.println(isValidBST(createTreeNode(new Integer[]{2, 1, 3})) + " should be true");
        System.out.println(isValidBST(createTreeNode(new Integer[]{5, 1, 4, null, null, 3, 6})) + " should be false");
        System.out.println(isValidBST(createTreeNode(new Integer[]{10, 5, 15, null, null, 6, 20})) + " should be false");
    }

    private static TreeNode createTreeNode(Integer[] integers) {
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode head = null;
        int index = 0;
        while (index < integers.length) {
            if (nodes.isEmpty()) {
                Integer current = integers[index++];
                if (current != null) {
                    TreeNode treeNode = new TreeNode(current);
                    nodes.add(treeNode);
                    head = treeNode;
                }
            } else {
//                Create left and right child.
                TreeNode currentHead = nodes.poll();
//                Create left Child.
                Integer left = integers[index++];
                if (left != null) {
                    TreeNode treeNode = new TreeNode(left);
                    currentHead.left = treeNode;
                    nodes.add(treeNode);
                }
//                Create Right Child.
                Integer right = integers[index++];
                if (right != null) {
                    TreeNode treeNode = new TreeNode(right);
                    currentHead.right = treeNode;
                    nodes.add(treeNode);
                }
            }
        }
        return head;
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBSTWithMinAndMax(root, null, null);
    }

    public static boolean isValidBSTWithMinAndMax(TreeNode root, Integer minvalue, Integer maxValue) {
        if (root == null) return true;
        if (minvalue != null && root.val <= minvalue) return false;
        if (maxValue != null && root.val >= maxValue) return false;
        return isValidBSTWithMinAndMax(root.left, minvalue, root.val) && isValidBSTWithMinAndMax(root.right, root.val, maxValue);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}

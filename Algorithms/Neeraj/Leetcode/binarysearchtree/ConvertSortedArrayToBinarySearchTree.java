package binarysearchtree;

import java.util.Arrays;

/*
https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/143/appendix-height-balanced-bst/1015/
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Example:
Given the sorted array: [-10,-3,0,5,9],
One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
      0
     / \
   -3   9
   /   /
 -10  5
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int mid = nums.length / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
//        Traverse to the left side of the array.
        treeNode.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
//        Traverse to the right side of the array.
        treeNode.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return treeNode;
    }
}

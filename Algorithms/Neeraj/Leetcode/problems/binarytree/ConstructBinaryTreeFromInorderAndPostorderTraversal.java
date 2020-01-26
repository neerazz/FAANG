package problems.binarytree;

import java.util.HashMap;

/*
https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/942/
Given inorder and postorder traversal of a tree, construct the binary tree.
Note: You may assume that duplicates do not exist in the tree.
For example, given
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    static int rootIndex = 0;
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
//        Set the root index.
        rootIndex = postorder.length - 1;
//        Set values in a map.
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
//        Call the recursive method starting from zero to end of array.
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTreeHelper(int[] inorder, int[] postorder, int left, int right) {
        if (left > right) return null;
//        Get the last value of post and create a root.
        int postRootValue = postorder[rootIndex];
        TreeNode root = new TreeNode(postRootValue);
        rootIndex--;

//      Now get the index of root and divide the array into two from the index position.
        int inorderIndex = hashMap.get(postRootValue);
        root.right = buildTreeHelper(inorder, postorder, inorderIndex + 1, right);
        root.left = buildTreeHelper(inorder, postorder, left, inorderIndex - 1);
        return root;
    }
}

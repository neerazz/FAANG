package ds.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static ds.binarytree.TraverseATree.createTreeNode;

/*
https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/943/
Given preorder and inorder traversal of a tree, construct the binary tree.
Note: You may assume that duplicates do not exist in the tree.
For example, given
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    static int rootIndex = 0;

    public static void main(String[] args) {
        System.out.println("Answer is \t: " + buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}) + "\nshould be \t: " + createTreeNode(new ArrayList<>(Arrays.asList(3, 9, 20, null, null, 15, 7))));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        Set values in a map.
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
//        Call the recursive method starting from zero to end of array.
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1, hashMap);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> hashMap) {
        if (left > right) return null;
//        Get the last value of post and create a root.
        int rootValue = preorder[rootIndex++];
        TreeNode root = new TreeNode(rootValue);

//      Now get the index of root and divide the array into two from the index position.
        int inorderIndex = hashMap.get(rootValue);
        root.left = buildTreeHelper(preorder, inorder, left, inorderIndex - 1, hashMap);
        root.right = buildTreeHelper(preorder, inorder, inorderIndex + 1, right, hashMap);
        return root;
    }
}

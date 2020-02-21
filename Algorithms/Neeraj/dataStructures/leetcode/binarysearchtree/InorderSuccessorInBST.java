package ds.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

import static ds.binarysearchtree.ValidateBinarySearchTree.createTreeNode;

/*
https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/140/introduction-to-a-bst/998/
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
The successor of a node p is the node with the smallest key greater than p.val.
Example 1:
Input: root = [2,1,3], p = 1
Output: 2
Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
Example 2:
Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: null
Explanation: There is no in-order successor of the current node, so the answer is null.
Note:
If the given node has no in-order successor in the tree, return null.
It's guaranteed that the values of the tree are unique.
 */
public class InorderSuccessorInBST {
    public static void main(String[] args) {
        System.out.println("Answer is:" + inorderSuccessor(createTreeNode(new Integer[]{2, 1, 3}), new TreeNode(1)) + " should be [2].");
        System.out.println("Answer is:" + inorderSuccessor(createTreeNode(new Integer[]{5, 3, 6, 1, 4, null, null, null, 2}), new TreeNode(4)) + " should be [5].");
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        List<Integer> integers = new ArrayList<>();
        inorderSuccessorHelper(root, p, integers);
        int index = integers.indexOf(p.val);
        return index + 1 >= integers.size() ? null : new TreeNode(integers.get(index + 1));
    }

    private static void inorderSuccessorHelper(TreeNode root, TreeNode p, List<Integer> integers) {
        if (root == null) return;
        if (root.left != null) inorderSuccessorHelper(root.left, p, integers);
        integers.add(root.val);
        if (root.right != null) inorderSuccessorHelper(root.right, p, integers);
    }
}

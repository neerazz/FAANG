package ds.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

import static ds.binarysearchtree.ValidateBinarySearchTree.createTreeNode;

/*
https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/140/introduction-to-a-bst/1008/
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Example:
BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
Note:
next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
 */
public class BinarySearchTreeIterator {
    public static void main(String[] args) {
        BSTIterator bstIterator = new BSTIterator(createTreeNode(new Integer[]{7, 3, 15, null, null, 9, 20}));
    }
}

class BSTIterator {

    List<Integer> inorderList = new ArrayList<>();
    int index = 0;

    public BSTIterator(TreeNode root) {
        performInorderTraversal(root);
    }

    private void performInorderTraversal(TreeNode root) {
        if (root == null) return;
        if (root.left != null) performInorderTraversal(root.left);
        inorderList.add(root.val);
        if (root.right != null) performInorderTraversal(root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return inorderList.get(index++);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return index < inorderList.size();
    }
}
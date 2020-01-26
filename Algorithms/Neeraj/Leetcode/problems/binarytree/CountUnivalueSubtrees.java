package problems.binarytree;

import java.util.ArrayList;
import java.util.Arrays;

import static problems.binarytree.TraverseATree.createTreeNode;

/*
https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/538/
Given a binary tree, count the number of uni-value subtrees.
A Uni-value subtree means all nodes of the subtree have the same value.
Example :
Input:  root = [5,1,5,5,5,null,5]
              5
             / \
            1   5
           / \   \
          5   5   5
Output: 4
Solution: Given a node in our tree, we know that it is a univalue subtree if it meets one of the following criteria:
The node has no children (base case)
All of the node's children are univalue subtrees, and the node and its children all have the same value
 */
public class CountUnivalueSubtrees {
    static int count = 0;

    public static void main(String[] args) {
        TreeNode treeNode = createTreeNode(new ArrayList<>(Arrays.asList(5, 1, 5, 5, 5, null, 5)));
        System.out.println("Answer is: " + countUnivalSubtrees(treeNode) + " should be [4].");
        count = 0;
        treeNode = createTreeNode(new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5, null, 5)));
        System.out.println("Answer is: " + countUnivalSubtrees(treeNode) + " should be [6].");
        count = 0;
        treeNode = createTreeNode(new ArrayList<>(Arrays.asList(5, 1, 3, 1, 1, 1)));
        System.out.println("Answer is: " + countUnivalSubtrees(treeNode) + " should be [4].");
        count = 0;
        treeNode = createTreeNode(new ArrayList<>(Arrays.asList(7, 82, 82, -79, 98, 98, -79, -79, null, -28, -24, -28, -24, null, -79, null, 97, 65, -4, null, 3, -4, 65, 3, null, 97)));
        System.out.println("Answer is: " + countUnivalSubtrees(treeNode) + " should be [8].");
    }

    public static int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        countUnivalSubtreesHelper(root);
        return count;
    }

    private static boolean countUnivalSubtreesHelper(TreeNode node) {
//        base case - if the node has no children this is a univalue subtree
        if (node.left == null && node.right == null) {
            count++;
            return true;
        }
        boolean isUnivalue = true;
//        Do a recursive call to the left and right child's and check if all the childs are univalue.
        if (node.left != null) {
            isUnivalue = countUnivalSubtreesHelper(node.left) && node.left.val == node.val;
        }
        if (node.right != null) {
            isUnivalue = countUnivalSubtreesHelper(node.right) && isUnivalue && node.right.val == node.val;
        }
//        If the above are univalue then increment the count.
        if (!isUnivalue) return false;
        count++;
        return true;
    }
}

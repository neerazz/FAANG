package weekly.weekly190;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on:  May 23, 2020
 * Questions: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 */
public class PseudoPalindromicPathsInABinaryTree {
    public static void main(String[] args) {
        System.out.println(pseudoPalindromicPaths(createTreeNode(new Integer[]{2, 3, 1, 3, 1, null, 1})));
    }

    public static TreeNode createTreeNode(Integer[] integers) {
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

    static int op;

    public static int pseudoPalindromicPaths(TreeNode root) {
        op = 0;
        if (root == null) return 0;
        int[] counts = new int[10];
        helper(root, counts, 0);
        return op;
    }

    private static void helper(TreeNode root, int[] counts, int count) {
        counts[root.val]++;
        count++;
        if (root.left == null && root.right == null) {
            if (canBePalindrome(counts, count)) {
                op++;
            }
            counts[root.val]--;
            return;
        }
        if (root.left != null) {
            helper(root.left, counts, count);
        }
        if (root.right != null) {
            helper(root.right, counts, count);
        }
        counts[root.val]--;
    }

    private static boolean canBePalindrome(int[] counts, int count) {
        boolean canHaveOneOdd = count % 2 == 1;
        for (int val : counts) {
            if (val % 2 == 1) {
                if (canHaveOneOdd) {
                    canHaveOneOdd = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

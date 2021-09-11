import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/143/appendix-height-balanced-bst/1027/
Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
Example 1:
Given the following tree [3,9,20,null,null,15,7]:
    3
   / \
  9  20
    /  \
   15   7
Return true.
Example 2:
Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
 */
public class BalancedBinaryTree {

    static int max = 1_000_000;
    static boolean isBalanced = true;

    public static void main(String[] args) {
        System.out.println(isBalanced(createTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(isBalanced(createTreeNode(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
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

    public static boolean isBalanced_rev_2(TreeNode root) {
        if (root == null) return true;
        int left = getHeight(root.left), right = getHeight(root.right);
        return isBalanced && Math.abs(left - right) <= 1;
    }

    private static int getHeight(TreeNode node) {
        if (node == null) return 0;
        if (!isBalanced) return max;
        int left = getHeight(node.left), right = getHeight(node.right);
        if (left == max || right == max) return max;
        isBalanced = Math.abs(left - right) <= 1;
        return Math.max(left, right) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        isBalancedHelper(root, 0);
        return isBalanced;
    }

    private static int isBalancedHelper(TreeNode root, int height) {
        if (root == null) return height;
        int leftCounter = 1, rightCounter = 1;
        if (root.left != null) leftCounter += isBalancedHelper(root.left, height);
        if (root.right != null) rightCounter += isBalancedHelper(root.right, height);
        isBalanced = isBalanced && Math.abs(leftCounter - rightCounter) <= 1;
        return height + Math.max(leftCounter, rightCounter);
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

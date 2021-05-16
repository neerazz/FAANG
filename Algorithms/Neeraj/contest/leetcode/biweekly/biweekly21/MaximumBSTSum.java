package biweekly.biweekly21;

import java.util.*;

class MaximumBSTSum {

    public static void main(String[] args) {
        System.out.println(maxSumBST(createTreeNode(new Integer[]{1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6})));
        System.out.println(maxSumBST(createTreeNode(new Integer[]{4, 3, null, 1, 2})));
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

    static int max_BST = 0;

    public static int maxSumBST(TreeNode root) {
        if (root == null) return max_BST;
        max_BST = 0;
        isValidBST(root);
        return max_BST;
    }

    static class Pair {
        Integer min;
        Integer max;
        int sum;
        boolean isBST;

        public Pair(Integer min, Integer max, int sum, boolean isBST) {
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.isBST = isBST;
        }
    }

    public static Pair isValidBST(TreeNode root) {
        if (root == null) return new Pair(null, null, 0, true);
        Pair left = isValidBST(root.left);
        Pair right = isValidBST(root.right);
        //        Check if after including the current node is it still BST
        //        If the current node value is greater then maximum value at left node
        boolean leftCondition = left.max == null || left.max < root.val;
        //        If the current node value is less then the minimum value at right node
        boolean rightCondition = right.min == null || right.min > root.val;
        if (left.isBST && right.isBST && leftCondition && rightCondition) {
            //            Then current Node is BST.
            int currentSum = root.val + left.sum + right.sum;
            max_BST = Math.max(max_BST, currentSum);
            int min = left.min == null ? root.val : left.min;
            int max = right.max == null ? root.val : right.max;
            return new Pair(min, max, currentSum, true);
        } else {
            return new Pair(root.val, root.val, root.val, false);
        }
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

package weekly.weekly199;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created on:  Jul 25, 2020
 * Questions: https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
 */
public class NumberOfGoodLeafNodesPairs {
    static int result;
    static int index;

    public static void main(String[] args) {
        System.out.println(countPairs(createTreeNode(new Integer[]{1, 2, 3, null, 4}), 3) + " = 1");
        System.out.println(countPairs(createTreeNode(new Integer[]{1, 2, 3, 4, 5, 6, 7}), 3) + " = 2");
        System.out.println(countPairs(createTreeNode(new Integer[]{7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2}), 3) + " = 1");
        System.out.println(countPairs(createTreeNode(new Integer[]{100}), 1) + " = 0");
        System.out.println(countPairs(createTreeNode(new Integer[]{1, 1, 1}), 2) + " = 1");
        System.out.println(countPairs(createTreeNode(new Integer[]{15, 66, 55, 97, 60, 12, 56, null, 54, null, 49, null, 9, null, null, null, null, null, 90}), 5) + " = 3");
    }

    public static int countPairs(TreeNode root, int distance) {
        result = 0;
        dfs(root, distance);
        return result;
    }

    private static int[] dfs(TreeNode root, int distance) {
//        Keep the distance from the leaf.
        int[] cur = new int[11];
        if (root == null) return cur;
        if (root.left == null && root.right == null) {
            cur[1] = 1;
            return cur;
        }
        int[] left = dfs(root.left, distance);
        int[] right = dfs(root.right, distance);
//        Check if distance from any of the child's satisfies the condition.
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i + j <= distance) {
//                    When the sum of left distance and right distance is below the acceptable distance.
//                    Then add all the possible nodes that have that left and right distance.
                    result += (left[i] * right[j]);
                }
            }
        }
//        Populate a new array from the left and right distances.
        for (int i = 0; i <= 9; ++i) {
//            The left and right distance sum is increased by one.
            cur[i + 1] += left[i];
            cur[i + 1] += right[i];
        }
        return cur;
    }

    private static void visitNodes(TreeNode root, List<Integer> leafs) {
        if (root == null) return;
        index++;
        if (root.left == null && root.right == null) {
            leafs.add(index);
        }
        if (root.left != null) {
            visitNodes(root.left, leafs);
            index++;
        }
        if (root.right != null) {
            visitNodes(root.right, leafs);
            index++;
        }
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

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
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

package binarysearch;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/1028/
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:
Input: root = [4,2,5,1,3], target = 3.714286
    4
   / \
  2   5
 / \
1   3
Output: 4
 */
public class ClosestBinarySearchTreeValue {
    public static void main(String[] args) {
        TreeNode treeNode = createTreNode(new Integer[]{4, 2, 5, 1, 3});
        System.out.println("Answer is: " + closestValue(treeNode, 3.714286) + " should be [4].");
        System.out.println("Answer is: " + closestValue(treeNode, 3.114286) + " should be [3].");
        treeNode = createTreNode(new Integer[]{1});
        System.out.println("Answer is: " + closestValue(treeNode, 4.4) + " should be [1].");
        treeNode = createTreNode(new Integer[]{0});
        System.out.println("Answer is: " + closestValue(treeNode, 2147483648.0) + " should be [0].");
    }

    public static int closestValue_elegent(TreeNode root, double target) {
        int val, closest = root.val;
        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }

    private static TreeNode createTreNode(Integer[] integers) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode treeNode = new TreeNode(integers[0]);
        queue.add(treeNode);
        int index = 1;
        while (!queue.isEmpty() && index < integers.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                TreeNode left = integers[index] != null ? new TreeNode(integers[index++]) : null;
                TreeNode right = integers[index] != null ? new TreeNode(integers[index++]) : null;
                if (left != null) {
                    poll.left = left;
                    queue.add(left);
                }
                if (right != null) {
                    poll.right = right;
                    queue.add(right);
                }
                if (index >= integers.length) break;
            }
        }
        return treeNode;
    }

    public static int closestValue(TreeNode root, double target) {
        if (root == null) return -1;
        return closestValueHelper(root, target, null, root.val);
    }

    private static int closestValueHelper(TreeNode root, double target, Double difference, int closest) {
        Integer currentClosest = null;
        if (root.left != null && root.val > target) {
            currentClosest = getClosestValue(root.left.val, root.val, target);
            return getClosestValue(currentClosest, closestValueHelper(root.left, target, Math.abs(currentClosest - target), currentClosest), target);
        }
        if (root.right != null && root.val < target) {
            currentClosest = getClosestValue(root.right.val, root.val, target);
            return getClosestValue(currentClosest, closestValueHelper(root.right, target, Math.abs(currentClosest - target), currentClosest), target);
        }
        return getClosestValue(currentClosest, closest, target);
    }

    private static int getClosestValue(Integer val1, Integer val2, double target) {
        if (val1 == null) return val2;
        if (val2 == null) return val1;
        return Math.abs(val1 - target) > Math.abs(val2 - target) ? val2 : val1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
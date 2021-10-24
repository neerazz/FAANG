import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created on:  Jun 21, 2021
 * Ref: https://leetcode.com/problems/boundary-of-binary-tree/
 */

public class BoundaryOfBinaryTree {

    public static void main(String[] args) {
        System.out.println(boundaryOfBinaryTree_rev1(BinaryTree.createTreeNode(new Integer[]{1, 2, 7, 3, 5, null, 6, 4})));
        System.out.println(boundaryOfBinaryTree(BinaryTree.createTreeNode(new Integer[]{1})));
    }

    public static List<Integer> boundaryOfBinaryTree_rev1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);
        if (isLeaf(root)) return result;
        List<Integer> left = new ArrayList<>(), leaf = new ArrayList<>();
        LinkedList<Integer> right = new LinkedList<>();
        collectLeft(root.left, left);
        collectLeaf(root, leaf);
        collectRight(root.right, right);
        result.addAll(left);
        result.addAll(leaf);
        result.addAll(right);
        return result;
    }

    private static void collectRight(TreeNode root, LinkedList<Integer> right) {
        if (root == null) return;
        if (isLeaf(root)) return;
        right.addFirst(root.val);
        collectRight(root.right == null ? root.left : root.right, right);
    }

    private static void collectLeft(TreeNode root, List<Integer> left) {
        if (root == null) return;
        if (isLeaf(root)) return;
        left.add(root.val);
        collectLeft(root.left == null ? root.right : root.left, left);
    }

    private static void collectLeaf(TreeNode root, List<Integer> leaf) {
        if (root == null) return;
        if (isLeaf(root)) {
            leaf.add(root.val);
        } else {
            collectLeaf(root.left, leaf);
            collectLeaf(root.right, leaf);
        }
    }

    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);
        if (isLeaf(root)) return result;
        TreeNode cur = root.left;
//        Get Left boundary.
        while (cur != null) {
            if (!isLeaf(cur)) {
                result.add(cur.val);
            }
            cur = cur.left == null ? cur.right : cur.left;
        }
        getLeafBoundary(result, root);
//        Get Right boundary.
        cur = root.right;
        Stack<Integer> stack = new Stack<>();
        while (cur != null) {
            if (!isLeaf(cur)) {
                stack.add(cur.val);
            }
            cur = cur.right == null ? cur.left : cur.right;
        }
        while (!stack.isEmpty()) result.add(stack.pop());
        return result;
    }

    private static void getLeafBoundary(List<Integer> result, TreeNode root) {
        if (root == null) return;
        if (isLeaf(root)) {
            result.add(root.val);
        } else {
            getLeafBoundary(result, root.left);
            getLeafBoundary(result, root.right);
        }
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    static class Node {
        TreeNode tree;
        boolean isLeft;

        Node(TreeNode tree, boolean isLeft) {
            this.tree = tree;
            this.isLeft = isLeft;
        }
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created on:  Jun 21, 2021
 * Ref: https://leetcode.com/problems/boundary-of-binary-tree/
 */

public class BoundaryOfBinaryTree {

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
}

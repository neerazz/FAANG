package interview;

import util.TreeNode;
import util.Util;

import java.sql.SQLOutput;
import java.util.*;

public class BinaryTree {


    /**
     * PreOrder Traversal. For Iteration use - Stack
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        helperPreOrder(root, sol);
        return sol;
    }

    public static void helperPreOrder(TreeNode node, List<Integer> sol) {
        if (node == null) return;
        sol.add(node.val);
        helperPreOrder(node.left, sol);
        helperPreOrder(node.right, sol);
    }

    /**
     * Inorder Traversal. For Iteration use Stack
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        helperInorder(root, sol);
        return sol;
    }

    public static void helperInorder(TreeNode node, List<Integer> sol) {
        if (node == null) return;
        helperInorder(node.left, sol);
        sol.add(node.val);
        helperInorder(node.right, sol);
    }

    /**
     * PostOrder Traversal. For Iteration use stack
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        helperPostOrder(root, sol);
        return sol;
    }

    public static void helperPostOrder(TreeNode node, List<Integer> sol) {
        if (node == null) return;
        helperPostOrder(node.left, sol);
        helperPostOrder(node.right, sol);
        sol.add(node.val);
    }

    /**
     * Level Traversal - Use Queue - Instantiate as ArrayDeque()
     * Get Queue Size and do all operations till the size is greater than zero.
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        if (root == null) return sol;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int levels = queue.size();
            while (levels-- > 0) {
                TreeNode innerNode = queue.poll();
                list.add(innerNode.val);
                if (innerNode.left != null) queue.add(innerNode.left);
                if (innerNode.right != null) queue.add(innerNode.right);
            }
            sol.add(list);
        }
        return sol;
    }


}

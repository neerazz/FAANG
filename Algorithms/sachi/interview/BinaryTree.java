package interview;

import util.TreeNode;
import java.util.ArrayList;
import java.util.List;

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


}

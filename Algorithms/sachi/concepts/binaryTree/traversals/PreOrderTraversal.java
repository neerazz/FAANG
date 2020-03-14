package traversals;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        preorderTraversalRecur(root, sol);
        return sol;
    }

    public List<Integer> preOrderTraversalIter(TreeNode root) {
        if (root == null) return null;
        List<Integer> sol = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sol.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sol;
    }

    public void preorderTraversalRecur(TreeNode node, List<Integer> sol) {
        if (node == null) return;
        sol.add(node.val);
        preorderTraversalRecur(node.left, sol);
        preorderTraversalRecur(node.right, sol);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
package traversals;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        inorderTraversalRecur(root, sol);
        return sol;
    }

    public void inorderTraversalRecur(TreeNode root, List<Integer> sol) {
        if (root == null) return;
        inorderTraversalRecur(root.left, sol);
        sol.add(root.val);
        inorderTraversalRecur(root.right, sol);
    }

    public List<Integer> inOrderTraversalIter(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {

        }
        return null;
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
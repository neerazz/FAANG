import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a binary tree, return the preorder traversal of its nodes' values.
Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]


Follow up: Recursive solution is trivial, could you do it iteratively?

 */
public class PreOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        preorderTraversalRecur(root).forEach(e -> System.out.print(e + " "));
        System.out.println();
        preorderTraversalIteration(root).forEach(e -> System.out.print(e + " "));
    }

    //Node -> Left -> Right
    private static List<Integer> preorderTraversalRecur(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        preorderTraversalRecursionHelper(root, sol);
        return sol;
    }

    private static void preorderTraversalRecursionHelper(TreeNode root, List<Integer> sol) {
        if (root == null) return;
        sol.add(root.val);
        preorderTraversalRecursionHelper(root.left, sol);
        preorderTraversalRecursionHelper(root.right, sol);
    }

    //Iteration
    //Linkedlist - Add Right, then left
    //Poll Last
    private static List<Integer> preorderTraversalIteration(TreeNode root) {
        List<Integer> solution = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (root == null) return solution;
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            TreeNode tree = linkedList.pollLast();
            solution.add(tree.val);
            if (tree.right != null) linkedList.add(tree.right);
            if (tree.left != null) linkedList.add(tree.left);
        }
        return solution;
    }
}
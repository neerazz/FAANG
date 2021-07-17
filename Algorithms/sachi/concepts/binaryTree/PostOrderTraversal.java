package concepts.binaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Binary Tree Postorder Traversal
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]

Follow up: Recursive solution is trivial, could you do it iteratively?

 */
public class PostOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        postOrderTraversalRecur(root).forEach(e -> System.out.print(e + " "));
        System.out.println();
        postOrderTraversalIteration(root).forEach(e -> System.out.print(e + " "));
    }

    //Left -> Right -> Node
    private static List<Integer> postOrderTraversalRecur(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        postOrderHelper(root, sol);
        return sol;
    }

    private static void postOrderHelper(TreeNode root, List<Integer> sol) {
        if (root == null) return;
        postOrderHelper(root.left, sol);
        postOrderHelper(root.right, sol);
        sol.add(root.val);
    }

    //TODO: Implement this
    private static List<Integer> postOrderTraversalIteration(TreeNode root) {
        return new ArrayList<>();
    }


}

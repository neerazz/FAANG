import java.util.ArrayList;
import java.util.List;
/*
Given a binary tree, return the inorder traversal of its nodes' values.
Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]

Follow up: Recursive solution is trivial, could you do it iteratively?
 */

public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        inOrderTraversalRecur(root).forEach(e -> System.out.print(e + " "));
        System.out.println();
        inOrderTraversalIteration(root).forEach(e -> System.out.print(e + " "));
    }

    //Left -> Node -> Right
    private static List<Integer> inOrderTraversalRecur(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        inOrderTraversalHelper(root, sol);
        return sol;
    }

    private static void inOrderTraversalHelper(TreeNode node, List sol) {
        if (node == null) return;
        inOrderTraversalHelper(node.left, sol);
        sol.add(node.val);
        inOrderTraversalHelper(node.right, sol);
    }

    private static List<Integer> inOrderTraversalIteration(TreeNode root) {
        //TODO: Implement this
        return new ArrayList<>();
    }

}

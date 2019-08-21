/*
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Note: A leaf is a node with no children.

Example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 */
public class MaxDepthBinary {

    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(7);
        TreeNode t4 = new TreeNode(15);
        TreeNode t3 = new TreeNode(20);
        t3.left = t4;
        t3.right = t5;
        TreeNode t2 = new TreeNode(9);
        TreeNode t1 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.println(maxDepth(t1));
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
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
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        three.left = nine;
        three.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;
        System.out.println(maxDepth(three));
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return getDepth(root, 0);
    }

    private static int getDepth(TreeNode root, int value) {
        if (root == null) return value;
        int left = value, right = value;
        if (root.left != null) {
            left = getDepth(root.left, value);
        }
        if (root.right != null) {
            right = getDepth(root.right, value);
        }
        return Math.max(left, right) + 1;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }
}

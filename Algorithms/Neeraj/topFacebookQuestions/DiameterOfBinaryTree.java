/**
 * Created on:  Jul 20, 2020
 * Questions: https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {
    int max = 0;

    public static void main(String[] args) {

    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        getHeight(root);
        return max - 1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left + 1, right + 1);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}

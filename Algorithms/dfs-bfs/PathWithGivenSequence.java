/**
 * Created on:  Jul 16, 2021
 * Ref:
 */

public class PathWithGivenSequence {

    public static boolean findPath(TreeNode root, int[] sequence) {
        return helper(root, sequence, 0);
    }

    static boolean helper(TreeNode root, int[] seq, int idx) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (idx == seq.length - 1) return root.val == seq[idx];
            return false;
        }
        if (idx == seq.length) return false;
        if (root.val != seq[idx]) return false;
        return helper(root.left, seq, idx + 1) || helper(root.right, seq, idx + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[]{1, 0, 7}));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[]{1, 1, 6}));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

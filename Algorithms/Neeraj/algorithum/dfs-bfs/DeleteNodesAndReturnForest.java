import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on:  Aug 06, 2021
 * Ref : https://leetcode.com/problems/delete-nodes-and-return-forest/
 */
public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {

    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int del : to_delete) set.add(del);
        boolean deleted = helper(root, set, result);
        if (!deleted) result.add(root);
        return result;
    }

    private static boolean helper(TreeNode root, Set<Integer> set, List<TreeNode> result) {
        if (root == null) return false;
        boolean left = helper(root.left, set, result);
        boolean right = helper(root.right, set, result);
        boolean delCur = set.contains(root.val);
        if (delCur) {
            if (!left && root.left != null) result.add(root.left);
            if (!right && root.right != null) result.add(root.right);
        }
        if (left) root.left = null;
        if (right) root.right = null;
        return delCur;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val +
                    ", left=" + left +
                    ", right=" + right;
        }
    }
}

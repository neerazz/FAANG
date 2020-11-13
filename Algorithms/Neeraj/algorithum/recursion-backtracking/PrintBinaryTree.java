import java.util.*;

/**
 * Created on:  Nov 13, 2020
 * Questions: https://leetcode.com/problems/print-binary-tree/
 */

public class PrintBinaryTree {

    public static void main(String[] args) {

    }

    public static List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int len = (int) (Math.pow(2, height) - 1);
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> level = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                level.add("");
            }
            result.add(level);
        }
        helper(root, 0, len, 0, result);
        return result;
    }

    private static void helper(TreeNode root, int start, int end, int row, List<List<String>> result) {
        if (root == null) return;
        int mid = (start + end + 1) / 2;
        result.get(row).set(mid, "" + root.val);
        helper(root.left, start, mid - 1, row + 1, result);
        helper(root.right, mid + 1, end, row + 1, result);
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left), right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}

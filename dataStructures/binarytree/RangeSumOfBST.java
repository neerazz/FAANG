/**
 * Created on:  Sep 30, 2020
 * Questions: https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST {
    static int sum;

    public static void main(String[] args) {

    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;
        helper(root, L, R);
        return sum;
    }

    private static void helper(TreeNode root, int min, int max) {
        if (root == null) return;
        if (root.val < min) {
            helper(root.right, min, max);
        } else if (root.val > max) {
            helper(root.left, min, max);
        } else {
            sum += root.val;
            helper(root.right, min, max);
            helper(root.left, min, max);
        }
    }
}

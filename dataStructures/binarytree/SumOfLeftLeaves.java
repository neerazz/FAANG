/**
 * Created on:  Aug 24, 2020
 * Questions: https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {
    static int op;

    public static void main(String[] args) {

    }

    public static int sumOfLeftLeaves(TreeNode root) {
        op = 0;
        helper(root, 'M');
        return op;
    }

    private static void helper(TreeNode root, char dir) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (dir == 'L') op += root.val;
        } else {
            helper(root.left, 'L');
            helper(root.right, 'R');
        }
    }
}

/**
 * Created on:  Sep 08, 2020
 * Questions: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class SumOfRootToLeafBinaryNumbers {
    static int result = 0;

    public static void main(String[] args) {

    }

    public static int sumRootToLeaf(TreeNode root) {
        result = 0;
        helper(root, 0);
        return result;
    }

    private static void helper(TreeNode root, int soFar) {
        if (root == null) return;
        int cur = (soFar << 1) + root.val;
        if (root.left == null && root.right == null) {
            result += cur;
        } else {
            helper(root.left, cur);
            helper(root.right, cur);
        }
    }
}

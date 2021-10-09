/**
 * Created on:  Aug 19, 2021
 * Ref : https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3903/
 */
public class MaximumProductOfSplittedBinaryTree {
    public static void main(String[] args) {

    }

    static long result;
    static int mod = 1_000_000_007;

    public static int maxProduct(TreeNode root) {
        result = 0;
        long sum = getSum(root);
        helper(root, sum);
        return (int) (result % mod);
    }

    static long helper(TreeNode root, long sum) {
        if (root == null) return 0;
        long left = helper(root.left, sum);
        long right = helper(root.right, sum);
        long curSum = left + right + root.val;
        result = Math.max(result, (sum - curSum) * curSum);
        return curSum;
    }

    static long getSum(TreeNode root) {
        if (root == null) return 0;
        return getSum(root.left) + root.val + getSum(root.right);
    }
}

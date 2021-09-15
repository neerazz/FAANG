/**
 * Created on:  Sep 14, 2021
 * Ref: https://leetcode.com/discuss/interview-experience/1461079/google-swe-l3l4-dublin-ireland-reject
 * <p>
 * Find the longest path passing through the root in a binary tree such that all nodes form an arithmetic progression with the given difference.
 * <p>
 * So for the following tree with given difference -2, we have longest length as 7 (6 -> 4 -> 2 -> 0 -> -2 -> -4 -> -6)
 * <p>
 * https://assets.leetcode.com/users/images/7385ff09-6c51-4b01-8420-afd5555a10b4_1631527816.0401871.png
 */
public class LongestBinaryTreePath {

    public static void main(String[] args) {
        TreeNode n6 = new TreeNode(6);
        TreeNode n6m = new TreeNode(-6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4m = new TreeNode(-4, n7, n6m);
        TreeNode n4 = new TreeNode(4);
        TreeNode n42 = new TreeNode(4, n6, null);
        TreeNode n2 = new TreeNode(2, n4, n42);
        TreeNode n2m = new TreeNode(-2, null, n4m);
        TreeNode n0 = new TreeNode(0, n2, n2m);
        System.out.println(longestNode(n0));
    }

    static int longestNode(TreeNode node) {
        if (node == null) return 0;
        int[] left = dfs(node.left, node.val), right = dfs(node.right, node.val);
        int leftDiff = left[0], leftCount = left[1];
        int rightDiff = right[0], rightCount = right[1];
        if (leftDiff == -1 * rightDiff) {
            return leftCount + rightCount + 1;
        } else {
            return Math.max(leftDiff, rightDiff) + 1;
        }
    }

    private static int[] dfs(TreeNode node, int pre) {
        if (node == null) return new int[2];
        int[] left = dfs(node.left, node.val), right = dfs(node.right, node.val);
        int rootDiff = pre - node.val;
        int leftDiff = left[0], leftCount = left[1];
        int rightDiff = right[0], rightCount = right[1];
//        By default, match the pre node with current node.
        int count = 1;
        if (rootDiff == leftDiff && leftDiff == -1 * rightDiff) {
            count = Math.max(leftCount, rightCount) + 1;
        } else if (rootDiff == leftDiff) {
            count = leftDiff + 1;
        } else if (rootDiff == rightDiff * -1) {
            count = rightDiff + 1;
        }
        return new int[]{rootDiff, count};
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
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

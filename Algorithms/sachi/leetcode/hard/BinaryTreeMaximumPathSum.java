public class BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int dfsMax = dfs(root);
        return Math.max(max, dfsMax);
    }

    public int dfs(TreeNode node) {

        if (node == null) return 0;

        if (node.left == null && node.right == null) {
            return node.val;
        }

        long lMax, rMax;
        lMax = dfs(node.left);
        rMax = dfs(node.right);

        //Including Node max
        long sum = lMax + rMax + node.val;
        long levelMax = Math.max(sum, node.val);
        max = (int) Math.max(max, levelMax);

        //Excluding node max
        int runningMax = (int) Math.max(lMax, rMax);
        return Math.max(runningMax, node.val);
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        //node.right = new TreeNode(3);

        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        System.out.print(binaryTreeMaximumPathSum.maxPathSum(node));
    }
}

package leetcode.v1.easy;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaxProductTree {


    static List<Long> sumList = new ArrayList<>();
    static int MOD = 1000000007;

    public static void main(String[] args) {

        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode four = new TreeNode(4);
        four.left = five;
        four.right = six;

        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        two.left = three;
        two.right = four;

        TreeNode root = new TreeNode(1);
        root.right = two;

        System.out.println(maxProduct(root));
    }

    public static int maxProduct(TreeNode root) {

        computeNodeSum(root);
        long rootSum = sumList.get(sumList.size() - 1);
        long maxProduct = Long.MIN_VALUE;

        for (Long val : sumList) {
            long currMax = (rootSum - val) * val;
            maxProduct = Math.max(currMax, maxProduct);
        }
        return (int) (maxProduct % MOD);

    }

    public static long computeNodeSum(TreeNode node) {

        long nodeSum;
        if (node == null) return 0;
        //Leaf Node
        if (node.left == null && node.right == null) {
            nodeSum = node.val;
            sumList.add(nodeSum);
            return nodeSum;
        }
        //Any other node
        nodeSum = node.val + computeNodeSum(node.left) + computeNodeSum(node.right);
        sumList.add(nodeSum);
        return nodeSum;

    }


}

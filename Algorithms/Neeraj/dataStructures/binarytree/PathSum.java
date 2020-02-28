import java.util.ArrayList;
import java.util.Arrays;


/*
https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/
 */
public class PathSum {
    public static void main(String[] args) {
        TraverseATree.TreeNode treeNode = TraverseATree.createTreeNode(new ArrayList<>(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)));
        System.out.println("Answer is: " + hasPathSum(treeNode, 22) + " should be [true].");
        treeNode = TraverseATree.createTreeNode(new ArrayList<>(Arrays.asList(1)));
        System.out.println("Answer is: " + hasPathSum(treeNode, 0) + " should be [false].");
        treeNode = TraverseATree.createTreeNode(new ArrayList<>(Arrays.asList(1, 2)));
        System.out.println("Answer is: " + hasPathSum(treeNode, 1) + " should be [false].");
    }

    public static boolean hasPathSum(TraverseATree.TreeNode root, int sum) {
        if (root == null) return false;
        return hasPathSumHelper(root, sum, sum);
    }

    private static boolean hasPathSumHelper(TraverseATree.TreeNode root, int remainingSum, int sum) {
//        This is set to false, or else if the sum is reached in any intermediate node it will return true. We have to make sure that sum of root-to-leaf nodes should be sum.
        if (root == null) return false;
        remainingSum -= root.val;
        if (root.left == null && root.right == null) return remainingSum == 0;
        return hasPathSumHelper(root.left, remainingSum, sum) || hasPathSumHelper(root.right, remainingSum, sum);
    }
}

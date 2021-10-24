import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on:  Jul 16, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/B815A0y2Ajn
 */

public class FindAllTreePaths {

    static List<List<Integer>> allPaths;

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        allPaths = new ArrayList<>();
        LinkedList<Integer> soFar = new LinkedList<>();
        helper(root, 0, sum, soFar);
        return allPaths;
    }

    static void helper(TreeNode root, int sum, int expected, LinkedList<Integer> soFar) {
        if (root == null) return;
        int curSum = sum + root.val;
        soFar.add(root.val);
        if (root.left == null && root.right == null) {
            if (curSum == expected) {
                allPaths.add(new ArrayList<>(soFar));
            }
        } else {
            helper(root.left, curSum, expected, soFar);
            helper(root.right, curSum, expected, soFar);
        }
        soFar.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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

import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/problems/maximum-average-subtree/
 */

public class MaximumAverageSubtree {

    public static void main(String[] args) {

    }

    static double max;

    public static double maximumAverageSubtree(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }

    private static int[] helper(TreeNode root) {
        if (root == null) return new int[2];
//        0: sum, 1 : count
        int[] left = helper(root.left), right = helper(root.right);
        int sum = root.val + left[0] + right[0], count = 1 + left[1] + right[1];
        double cur = (double) (sum) / (count);
        max = Math.max(max, cur);
        return new int[]{sum, count};
    }
}

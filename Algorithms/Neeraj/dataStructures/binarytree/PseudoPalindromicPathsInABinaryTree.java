import java.util.*;
import java.io.*;

/**
 * Created on:  Dec 29, 2020
 * Questions: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 */

public class PseudoPalindromicPathsInABinaryTree {

    public static void main(String[] args) {

    }

    static int result;

    public static int pseudoPalindromicPaths(TreeNode root) {
        int[] counts = new int[10];
        result = 0;
        helper(root, counts);
        return result;
    }

    private static void helper(TreeNode root, int[] counts) {
        if (root == null) return;
        int val = root.val;
        counts[val]++;
        if (root.left == null && root.right == null) {
            if (canBePalindrome(counts)) {
                result++;
            }
        } else {
            helper(root.left, counts);
            helper(root.right, counts);
        }
        counts[val]--;
    }

    private static boolean canBePalindrome(int[] counts) {
        // System.out.println(Arrays.toString(counts));
        int odd = 0, count = 0;
        for (int num : counts) {
            count += num;
            if (num % 2 != 0) odd++;
        }
        // System.out.println("Odd = " + odd + " Count=" + count);
        return (count % 2 == 0 && odd == 0) || (count % 2 != 0 && odd <= 1);
    }
}

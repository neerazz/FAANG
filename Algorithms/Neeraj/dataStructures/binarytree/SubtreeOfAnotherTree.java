import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 13, 2021
 * Questions: https://leetcode.com/problems/subtree-of-another-tree/
 */

public class SubtreeOfAnotherTree {

    public static void main(String[] args) {

    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;
        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
}

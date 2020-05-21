import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  May 20, 2020
 * Questions: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementInaBST {
    static List<Integer> list;

    public static void main(String[] args) {

    }

    public static int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        helper(root, k);
        return list.isEmpty() ? -1 : list.get(k - 1);
    }

    private static void helper(TreeNode root, int k) {
        if (root == null || list.size() == k) return;
        helper(root.left, k);
        list.add(root.val);
        helper(root.right, k);
    }
}

/*
    Created on:  Apr 20, 2020
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Questions: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    public static void main(String[] args) {
        System.out.println(bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
        System.out.println(bstFromPreorder(new int[]{4, 2}));
        System.out.println(bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
        System.out.println("**************************************");
        System.out.println(bstFromPreorder_rev1(new int[]{8, 5, 1, 7, 10, 12}));
        System.out.println(bstFromPreorder_rev1(new int[]{4, 2}));
        System.out.println(bstFromPreorder_rev1(new int[]{8, 5, 1, 7, 10, 12}));
    }

    public static TreeNode bstFromPreorder_rev1(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    private static TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) return null;
        if (start == end) return new TreeNode(preorder[start]);
        int first = preorder[start];
        int newStart = start + 1, mid = newStart;
        for (int i = newStart; i <= end; i++) {
            if (preorder[start] > preorder[i]) {
                mid++;
            } else break;
        }
        TreeNode root = new TreeNode(first);
        root.left = helper(preorder, newStart, mid - 1);
        root.right = helper(preorder, mid, end);
        return root;
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        return helper(Arrays.stream(preorder).boxed().collect(Collectors.toList()));
    }

    private static TreeNode helper(List<Integer> nums) {
        if (nums.isEmpty()) return null;
        int first = nums.get(0);
        TreeNode root = new TreeNode(first);
        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        for (int i = 1; i < nums.size(); i++) {
            Integer cur = nums.get(i);
            if (cur < first) left.add(cur);
            else right.add(cur);
        }
        root.left = helper(left);
        root.right = helper(right);
        return root;
    }
}

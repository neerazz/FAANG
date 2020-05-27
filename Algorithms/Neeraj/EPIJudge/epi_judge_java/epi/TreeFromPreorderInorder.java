package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeFromPreorderInorder {

    static int preIndex;

    @EpiTest(testDataFile = "tree_from_preorder_inorder.tsv")
    public static BinaryTreeNode<Integer> binaryTreeFromPreorderInorder(List<Integer> preorder, List<Integer> inorder) {
        preIndex = 0;
        return helper(preorder, inorder);
    }

    private static BinaryTreeNode<Integer> helper(List<Integer> preorder, List<Integer> inorder) {
        int len = inorder.size();
        if (len == 0) return null;
        int mid = preorder.get(preIndex++);
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(mid);
        int start = 0, end = 0;
        List<Integer> left = new ArrayList<>();
        while (end < len && inorder.get(end) != mid) {
            left.add(inorder.get(end++));
        }
        node.left = helper(preorder, left);
        List<Integer> right = new ArrayList<>();
        for (int i = end + 1; i < len; i++) {
            right.add(inorder.get(i));
        }
        node.right = helper(preorder, right);
        return node;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "TreeFromPreorderInorder.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

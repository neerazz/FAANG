package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.List;

public class TreeWithParentInorder {
    @EpiTest(testDataFile = "tree_with_parent_inorder.tsv")

    public static List<Integer> inorderTraversal(BinaryTree<Integer> tree) {
        BinaryTree<Integer> pre = null, cur = tree;
        List<Integer> op = new ArrayList<>();
        while (cur != null) {
            BinaryTree<Integer> next = null;
            if (cur.parent == pre) {
                if (cur.left != null) {
//            If previous node is parent node, then started the subtree
                    next = cur.left;
                } else {
//                You have completed all the lefts. If there is any right go right else go top.
                    op.add(cur.data);
                    next = (cur.right != null) ? cur.right : cur.parent;
                }
            } else if (cur.left == pre) {
//                If you are coming from left side, add the current. And go to right if present or else go up.
                op.add(cur.data);
                next = (cur.right != null) ? cur.right : cur.parent;
            } else {
//                When the subtree is completed, then go up.
                next = cur.parent;
            }
            pre = cur;
            cur = next;
        }
        return op;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "TreeWithParentInorder.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

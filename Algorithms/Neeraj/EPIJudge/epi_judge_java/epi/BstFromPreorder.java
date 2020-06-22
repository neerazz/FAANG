package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class BstFromPreorder {
    @EpiTest(testDataFile = "bst_from_preorder.tsv")

    public static BstNode<Integer> rebuildBSTFromPreorder(List<Integer> list) {
        if (list.isEmpty()) return null;
        BstNode<Integer> node = new BstNode<>(list.get(0));
        int right = 1, len = list.size();
        while (right < len && list.get(0) >= list.get(right)) {
            right++;
        }
        node.left = rebuildBSTFromPreorder(list.subList(1, right));
        node.right = rebuildBSTFromPreorder(list.subList(right, len));
        return node;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "BstFromPreorder.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

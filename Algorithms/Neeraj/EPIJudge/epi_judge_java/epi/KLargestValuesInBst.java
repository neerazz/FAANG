package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;

public class KLargestValuesInBst {
    static List<Integer> op;

    @EpiTest(testDataFile = "k_largest_values_in_bst.tsv")
    public static List<Integer> findKLargestInBst(BstNode<Integer> tree, int k) {
        op = new ArrayList<>();
        performReverseTraversal(tree, k);
        return op;
    }

    private static void performReverseTraversal(BstNode<Integer> tree, int k) {
        if (tree == null || op.size() == k) return;
        performReverseTraversal(tree.right, k);
        if (op.size() < k) {
            op.add(tree.data);
        }
        performReverseTraversal(tree.left, k);
    }

    @EpiTestComparator
    public static boolean comp(List<Integer> expected, List<Integer> result) {
        if (result == null) {
            return false;
        }
        Collections.sort(expected);
        Collections.sort(result);
        return expected.equals(result);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "KLargestValuesInBst.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

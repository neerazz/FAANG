package epi;

import epi.test_framework.BinaryTreeUtils;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.*;

public class LowestCommonAncestor {
    public static BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> tree,
                                              BinaryTreeNode<Integer> node0,
                                              BinaryTreeNode<Integer> node1) {
        if (node0 == null || node1 == null || tree == null) return null;
        Set<BinaryTreeNode<Integer>> path1 = new HashSet<>(getPath(tree, node0));
        List<BinaryTreeNode<Integer>> path2 = getPath(tree, node1);
        for (BinaryTreeNode<Integer> node : path2) {
            if (path1.contains(node)) {
                return node;
            }
        }
        return null;
    }

    private static List<BinaryTreeNode<Integer>> getPath(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> target) {
        if (tree == null) return Collections.emptyList();
        if (tree == target) {
            List<BinaryTreeNode<Integer>> op = new ArrayList<>();
            op.add(tree);
            return op;
        }
        List<BinaryTreeNode<Integer>> left = getPath(tree.left, target);
        List<BinaryTreeNode<Integer>> right = getPath(tree.right, target);
        if (!left.isEmpty()) {
            left.add(tree);
            return left;
        }
        if (!right.isEmpty()) {
            right.add(tree);
            return right;
        }
        return Collections.emptyList();
    }

    @EpiTest(testDataFile = "lowest_common_ancestor.tsv")
    public static int lcaWrapper(TimedExecutor executor,
                                 BinaryTreeNode<Integer> tree, Integer key0,
                                 Integer key1) throws Exception {
        BinaryTreeNode<Integer> node0 = BinaryTreeUtils.mustFindNode(tree, key0);
        BinaryTreeNode<Integer> node1 = BinaryTreeUtils.mustFindNode(tree, key1);

        BinaryTreeNode<Integer> result =
                executor.run(() -> lca(tree, node0, node1));

        if (result == null) {
            throw new TestFailure("Result can not be null");
        }
        return result.data;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "LowestCommonAncestor.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

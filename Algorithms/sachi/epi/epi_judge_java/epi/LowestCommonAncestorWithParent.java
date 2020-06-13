package epi;

import epi.test_framework.*;

public class LowestCommonAncestorWithParent {

    public static BinaryTree<Integer> LCA(BinaryTree<Integer> node0,
                                          BinaryTree<Integer> node1) {
        // TODO - you fill in here.
        if (node0 == null || node1 == null) return null;

        int n1 = depth(node0);
        int n2 = depth(node1);

        if (n1 > n2) {
            return findNode(node0, node1);
        } else {
            return findNode(node1, node0);
        }
    }

    public static BinaryTree<Integer> findNode(BinaryTree<Integer> tree, BinaryTree<Integer> node) {
        while (tree.parent != null) {
            if (tree.equals(node)) {
                return tree;
            }
            tree = tree.parent;
        }
        return tree;
    }


    public static int depth(BinaryTree<Integer> tree) {
        int depth = 0;
        while (tree.parent != null) {
            tree = tree.parent;
            depth++;
        }
        return depth;
    }

    @EpiTest(testDataFile = "lowest_common_ancestor.tsv")
    public static int lcaWrapper(TimedExecutor executor, BinaryTree<Integer> tree,
                                 Integer key0, Integer key1) throws Exception {
        BinaryTree<Integer> node0 = BinaryTreeUtils.mustFindNode(tree, key0);
        BinaryTree<Integer> node1 = BinaryTreeUtils.mustFindNode(tree, key1);

        BinaryTree<Integer> result = executor.run(() -> LCA(node0, node1));

        if (result == null) {
            throw new TestFailure("Result can not be null");
        }
        return result.data;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "LowestCommonAncestorWithParent.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

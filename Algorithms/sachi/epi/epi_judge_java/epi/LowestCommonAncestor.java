package epi;

import epi.test_framework.*;

public class LowestCommonAncestor {
    public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> tree,
                                              BinaryTreeNode<Integer> node0,
                                              BinaryTreeNode<Integer> node1) {
        // TODO - you fill in here.
        return findLCA(tree,node0,node1);
    }

    public static BinaryTreeNode<Integer> findLCA(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {

        if (node == null) {
            return null;
        }
        if (node.equals(p) || node.equals(q)) {
            return node;
        }

        BinaryTreeNode<Integer> leftTree = findLCA(node.left, p, q);
        BinaryTreeNode<Integer> rightTree = findLCA(node.right, p, q);

        if (leftTree != null && rightTree != null) {
            return node;
        }
        return leftTree != null ? leftTree : rightTree;
    }

    @EpiTest(testDataFile = "lowest_common_ancestor.tsv")
    public static int lcaWrapper(TimedExecutor executor,
                                 BinaryTreeNode<Integer> tree, Integer key0,
                                 Integer key1) throws Exception {
        BinaryTreeNode<Integer> node0 = BinaryTreeUtils.mustFindNode(tree, key0);
        BinaryTreeNode<Integer> node1 = BinaryTreeUtils.mustFindNode(tree, key1);

        BinaryTreeNode<Integer> result =
                executor.run(() -> LCA(tree, node0, node1));

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

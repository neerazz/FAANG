package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class IsTreeBalanced {

    @EpiTest(testDataFile = "is_tree_balanced.tsv")

    public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
        if(tree == null) return true;
        return isBalanced(tree.left, tree.right);
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> leftTree, BinaryTreeNode<Integer> rightTree) {
        int diff = height(leftTree,0) - height(rightTree,0);
        return diff <= 1 && diff >= -1;
    }

    public static int height(BinaryTreeNode<Integer> node, int height){
        if(node == null) return height;
        ++height;
        height(node.left, height);
        height(node.right, height);
        return height;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IsTreeBalanced.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeABst {
    @EpiTest(testDataFile = "is_tree_a_bst.tsv")

    public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
        if (tree == null) return true;
        return helper(tree, null, null);
    }

    private static boolean helper(BinaryTreeNode<Integer> tree, Integer min, Integer max) {
        if (tree == null) return true;
        if (min != null && tree.data < min) return false;
        if (max != null && tree.data > max) return false;
        return helper(tree.left, min, tree.data) && helper(tree.right, tree.data, max);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IsTreeABst.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

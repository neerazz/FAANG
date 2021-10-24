/**
 * Created on:  Sep 18, 2020
 * Questions: https://www.algoexpert.io/questions/All%20Kinds%20Of%20Node%20Depths
 */
public class AllKindsOfNodeDepths {
    public static void main(String[] args) {

    }

    public static int allKindsOfNodeDepths(BinaryTree root) {
        if (root == null) return 0;
        return getDepth(root, 0) + allKindsOfNodeDepths(root.left) + allKindsOfNodeDepths(root.right);
    }

    private static int getDepth(BinaryTree root, int depth) {
        if (root == null) return 0;
        return depth + getDepth(root.left, depth + 1) + getDepth(root.right, depth + 1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}

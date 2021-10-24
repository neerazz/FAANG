/**
 * Created on:  Sep 14, 2020
 * Questions: https://www.algoexpert.io/questions/Invert%20Binary%20Tree
 */
public class InvertBinaryTree {
    public static void main(String[] args) {

    }

    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null) return;
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
        BinaryTree temp = tree.right;
        tree.right = tree.left;
        tree.left = temp;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}

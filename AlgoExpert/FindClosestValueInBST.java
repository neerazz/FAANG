/**
 * Created on:  Aug 08, 2020
 * Questions: https://www.algoexpert.io/questions/Find%20Closest%20Value%20In%20BST
 */
public class FindClosestValueInBST {
    public static void main(String[] args) {

    }

    public static int findClosestValueInBst(BST tree, int target) {
        if (tree == null) return -1;
        return findClosestValueInBst(tree, target, tree.value);
    }

    public static int findClosestValueInBst(BST tree, int target, int closest) {
        closest = Math.abs(target - closest) < Math.abs(target - tree.value) ? closest : tree.value;
        if (tree.value < target && tree.right != null) {
            return findClosestValueInBst(tree.right, target, closest);
        } else if (tree.value > target && tree.left != null) {
            return findClosestValueInBst(tree.left, target, closest);
        }
        return closest;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}

/**
 * Created on:  Sep 10, 2021
 * Ref: https://www.techiedelight.com/update-every-key-bst-contain-sum-greater-keys/
 * <p>
 * Given a BST, modify it such that every key is updated to contain the sum of all greater keys
 * present in BST
 * <p>
 * 5
 * /   \
 * 3      8
 * /  \    /  \
 * 2     4  6   10
 * <p>
 * 29
 * /   \
 * 7      8
 * /  \    /  \
 * 2     4  6   10
 * <p>
 * Updated BST:
 * <p>
 * 29
 * /   \
 * 36     18
 * /  \    /  \
 * 38    33 24   10
 */
public class ModifyBinaryTree {
    static int sum = 0;

    public static void main(String[] args) {

    }

    public static Node modify(Node root) {
        if (root == null) return null;
        modify(root.right);
        sum += root.val;
        root.val = sum;
        modify(root.left);
        return root;
    }

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }

        public String toString() {
            return val + " " + left + " " + right;
        }
    }
}

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created on:  Aug 18, 2020
 * Questions: https://www.algoexpert.io/questions/Flatten%20Binary%20Tree
 */
public class FlattenBinaryTree {
    public static void main(String[] args) {

    }

    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        if (root == null) return null;
        BinaryTree op = new BinaryTree(-1), opRef = op, pre = null;
        Stack<BinaryTree> stack = new Stack<>();
        stack.add(root);
        Set<BinaryTree> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            BinaryTree pop = stack.pop();
            if (visited.contains(pop)) {
                opRef.right = pop;
                opRef.right.left = pre;
                opRef = opRef.right;
                pre = pop;
            } else {
                visited.add(pop);
                if (pop.right != null) stack.add(pop.right);
                stack.add(pop);
                if (pop.left != null) stack.add(pop.left);
            }
        }
        return op.right;
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on:  Jun 21, 2021
 * Ref: https://leetcode.com/problems/boundary-of-binary-tree/
 */

public class BoundaryOfBinaryTree {


    @ParameterizedTest
    @MethodSource("inputOutputValues")
    void runTest(TreeNode input, List<Integer> expected) {
        assertEquals(expected, boundaryOfBinaryTree(input));
    }

    static Stream<Arguments> inputOutputValues() {
//        Expected, actual
        return Stream.of(
                Arguments.of(BinaryTree.createTreeNode(1), Arrays.asList(1)),
                Arguments.of(BinaryTree.createTreeNode(1, 2, 9, 3, null, 5, 8, 4, null, null, null, 6, 7), Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)),
                Arguments.of(BinaryTree.createTreeNode(1, null, 2, 3, 4), Arrays.asList(1, 3, 4, 2)),
                Arguments.of(BinaryTree.createTreeNode(1, 2, 3, 4, 5, 6, null, null, null, 7, 8, 9, 10), Arrays.asList(1, 2, 4, 7, 8, 9, 10, 6, 3)),
                Arguments.of(BinaryTree.createTreeNode(1, 2, 7, 3, 5, null, 6, 4), Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);
        if (isLeaf(root)) return result;
        TreeNode cur = root.left;
//        Get Left boundary.
        while (cur != null) {
            if (!isLeaf(cur)) {
                result.add(cur.val);
            }
            cur = cur.left == null ? cur.right : cur.left;
        }
        getLeafBoundary(result, root);
//        Get Right boundary.
        cur = root.right;
        Stack<Integer> stack = new Stack<>();
        while (cur != null) {
            if (!isLeaf(cur)) {
                stack.add(cur.val);
            }
            cur = cur.right == null ? cur.left : cur.right;
        }
        while (!stack.isEmpty()) result.add(stack.pop());
        return result;
    }

    private static void getLeafBoundary(List<Integer> result, TreeNode root) {
        if (root == null) return;
        if (isLeaf(root)) {
            result.add(root.val);
        } else {
            getLeafBoundary(result, root.left);
            getLeafBoundary(result, root.right);
        }
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

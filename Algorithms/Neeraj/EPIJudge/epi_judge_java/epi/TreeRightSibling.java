package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightSibling {
    public static class BinaryTreeNode<T> extends TreeLike<T, BinaryTreeNode<T>> {
        public T data;
        public BinaryTreeNode<T> left, right;
        public BinaryTreeNode<T> next = null; // Populates this field.

        public BinaryTreeNode(T data) {
            this.data = data;
        }

        @Override
        public T getData() {
            return data;
        }

        @Override
        public BinaryTreeNode<T> getLeft() {
            return left;
        }

        @Override
        public BinaryTreeNode<T> getRight() {
            return right;
        }
    }

    public static void constructRightSibling(BinaryTreeNode<Integer> tree) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<BinaryTreeNode<Integer>> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> poll = queue.poll();
                if (poll != null && poll.left != null) level.add(poll.left);
                if (poll != null && poll.right != null) level.add(poll.right);
            }
            for (int i = 1; i < level.size(); i++) {
                level.get(i - 1).next = level.get(i);
            }
            queue.addAll(level);
        }
    }

    private static BinaryTreeNode<Integer>
    cloneTree(BinaryTree<Integer> original) {
        if (original == null) {
            return null;
        }
        BinaryTreeNode<Integer> cloned = new BinaryTreeNode<>(original.data);
        cloned.left = cloneTree(original.left);
        cloned.right = cloneTree(original.right);
        return cloned;
    }

    @EpiTest(testDataFile = "tree_right_sibling.tsv")
    public static List<List<Integer>>
    constructRightSiblingWrapper(TimedExecutor executor, BinaryTree<Integer> tree)
            throws Exception {
        BinaryTreeNode<Integer> cloned = cloneTree(tree);

        executor.run(() -> constructRightSibling(cloned));

        List<List<Integer>> result = new ArrayList<>();
        BinaryTreeNode<Integer> levelStart = cloned;
        while (levelStart != null) {
            List<Integer> level = new ArrayList<>();
            BinaryTreeNode<Integer> levelIt = levelStart;
            while (levelIt != null) {
                level.add(levelIt.data);
                levelIt = levelIt.next;
            }
            result.add(level);
            levelStart = levelStart.left;
        }
        return result;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "TreeRightSibling.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

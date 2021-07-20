import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on:  Jul 19, 2021
 * Ref : https://leetcode.com/problems/maximum-width-of-binary-tree/
 */
public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {

    }

    static int widthOfBinaryTree(TreeNode head) {
        int max = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(head, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int startIdx = queue.peek().idx;
            for (int i = 0; i < size; i++) {
                Pair poll = queue.poll();
                if (i == size - 1) {
                    max = Math.max(max, poll.idx - startIdx - 1);
                }
                int left = poll.idx * 2, right = poll.idx * 2 + 1;
                if (poll.node.left != null) queue.add(new Pair(poll.node.left, left));
                if (poll.node.right != null) queue.add(new Pair(poll.node.right, right));
            }
        }
        return max;
    }

    static class Pair {
        TreeNode node;
        int idx;

        Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

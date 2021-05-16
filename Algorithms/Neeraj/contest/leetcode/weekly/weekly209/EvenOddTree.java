package weekly.weekly209;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on:  Oct 03, 2020
 * Questions: https://leetcode.com/problems/even-odd-tree
 */
public class EvenOddTree {
    public static void main(String[] args) {

    }

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level ^= 1;
            Integer pre = null;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.val % 2 != level) return false;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
                if (pre == null) {
                    pre = poll.val;
                } else if (level == 1) {
//                    It should be strictly increasing
                    if (poll.val <= pre) return false;
                    pre = poll.val;
                } else {
//                    It should be strictly decreasing
                    if (poll.val >= pre) return false;
                    pre = poll.val;
                }
            }
        }
        return true;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

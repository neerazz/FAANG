import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on:  Jul 19, 2020
 * Questions: https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {

    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        if (root == null) return op;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        op.add(queue.getLast().val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            if (!queue.isEmpty()) op.add(queue.getLast().val);
        }

        return op;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}

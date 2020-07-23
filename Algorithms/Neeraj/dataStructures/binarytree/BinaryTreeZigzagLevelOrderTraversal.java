import java.util.*;

/**
 * Created on:  Jul 22, 2020
 * Questions: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> op = new ArrayList<>();
        if (root == null) return op;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                level.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            if (reverse) {
                Collections.reverse(level);
            }
            reverse ^= true;
            op.add(level);
        }

        return op;
    }
}

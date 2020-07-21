import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on:  Jul 20, 2020
 * Questions: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class VerticalOrderTraversalOfABinaryTree {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Map<Integer, List<Coordinates>> map = new HashMap<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(root);
        q2.add(1000);

        int min = 1000, max = 1000, level = 0;

        while (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q1.poll();
                int val = q2.poll();
                min = Math.min(min, val);
                max = Math.max(max, val);
                map.putIfAbsent(val, new ArrayList<>());
                map.get(val).add(new Coordinates(poll.val, level));
                if (poll.left != null) {
                    q1.add(poll.left);
                    q2.add(val - 1);
                }
                if (poll.right != null) {
                    q1.add(poll.right);
                    q2.add(val + 1);
                }
            }
            level++;
        }
        System.out.println(map);
        List<List<Integer>> op = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                op.add(map.get(i).stream().sorted((c1, c2) -> c1.level == c2.level ? Integer.compare(c1.val, c2.val) : Integer.compare(c1.level, c2.level)).map(c -> c.val).collect(Collectors.toList()));
            }
        }
        return op;
    }

    static class Coordinates {
        int val;
        int level;

        public Coordinates(int val, int level) {
            this.val = val;
            this.level = level;
        }
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

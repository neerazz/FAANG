import java.util.*;

/**
 * Crated on:  Apr 04, 2020
 */
public class VerticalOrderTraversalOfABinaryTree {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Coordinates> queue = new PriorityQueue<>((c1, c2) -> {
//            sort based on index, then on depth, and then on value
            if (c1.index != c2.index) return Integer.compare(c1.index, c2.index);
            if (c1.depth != c2.depth) return Integer.compare(c1.depth, c2.depth);
            return Integer.compare(c1.val, c2.val);
        });
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        performDFS(root, 0, 0, queue);
        while (!queue.isEmpty()) {
            Coordinates poll = queue.poll();
            map.putIfAbsent(poll.index, new ArrayList<>());
            map.get(poll.index).add(poll.val);
        }
        return new ArrayList<>(map.values());
    }

    private static void performDFS(TreeNode root, int index, int depth, PriorityQueue<Coordinates> queue) {
        if (root == null) return;
        queue.add(new Coordinates(index, depth, root.val));
        performDFS(root.left, index - 1, depth + 1, queue);
        performDFS(root.right, index + 1, depth + 1, queue);
    }

    static class Coordinates {
        int index;
        int depth;
        int val;

        public Coordinates(int index, int depth, int val) {
            this.index = index;
            this.depth = depth;
            this.val = val;
        }
    }
}

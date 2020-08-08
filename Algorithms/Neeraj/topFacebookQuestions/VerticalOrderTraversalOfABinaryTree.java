import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on:  Jul 20, 2020
 * Questions: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class VerticalOrderTraversalOfABinaryTree {
    public static void main(String[] args) {
        System.out.println(verticalTraversal_2(createTreeNode(Arrays.asList(3, 9, 20, null, null, 15, 7))));
        System.out.println(verticalTraversal_2(createTreeNode(Arrays.asList(1, 2, 3, 4, 5, 6, 7))));
    }

    public static TreeNode createTreeNode(List<Integer> nums) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        int index = 1;
        TreeNode treeNode = new TreeNode(nums.get(0));
        treeNodeQueue.add(treeNode);

        while (index < nums.size() && !treeNodeQueue.isEmpty()) {
            TreeNode peek = treeNodeQueue.poll();
            if (nums.get(index) != null) {
                TreeNode left = new TreeNode(nums.get(index++));
                peek.left = left;
                treeNodeQueue.add(left);
            } else index++;
            if (index < nums.size() && nums.get(index) != null) {
                TreeNode right = new TreeNode(nums.get(index++));
                peek.right = right;
                treeNodeQueue.add(right);
            } else index++;
        }
        return treeNode;
    }

    public static List<List<Integer>> verticalTraversal_2(TreeNode root) {
        Map<Integer, List<Cordinates>> map = new HashMap<>();
        if (root != null) {
//         0:x, 1:y
            Queue<int[]> q1 = new LinkedList<>();
            Queue<TreeNode> q2 = new LinkedList<>();
            q1.add(new int[]{0, 0});
            q2.add(root);
            while (!q1.isEmpty()) {
                int[] poll = q1.poll();
                TreeNode poll2 = q2.poll();
                map.computeIfAbsent(poll[0], val -> new ArrayList<>()).add(new Cordinates(poll[0], poll[1], poll2.val));
                if (poll2.left != null) {
                    q2.add(poll2.left);
                    q1.add(new int[]{poll[0] - 1, poll[1] - 1});
                }
                if (poll2.right != null) {
                    q2.add(poll2.right);
                    q1.add(new int[]{poll[0] + 1, poll[1] - 1});
                }
            }
        }
        System.out.println(map);
        return map.entrySet().stream()
                .sorted((e1, e2) -> e1.getKey() - e2.getKey())
                .map(entry -> entry.getValue().stream().sorted().map(c -> c.val).collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    static class Cordinates implements Comparable<Cordinates> {
        int x;
        int y;
        int val;

        public Cordinates(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Cordinates{" +
                    "x=" + x +
                    ", y=" + y +
                    ", val=" + val +
                    '}';
        }

        @Override
        public int compareTo(Cordinates o) {
            if (this.x == o.x) {
                if (this.y == o.y) return this.val - o.val;
                return o.y - this.y;
            }
            return o.x - this.x;
        }
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

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * Created on:  Oct 08, 2020
 * Questions: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */

public class SmallestSubtreeWithAllTheDeepestNodes {

    int max = 0;

    public static void main(String[] args) {

    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        Map<TreeNode, Integer> map = new HashMap<>();
        getDepth(root, 1, map);
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> maxLeafes = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == max)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        queue.addAll(maxLeafes);
        while (queue.size() > 1) {
            TreeNode poll1 = queue.poll();
            TreeNode poll2 = queue.poll();
            queue.add(getAnsistor(root, poll1, poll2));
        }
        return queue.poll();
    }

    private TreeNode getAnsistor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) return null;
        if (root == node1 || root == node2) return root;
        TreeNode left = getAnsistor(root.left, node1, node2);
        TreeNode right = getAnsistor(root.right, node1, node2);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        }
        return right;
    }

    private void getDepth(TreeNode root, int height, Map<TreeNode, Integer> map) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            map.put(root, height);
            max = Math.max(max, height);
        } else {
            getDepth(root.left, height + 1, map);
            getDepth(root.right, height + 1, map);
        }
    }
}

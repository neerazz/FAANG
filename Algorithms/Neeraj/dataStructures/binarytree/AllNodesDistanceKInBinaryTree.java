import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 16, 2021
 * Questions: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */

public class AllNodesDistanceKInBinaryTree {

    public static void main(String[] args) {

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        checkParent(root, null, parent);
        Set<Integer> result = new HashSet<>();
        Set<TreeNode> visited = new HashSet<>();
        dfs(target, 0, K, parent, result, visited);
        return new ArrayList<>(result);
    }

    private void dfs(TreeNode node, int dist, int k, Map<TreeNode, TreeNode> parent, Set<Integer> result, Set<TreeNode> visited) {
        if (node == null) return;
        if (visited.contains(node)) return;
        visited.add(node);
        if (dist == k) {
            result.add(node.val);
        } else {
            dfs(node.left, dist + 1, k, parent, result, visited);
            dfs(node.right, dist + 1, k, parent, result, visited);
            dfs(parent.get(node), dist + 1, k, parent, result, visited);
        }
        visited.remove(node);
    }

    private void checkParent(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (node == null) return;
        parent.put(node, par);
        checkParent(node.left, node, parent);
        checkParent(node.right, node, parent);
    }
}

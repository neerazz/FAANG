import java.util.*;

/**
 * Created on:  Aug 06, 2021
 * Ref : https://leetcode.com/problems/delete-nodes-and-return-forest/
 */
public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {

    }

    static LinkedHashMap<Integer, TreeNode> parents = new LinkedHashMap<>();
    static Map<Integer, TreeNode> map = new HashMap<>();
    static Set<Integer> visited = new HashSet<>();

    public static List<TreeNode> delNodes_rev1(TreeNode root, int[] to_delete) {
        dfs(root, null);
        for (int del : to_delete) {
            TreeNode parent = parents.get(del);
            TreeNode cur = map.get(del);
            if (parent != null) {
                if (parent.left == cur) parent.left = null;
                else parent.right = null;
            }
            visited.add(del);
        }
        List<TreeNode> result = new ArrayList<>();
        for (int key : parents.keySet()) {
            if (visited.contains(key)) continue;
            TreeNode cur = map.get(key);
            result.add(cur);
            explore(cur);
        }
        return result;
    }

    static void explore(TreeNode root) {
        if (root == null) return;
        visited.add(root.val);
        explore(root.left);
        explore(root.right);
    }

    static void dfs(TreeNode root, TreeNode parent) {
        if (root == null) return;
        parents.put(root.val, parent);
        map.put(root.val, root);
        dfs(root.left, root);
        dfs(root.right, root);
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int del : to_delete) set.add(del);
        boolean deleted = helper(root, set, result);
        if (!deleted) result.add(root);
        return result;
    }

    private static boolean helper(TreeNode root, Set<Integer> set, List<TreeNode> result) {
        if (root == null) return false;
        boolean left = helper(root.left, set, result);
        boolean right = helper(root.right, set, result);
        boolean delCur = set.contains(root.val);
        if (delCur) {
            if (!left && root.left != null) result.add(root.left);
            if (!right && root.right != null) result.add(root.right);
        }
        if (left) root.left = null;
        if (right) root.right = null;
        return delCur;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val +
                    ", left=" + left +
                    ", right=" + right;
        }
    }
}

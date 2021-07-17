package leetcode.v1.medium;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PseudoPalindromicPathsInABinaryTree {

    static int sol = 0;

    public static int pseudoPalindromicPaths(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        map.putIfAbsent(root.val, 0);
        map.put(root.val, map.get(root.val) + 1);
        createPath(root, map);
        return sol;
    }

    public static void createPath(TreeNode node, Map<Integer, Integer> map) {
        if (node.left == null && node.right == null) {
            map.putIfAbsent(node.val, 0);
            map.put(node.val, map.get(node.val) + 1);
            if (isPalindromeMap(map)) sol++;
        }
        if (node.left != null) {
            map.putIfAbsent(node.left.val, 0);
            map.put(node.left.val, map.get(node.left.val) + 1);
            createPath(node.left, map);
        }
        if (node.right != null) {
            map.putIfAbsent(node.right.val, 0);
            map.put(node.right.val, map.get(node.right.val) + 1);
            createPath(node.right, map);
        }
    }

    public static boolean isPalindromeMap(Map<Integer, Integer> map) {
        if (map.size() > 0 && map.size() <= 2) return true;
        int oddCount = 0;
        for (Integer val : map.values()) {
            if (val % 2 != 0) oddCount++;
        }
        return oddCount < 2;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode one = new TreeNode(3);
        TreeNode two = new TreeNode(1);
        one.left = new TreeNode(3);
        one.right = new TreeNode(1);
        two.left = null;
        two.right = new TreeNode(1);
        treeNode.left = one;
        treeNode.right = two;
        System.out.println(pseudoPalindromicPaths(treeNode));
    }
}



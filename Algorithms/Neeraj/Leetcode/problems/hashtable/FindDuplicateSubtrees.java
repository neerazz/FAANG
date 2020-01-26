package problems.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1127/
Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
Two trees are duplicate if they have the same structure with same node values.
Example 1:
        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:
      2
     /
    4
and
    4
Therefore, you need to return above trees' root in the form of a list.
 */
public class FindDuplicateSubtrees {
    static HashMap<String, Integer> map;
    static List<TreeNode> treeNodeHashSet;

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        one.left = two;
        one.right = three;
        two.left = new TreeNode(4);
        three.left = two;
        three.right = four;
        System.out.println(findDuplicateSubtrees(one));
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        treeNodeHashSet = new ArrayList<>();
        process(root);
        return treeNodeHashSet;
    }

    private static String process(TreeNode node) {
        if (node == null) return "$";
        String serial = node.val + "," + process(node.left) + "," + process(node.right);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2)
            treeNodeHashSet.add(node);
        return serial;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
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
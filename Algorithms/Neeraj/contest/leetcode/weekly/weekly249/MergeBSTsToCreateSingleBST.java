package weekly.weekly249;

import java.util.*;

/**
 * Created on:  Jul 17, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-249/problems/merge-bsts-to-create-single-bst/
 */
public class MergeBSTsToCreateSingleBST {
    static boolean impossible;
    static List<TreeNode> input;
    static Map<Integer, Integer> map;
    static boolean[] taken;

    public static void main(String[] args) {
        System.out.println(canMerge(Arrays.asList(new TreeNode(5, new TreeNode(4, null, null), null), new TreeNode(3, null, null))));
        System.out.println(canMerge(Arrays.asList(
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(3, new TreeNode(2), null))));
        System.out.println(canMerge(Arrays.asList(
                new TreeNode(10, new TreeNode(9), null),
                new TreeNode(9, new TreeNode(8), null),
                new TreeNode(8, new TreeNode(7), null))));
        System.out.println(canMerge(Arrays.asList(
                new TreeNode(1, null, new TreeNode(4)),
                new TreeNode(4, new TreeNode(3), null),
                new TreeNode(3, new TreeNode(2), null))));
    }

    public static TreeNode canMerge(List<TreeNode> trees) {
        impossible = false;
        int len = trees.size();
        taken = new boolean[len];
        map = new HashMap<>();
        Collections.sort(trees, (t1, t2) -> Integer.compare(t1.val, t2.val));
        input = trees;
        for (int i = 0; i < len; i++) {
            map.put(trees.get(i).val, i);
        }
        for (int i = 0; i < len; i++) {
            if (impossible) return null;
//            if (taken[i]) continue;
            findAndMerge(i, trees.get(i), null);
        }
        int left = 0;
        TreeNode result = null;
        for (int i = 0; i < len; i++) {
            if (!taken[i]) {
                left++;
                result = trees.get(i);
            }
        }
        return left == 1 ? result : null;
    }

    private static void findAndMerge(int idx, TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (impossible) return;
        if (node.left == null && node.right == null) {
//            Reached leaf, find for matching node.
            Integer matchingIdx = map.get(node.val);
            if (matchingIdx != null && matchingIdx != idx) {
                if (parent == null) {
                    input.set(idx, input.get(matchingIdx));
                } else if (parent.left == node) {
//                    This is left node to parent, then override the left of the parent
                    parent.left = input.get(matchingIdx);
                } else {
                    parent.right = input.get(matchingIdx);
                }
                if (isValidBST(input.get(idx), null, null)) {
                    taken[matchingIdx] = true;
                    map.remove(node.val);
                } else {
                    impossible = true;
                }
            }
        } else {
            findAndMerge(idx, node.left, node);
            findAndMerge(idx, node.right, node);
        }
    }

    private static boolean isValidBST(TreeNode tree, Integer min, Integer max) {
        if (tree == null) return true;
        if (min != null && tree.val <= min) return false;
        if (max != null && tree.val >= max) return false;
        return isValidBST(tree.left, min, tree.val) && isValidBST(tree.right, tree.val, max);
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(final int val) {
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

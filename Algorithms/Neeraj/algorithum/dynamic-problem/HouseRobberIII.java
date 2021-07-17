import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Nov 23, 2020
 * Questions: https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/567/week-4-november-22nd-november-28th/3541/
 */

public class HouseRobberIII {

    static Map<TreeNode, int[]> values = new HashMap<>();
    static Map<TreeNode, TreeNode> parents = new HashMap<>();
    static int max = 0;

    public static void main(String[] args) {

    }

    public static int rob(TreeNode root) {
        if (root == null) return 0;
//         Build the values map.
        buildValuesMap(root, null);
//         generate Max
        calculateMax(root, 0);
        return max;
    }

    private static void calculateMax(TreeNode node, int side) {
//         Get the max values by ignoring the current, and getting the values of all teh surroundings.
        if (node == null) return;
        int parent = 0;
        TreeNode par = parents.get(node);
        if (side == -1) {
//            If the cur node is left then get the parents right side.
            parent = values.get(par)[2];
        } else if (side == 1) {
//            If the cur node is right then get the best of left side.
            parent = values.get(par)[0];
        }
        int[] val = values.get(node);
        max = Math.max(max, val[0] + val[2] + parent);
        calculateMax(node.left, -1);
        calculateMax(node.right, 1);
    }

    private static int[] buildValuesMap(TreeNode node, TreeNode parent) {
//         0: left, 1:center, 2 : right
        if (node == null) return new int[3];
        int[] left = buildValuesMap(node.left, node), right = buildValuesMap(node.right, node);
        int pre = left[1] + right[1], pre2 = left[0] + left[2] + right[0] + right[2];
        int cur = Math.max(node.val + pre2, pre);
        max = Math.max(max, cur);
//        Set the current node value with best of. left side, cur, right side
        int[] result = new int[]{left[1], cur, right[1]};
        values.put(node, result);
        parents.put(node, parent);
        return result;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

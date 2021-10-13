import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on:  Oct 12, 2021
 * Ref: https://leetcode.com/problems/find-leaves-of-binary-tree/
 * <p>
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 * <p>
 * Collect all the leaf nodes.
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 * <p>
 * <p>
 * Example 1: https://assets.leetcode.com/uploads/2021/03/16/remleaves-tree.jpg
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5]
 * Output: [[4,5,3],[2],[1]]
 * Explanation:
 * [[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order on which elements are returned.
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 */
public class FindLeavesOfBinaryTree {
    public static void main(String[] args) {

    }

    static Map<Integer, List<Integer>> map;
    static int max;

    List<List<Integer>> findLeaves(TreeNode node) {
        max = 0;
        map = new HashMap<>();
        dfs(node);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            result.add(map.get(i));
        }
        return result;
    }

    int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left), right = dfs(node.right);
        int curLevel = Math.max(left, right);
        max = Math.max(max, curLevel + 1);
        add(node.val, curLevel);
        return curLevel + 1;
    }

    void add(int val, int level) {
        map.computeIfAbsent(level, value -> new ArrayList<>()).add(val);
    }
}

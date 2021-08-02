package blind75.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import util.TreeNode;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal/
F

Given the root of a binary tree, return the level order traversal of its
nodes' values. (i.e., from left to right, level by level).
  
Input: root = [3,9,20,null,null,15,7] 
Output: [[3],[9,20],[15,7]]
  
Example 2: 
Input: root = [1] 
Output: [[1]]
  
Example 3:
Input: root = []
Output: []
*/

public class BinaryTreeLevelOrderTraversal {

    /**
     * Level Traversal - Use Queue - Instantiate as ArrayDeque()
     * Get Queue Size and do all operations till the size is greater than zero.
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        if (root == null)
            return sol;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int levels = queue.size();
            while (levels-- > 0) {
                TreeNode innerNode = queue.poll();
                list.add(innerNode.val);
                if (innerNode.left != null)
                    queue.add(innerNode.left);
                if (innerNode.right != null)
                    queue.add(innerNode.right);
            }
            sol.add(list);
        }
        return sol;
    }

}

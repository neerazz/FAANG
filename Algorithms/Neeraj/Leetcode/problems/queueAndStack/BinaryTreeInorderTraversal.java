package problems.queueAndStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1383/
Given a binary tree, return the inorder traversal of its nodes' values.
Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println("Answer is: " + inorderTraversal(treeNode) + " should be [1,3,2].");
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (true) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    if (stack.isEmpty()) break;
                    root = stack.pop();
                    output.add(root.val);
                    root = root.right;
                }
            }
        }
        return output;
    }

    private static TreeNode createTreeNode(Integer[] nums, int index, TreeNode head) {
        if (index < nums.length && nums[index] != null) {
            TreeNode temp = new TreeNode(nums[index]);
            head = temp;
//            Insert into left child
            head.left = createTreeNode(nums, 2 * index + 1, head.left);
//            Insert into right child
            head.right = createTreeNode(nums, 2 * index + 2, head.right);
        }
        return head;
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
        return "val=" + val +
                ", left=" + left +
                ", right=" + right;
    }
}
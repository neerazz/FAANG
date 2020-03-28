import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Solution: https://www.youtube.com/watch?v=XV7Sg2hJO3Q
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode treeNode = createTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println("Answer is: " + isSymmetric(treeNode) + " should be [true].");
        treeNode = createTreeNode(new Integer[]{1, 2, 2, null, 3, null, 3});
        System.out.println("Answer is: " + isSymmetric(treeNode) + " should be [false].");
        treeNode = createTreeNode(new Integer[]{9, -42, -42, null, 76, 76, null, null, 13, null, 13});
        System.out.println("Answer is: " + isSymmetric(treeNode) + " should be [false].");
    }

    public static boolean isSymmetric(TreeNode root) {
        return root == null || checkSymmetric(root.left, root.right);
    }

    private static boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right != null)
            return left.val == right.val && checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
        return false;
    }

    public static boolean isSymmetric_iteratively_wrong(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
//            Loop through the same level and
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                TreeNode leftNode = poll != null ? poll.left : null;
                TreeNode rightNode = poll != null ? poll.right : null;
                queue.add(leftNode);
                queue.add(rightNode);
            }
            int start = 0, end = queue.size() - 1;
            while (start <= end) {
                if (queue.get(start) != null && queue.get(end) != null) {
                    if (queue.get(start).val != queue.get(end).val) return false;
                } else return queue.get(start) == null && queue.get(end) == null;
                start++;
                end--;
            }
        }
        return false;
    }
    public static TreeNode createTreeNode(Integer[] integers) {
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode head = null;
        int index = 0;
        while (index < integers.length) {
            if (nodes.isEmpty()) {
                Integer current = integers[index++];
                if (current != null) {
                    TreeNode treeNode = new TreeNode(current);
                    nodes.add(treeNode);
                    head = treeNode;
                }
            } else {
//                Create left and right child.
                TreeNode currentHead = nodes.poll();
//                Create left Child.
                Integer left = integers[index++];
                if (left != null) {
                    TreeNode treeNode = new TreeNode(left);
                    currentHead.left = treeNode;
                    nodes.add(treeNode);
                }
//                Create Right Child.
                Integer right = integers[index++];
                if (right != null) {
                    TreeNode treeNode = new TreeNode(right);
                    currentHead.right = treeNode;
                    nodes.add(treeNode);
                }
            }
        }
        return head;
    }
}

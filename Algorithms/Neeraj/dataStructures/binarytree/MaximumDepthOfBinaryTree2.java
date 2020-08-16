import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/*
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Note: A leaf is a node with no children.
Example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 */
public class MaximumDepthOfBinaryTree2 {
    public static void main(String[] args) {
        TraverseATree.TreeNode treeNode = TraverseATree.createTreeNode(new ArrayList<>(Arrays.asList(3, 9, 20, null, null, 15, 7)));
        System.out.println("Answer is :" + maxDepth(treeNode) + " should be [3].");
//        System.out.println("Answer is :" + minDepth(treeNode) + " should be [2].");
        treeNode = TraverseATree.createTreeNode(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println("Answer is :" + maxDepth(treeNode) + " should be [3].");
        System.out.println("Answer is :" + minDepth(treeNode) + " should be [2].");
    }

    public static int minDepth(TraverseATree.TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TraverseATree.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TraverseATree.TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return depth;
    }

    public static int maxDepth(TraverseATree.TreeNode root) {
        return maxDepthHelper(root, 0);
    }

    private static int maxDepthHelper(TraverseATree.TreeNode root, int output) {
        if (root == null) return output;
        int left = maxDepthHelper(root.left, output + 1);
        int right = maxDepthHelper(root.right, output + 1);
        return Math.max(left, right);
    }
}

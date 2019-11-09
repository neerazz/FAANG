import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 For example:
 Given binary tree [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7

 return its level order traversal as:

 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        levelOrder(root).forEach(e -> System.out.print(e + " "));
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) return levels;
        queue.addLast(root);
        int level = 0;
        while (!queue.isEmpty()) {
            levels.add(new ArrayList<>());
            int noOfElements = queue.size();
            for (int i = 0; i < noOfElements; ++i) {
                TreeNode node = queue.pollFirst();
                levels.get(level).add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            level++;
        }
        return levels;
    }

    //TODO: Write recursion method for this

}

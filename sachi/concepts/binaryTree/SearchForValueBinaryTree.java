import java.util.Deque;
import java.util.LinkedList;

public class SearchForValueBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        Util.print(root);
        System.out.println(isElementFound(root, 8));
    }

    private static boolean isElementFound(TreeNode root, int num) {
        if (root == null) return false;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (node.val == num) return true;
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
        }
        return false;
    }
}

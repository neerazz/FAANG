import java.util.*;

public class CousinsInBinaryTreeII {

    public static void main(String[] args) {
        TreeNode treeNode = BinaryTree.createTreeNode(33, 37, 42, null, null, null, 46);
        TreeNode result = replaceValueInTree(treeNode);
        System.out.println("result = " + result);
    }

    public static TreeNode replaceValueInTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            map.put(level++, sum);
        }

        queue.add(root);
        level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode poll = queue.poll();
//                At each node you set the nextLevelSum value of the child nodes, by reducing the nextLevelSum of values
                int nextLevelSum = 0;
                if (level <= 1) {
                    poll.val = 0;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                    nextLevelSum += poll.left.val;
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                    nextLevelSum += poll.right.val;
                }

                if (poll.left != null) poll.left.val = map.get(level + 1) - nextLevelSum;
                if (poll.right != null) poll.right.val = map.get(level + 1) - nextLevelSum;
            }
            level++;
        }

        return root;
    }

}

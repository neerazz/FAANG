import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on:  Jul 19, 2020
 * Questions: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode deserialize = codec.deserialize("5,2,3,null,null,2,4,3,1");
        System.out.println(deserialize);
        System.out.println("serialize = " + codec.serialize(deserialize));
    }

    static class Codec {

        public static final String NULL = "null";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                StringBuilder level = new StringBuilder();
                boolean allNull = true;
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (poll != null) {
                        allNull = false;
                        queue.add(poll.left);
                        queue.add(poll.right);
                    }
                    level.append(poll == null ? NULL : poll.val).append(",");
                }
                if (!allNull) sb.append(level);
                else break;
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("")) return null;
            String[] split = data.split(",");
            TreeNode head = new TreeNode(Integer.parseInt(split[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(head);
            int i = 1, len = split.length;
            while (i < len) {
                String first = split[i++], second = split[i++];
                TreeNode poll = queue.poll();
                if (poll != null && !first.equals(NULL)) {
                    poll.left = new TreeNode(Integer.parseInt(first));
                    queue.add(poll.left);
                }
                if (poll != null && !second.equals(NULL)) {
                    poll.right = new TreeNode(Integer.parseInt(second));
                    queue.add(poll.right);
                }
            }

            return head;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
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

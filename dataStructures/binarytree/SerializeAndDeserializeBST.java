import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created on:  Oct 09, 2020
 * Questions: https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3489/
 */

public class SerializeAndDeserializeBST {

    public static void main(String[] args) {

    }

    static class Codec {

    /*
            3
           /
          1
         / \
        0   2

        3,
        List = [3,1,null,0,2]
        queue = []
        hasvalue = false

        Deserelize:
            [3,1,null,0,2]
                        i
            split,by removing braces
            3
           / \
          1
         / \
        0   2
        queue:[1]

    */

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            list.add(root.val);
            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean hasValue = false;
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (poll.left != null) {
                        hasValue = true;
                        queue.add(poll.left);
                        level.add(poll.left.val);
                    } else level.add(null);
                    if (poll.right != null) {
                        hasValue = true;
                        queue.add(poll.right);
                        level.add(poll.right.val);
                    } else level.add(null);
                }
                if (hasValue) {
                    list.addAll(level);
                }
            }
            return list.toString();
        }

        /*

                [6,5,7,3,4,null,8]
                                i
                6
               / \
              5   7
             3 4   8
                queue = [6,7,3,4]
                           p
        */
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("")) return null;
            String[] split = data.substring(1, data.length() - 1).split(",");
            int idx = 0, len = split.length;
            TreeNode root = getTreeNode(split[idx++]);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (idx < len) {
                TreeNode poll = queue.poll();
                TreeNode left = getTreeNode(split[idx++]);
                TreeNode right = getTreeNode(split[idx++]);
                if (left != null) {
                    poll.left = left;
                    queue.add(left);
                }
                if (right != null) {
                    poll.right = right;
                    queue.add(right);
                }
            }

            return root;
        }

        private TreeNode getTreeNode(String val) {
            if (val == null || val.trim().equals("null")) return null;
            return new TreeNode(Integer.parseInt(val.trim()));
        }
    }
}

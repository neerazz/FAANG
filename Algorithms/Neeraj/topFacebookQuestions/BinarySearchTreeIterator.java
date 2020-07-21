import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Jul 19, 2020
 * Questions: https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BinarySearchTreeIterator {
    public static void main(String[] args) {

    }

    static class BSTIterator {

        List<Integer> list;
        int index;

        public BSTIterator(TreeNode root) {
            index = 0;
            list = new ArrayList<>();
            dfs(root);
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return list.get(index++);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return list.size() > index;
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

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Given two binary trees, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
Example 1:
Input:     1         1
          / \       / \
         2   3     2   3
        [1,2,3],   [1,2,3]
Output: true
Example 2:
Input:     1         1
          /           \
         2             2
        [1,2],     [1,null,2]
Output: false
Example 3:
Input:     1         1
          / \       / \
         2   1     1   2
        [1,2,1],   [1,1,2]
Output: false
 */
public class SameTree {
    public static void main(String[] args) {
        System.out.println(isSameTree(createTree(new Integer[]{1, 2, 3}), createTree(new Integer[]{1, 2, 3})));
        System.out.println(isSameTree(createTree(new Integer[]{1, 2}), createTree(new Integer[]{1, null, 2})));
        System.out.println(isSameTree(createTree(new Integer[]{1, 1, 2}), createTree(new Integer[]{1, 2, 1})));
        System.out.println(isSameTree(createTree(new Integer[]{12, null, -60}), createTree(new Integer[]{12, null, 72})));
        System.out.println("=============================================================");
        System.out.println(isSameTree_iterative(createTree(new Integer[]{1, 2, 3}), createTree(new Integer[]{1, 2, 3})));
        System.out.println(isSameTree_iterative(createTree(new Integer[]{1, 2}), createTree(new Integer[]{1, null, 2})));
        System.out.println(isSameTree_iterative(createTree(new Integer[]{1, 1, 2}), createTree(new Integer[]{1, 2, 1})));
        System.out.println(isSameTree_iterative(createTree(new Integer[]{12, null, -60}), createTree(new Integer[]{12, null, 72})));
    }

    private static TreeNode createTree(Integer[] integers) {
        if (integers.length == 0) return null;
        int index = 0;
        TreeNode treeNode = new TreeNode(integers[index++]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (index < integers.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
//                Create left and right child.
                TreeNode currentHead = queue.poll();
//                Create left Child.
                Integer left = integers[index++];
                if (left != null) {
                    TreeNode currentTree = new TreeNode(left);
                    currentHead.left = currentTree;
                    queue.add(currentTree);
                }
                if (index == integers.length) break;
//                Create Right Child.
                Integer right = integers[index++];
                if (right != null) {
                    TreeNode currentTree = new TreeNode(right);
                    currentHead.right = currentTree;
                    queue.add(currentTree);
                }
            }
        }
        return treeNode;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }

    public static boolean isSameTree_iterative(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.add(p);
        qQueue.add(q);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pPoll = pQueue.poll();
            TreeNode qPoll = qQueue.poll();
            if (pPoll == null && qPoll == null) {
                continue;
            } else if (pPoll != null && qPoll != null) {
                if (pPoll.val != qPoll.val) return false;
                pQueue.addAll(Arrays.asList(pPoll.left, pPoll.right));
                qQueue.addAll(Arrays.asList(qPoll.left, qPoll.right));
            } else {
                return false;
            }
        }
        return pQueue.isEmpty() && qQueue.isEmpty();
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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
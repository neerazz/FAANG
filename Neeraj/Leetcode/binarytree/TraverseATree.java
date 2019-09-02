package binarytree;

import java.util.*;

/*
Example:
Input: [1,null,2,3]
   1
    \
     2
    /
   3
PreOrder Traversal Output: [1,2,3]
InOrder Traversal Output: [1,3,2]
PostOrder Traversal Output: [3,2,1]
 */
public class TraverseATree {
    public static void main(String[] args) {
        TreeNode treeNode = createTreeNode(new ArrayList<>(Arrays.asList(3, 9, 20, null, null, 15, 7)));
        System.out.println("Actual Node\t:" + treeNode);
        System.out.println("PreOrder   \t:" + preorderTraversal(treeNode));
        System.out.println("InOrder    \t:" + inorderTraversal(treeNode));
        System.out.println("PostOrder  \t:" + postorderTraversal(treeNode));
        System.out.println("LevelOrder \t:" + levelOrder(treeNode));
    }

    public static TreeNode createTreeNode(ArrayList<Integer> nums) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        int index = 1;
        TreeNode treeNode = new TreeNode(nums.get(0));
        treeNodeQueue.add(treeNode);

        while (index < nums.size() && !treeNodeQueue.isEmpty()) {
            TreeNode peek = treeNodeQueue.poll();
            if (nums.get(index) != null) {
                TreeNode left = new TreeNode(nums.get(index++));
                peek.left = left;
                treeNodeQueue.add(left);
            } else index++;
            if (index < nums.size() && nums.get(index) != null) {
                TreeNode right = new TreeNode(nums.get(index++));
                peek.right = right;
                treeNodeQueue.add(right);
            } else index++;
        }
        return treeNode;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        output.add(root.val);
        output.addAll(preorderTraversal(root.left));
        output.addAll(preorderTraversal(root.right));
        return output;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        output.addAll(inorderTraversal(root.left));
        output.add(root.val);
        output.addAll(inorderTraversal(root.right));
        return output;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        output.addAll(postorderTraversal(root.left));
        output.addAll(postorderTraversal(root.right));
        output.add(root.val);
        return output;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ouput = new ArrayList<>();
        if (root == null) return ouput;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                level.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            ouput.add(level);
        }
        return ouput;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val +
                ", left=" + left +
                ", right=" + right;
    }
}
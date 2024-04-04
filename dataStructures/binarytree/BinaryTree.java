import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on:  Jun 21, 2021
 */

public class BinaryTree {

    public static void main(String[] args) {

    }

    public static TreeNode createTreeNode(Integer... nums) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        int index = 1;
        TreeNode treeNode = new TreeNode(nums[0]);
        treeNodeQueue.add(treeNode);

        while (index < nums.length && !treeNodeQueue.isEmpty()) {
            TreeNode peek = treeNodeQueue.poll();
            if (nums[index] != null) {
                TreeNode left = new TreeNode(nums[index++]);
                peek.left = left;
                treeNodeQueue.add(left);
            } else index++;
            if (index < nums.length && nums[index] != null) {
                TreeNode right = new TreeNode(nums[index++]);
                peek.right = right;
                treeNodeQueue.add(right);
            } else index++;
        }
        return treeNode;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return val +
                ", left=" + left +
                ", right=" + right;
    }
}
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created on:  Aug 08, 2020
 * Questions: https://leetcode.com/problems/path-sum-iii/
 */
public class PathSumIII {

    public static void main(String[] args) {
        System.out.println(pathSum(createTreeNode(Arrays.asList(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1)), 8) + " = 3");
        System.out.println(pathSum(createTreeNode(Arrays.asList(1, -2, -3, 1, 3, -2, null, -1)), -1) + " = 4");
    }

    public static TreeNode createTreeNode(List<Integer> nums) {
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

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return checkSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private static int checkSum(TreeNode root, int val) {
        if (root == null) return 0;
        int cur = root.val == val ? 1 : 0;
        cur += checkSum(root.left, val - root.val);
        cur += checkSum(root.right, val - root.val);
        return cur;
    }
}

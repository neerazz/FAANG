package weekly.weekly174;

import java.util.*;

/*
https://leetcode.com/contest/weekly-contest-174/problems/maximum-product-of-splitted-binary-tree/
 */
public class MaximumProductOfSplittedBinaryTree {
    public static void main(String[] args) {
        System.out.println(maxProduct(createTreeNode(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))));
        System.out.println(maxProduct(createTreeNode(new ArrayList<>(Arrays.asList(1, null, 2, 3, 4, null, null, 5, 6)))));
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

    public static int maxProduct_wrong(TreeNode root) {
//        Perform an Inorder traversal.
        List<Integer> integers = inOrderTraversal(root, new ArrayList<>());
        int[] sums = new int[integers.size()];
        int total = 0, product = Integer.MIN_VALUE;
        for (int i = 0; i < integers.size(); i++) {
            total += integers.get(i);
            sums[i] = total;
        }
        for (int i = 0; i < sums.length; i++) {
            product = Math.max(product, sums[i] * (total - sums[i]));
        }
        return product;
    }

    private static List<Integer> inOrderTraversal(TreeNode root, ArrayList<Integer> numbers) {
        if (root == null) {
            return numbers;
        }
        if (root.left != null) {
            numbers.addAll(Objects.requireNonNull(inOrderTraversal(root.left, new ArrayList<>())));
        }
        numbers.add(root.val);
        if (root.right != null) {
            numbers.addAll(Objects.requireNonNull(inOrderTraversal(root.right, new ArrayList<>())));
        }
        return numbers;
    }

    /*
    Got the solution:
        Write a sub function s(TreeNode root) to get the sum of a sub tree.
        s is short for sub and sum.
        First pass, get the toal sum.
        Now we have the right total sum of the whole tree.
        Second pass, find the biggest product.
     */
    static long res = 0, total = 0, sub;
    public static int maxProduct(TreeNode root) {
        total = s(root); s(root);
        return (int)(res % (int)(1e9 + 7));
    }

    private static long s(TreeNode root) {
        if (root == null) return 0;
        sub = root.val + s(root.left) + s(root.right);
        res = Math.max(res, sub * (total - sub));
        return sub;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

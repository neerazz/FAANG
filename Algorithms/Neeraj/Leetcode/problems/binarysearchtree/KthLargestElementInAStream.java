package problems.binarysearchtree;

import java.util.ArrayList;

/*
https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/142/conclusion/1018/
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
Example:
int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
Note:
You may assume that nums' length ≥ k-1 and k ≥ 1.
 */
public class KthLargestElementInAStream {
    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3) + " should be 4");
        System.out.println(kthLargest.add(5) + " should be 5");
        System.out.println(kthLargest.add(10) + " should be 5");
        System.out.println(kthLargest.add(9) + " should be 8");
        System.out.println(kthLargest.add(4) + " should be 8");

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        kthLargest = new KthLargest(1, new int[0]);
        System.out.println(kthLargest.add(-3) + " should be -3");
        System.out.println(kthLargest.add(-2) + " should be -2");
        System.out.println(kthLargest.add(-4) + " should be -2");
        System.out.println(kthLargest.add(0) + " should be 0");
        System.out.println(kthLargest.add(4) + " should be 4");

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

        kthLargest = new KthLargest(3, new int[]{1, 1});
        System.out.println(kthLargest.add(1) + " should be 1");
        System.out.println(kthLargest.add(1) + " should be 1");
        System.out.println(kthLargest.add(3) + " should be 1");
        System.out.println(kthLargest.add(3) + " should be 1");
        System.out.println(kthLargest.add(3) + " should be 3");
        System.out.println(kthLargest.add(4) + " should be 3");
        System.out.println(kthLargest.add(4) + " should be 3");
        System.out.println(kthLargest.add(4) + " should be 4");
    }
}

class KthLargest {
    int k;
    TreeNode root;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) root = add(root, num);
    }

    public int add(int val) {
        root = add(root, val);
        return findKthLargest(root, k);
    }

    private TreeNode add(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        root.subtreeSize++;
        if (val < root.val) root.left = add(root.left, val);
        else root.right = add(root.right, val);

        return root;
    }

    public int findKthLargest(TreeNode node, int k) {
        int targetSizeOfRightSubtree = k - 1;
        int sizeOfRightSubtree = node.right != null ? node.right.subtreeSize : 0;
        if (sizeOfRightSubtree == targetSizeOfRightSubtree) {
            return node.val;
        }

        if (targetSizeOfRightSubtree > sizeOfRightSubtree) {
            return findKthLargest(node.left, targetSizeOfRightSubtree - sizeOfRightSubtree);
        }

        return findKthLargest(node.right, k);
    }

    class TreeNode {
        int val;
        int subtreeSize;
        TreeNode left;
        TreeNode right;

        TreeNode(int _val_) {
            val = _val_;
            subtreeSize = 1;
        }
    }
}

class KthLargest_BrootForce {

    TreeNode node = null;
    ArrayList<Integer> nodes = null;
    int index = 0;

    public KthLargest_BrootForce(int k, int[] nums) {
        this.index = k;
        if (nums.length > 0) {
            node = new TreeNode(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                add(node, nums[i]);
            }
        }
    }

    public TreeNode add(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = add(root.left, val);
        else root.right = add(root.right, val);
        return root;
    }

    public int add(int val) {
        node = add(node, val);
        nodes = new ArrayList<>();
        performInOrderTraversal(node);
        return nodes.get(nodes.size() - index);
    }

    private void performInOrderTraversal(TreeNode root) {
        if (root == null) return;
        if (root.left != null) performInOrderTraversal(root.left);
        nodes.add(root.val);
        if (root.right != null) performInOrderTraversal(root.right);
    }
}
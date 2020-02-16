package revision;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BinarySearchTree {
    public static void main(String[] args) {
//        System.out.println(isValidBST(createTreeNode(new Integer[]{5, 1, 4, null, null, 3, 6})));
//        System.out.println(isValidBST(createTreeNode(new Integer[]{2,1,3})));
//        BSTIterator bstIterator = new BSTIterator(createTreeNode(new Integer[]{7,3,15,null,null,9,20}));
//        KthLargest kthLargest = new KthLargest(3,new int[]{4,5,8,2});
//        System.out.println(kthLargest.add(3));
//        System.out.println(kthLargest.add(5));
//        System.out.println(lowestCommonAncestor(createTreeNode(new Integer[]{6,2,8,0,4,7,9,null,null,3,5,null,null,null,null}), new TreeNode(2),new TreeNode(8)));
//        System.out.println(containsNearbyAlmostDuplicate(new int[]{2,2},3,0));
//        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9},2,3));
//        System.out.println(isBalanced(createTreeNode(new Integer[]{3,9,20,null,null,15,7})));
//        System.out.println(isBalanced(createTreeNode(new Integer[]{1,2,2,3,3,null,null,4,4,null,null,null,null,null,null})));
        System.out.println(sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0){
            return null;
        }
        int mid = length/2;
        TreeNode midNode = new TreeNode(nums[mid]);
        if (mid > 0){
            midNode.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
            midNode.right = sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,length));
        }
        return midNode;
    }

    static boolean isBalanced = true;
    public static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        isBalanced_Helper(root,0);
        return isBalanced;
    }

    private static int isBalanced_Helper(TreeNode root, int count) {
        if (root == null){
            return count;
        }
        int left = isBalanced_Helper(root.left,count);
        int right = isBalanced_Helper(root.right, count);
        count++;
        if (Math.abs(left - right) > 1){
            isBalanced = false;
        }
        return count + Math.max(left,right);
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= Math.min(i + k, nums.length - 1); j++) {
                long diff = Math.abs((long) nums[i] - (long) nums[j]);
                if (diff <= t)
                    return true;
            }
        }
        return false;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null ){
            return null;
        }
        if (root.val == key){
//            There are 3 different case while deleting.
            if (root.left == null && root.right == null){
//                Then this is the leaf node. IT can be deleted easily.
                return null;
            }else if (root.left != null && root.right == null){
//                One side of the node is empty. Then just return the non empty side of it.
                return root.left;
            }else if (root.right != null && root.left == null){
                return root.right;
            }else {
//                Value is present in both the sides. Then go to the lowest value at the right and swap with current value.
                int lowest = findLowestValue(root.right);
                TreeNode newLowestDeletedNode = deleteNode(root,lowest);
                newLowestDeletedNode.val = lowest;
                return newLowestDeletedNode;
            }
        }
        if (root.val > key){
            root.left = deleteNode(root.left,key);
        }else {
            root.right = deleteNode(root.right,key);
        }
        return root;
    }

    private static int findLowestValue(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        if (node.left != null){
            return findLowestValue(node.left);
        }
        return node.val;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null){
            return newNode;
        }
        if (root.val > val){
            root.left = insertIntoBST(root.left,val);
        }else {
            root.right = insertIntoBST(root.right,val);
        }
        return root;
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val){
            return root;
        }
        if (root.val > val){
            return searchBST(root.left,val);
        }else {
            return searchBST(root.right,val);
        }
    }

    public static TreeNode createTreeNode(Integer[] integers) {
        if (integers != null && integers.length > 0) {
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode result = new TreeNode(integers[0]), resultRef = result;
            queue.add(result);
            for (int i = 1; i < integers.length; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    if (integers[i] != null) {
                        TreeNode newNode = new TreeNode(integers[i]);
                        poll.left = newNode;
                        queue.add(newNode);
                    }
                    i++;
                    if (integers[i] != null) {
                        TreeNode newNode = new TreeNode(integers[i]);
                        poll.right = newNode;
                        queue.add(newNode);
                    }
                }
            }
            return resultRef;
        }
        return null;
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        return isValidBSTWithMinAndMax(root,null,null);
    }

    private static boolean isValidBSTWithMinAndMax(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        return isValidBSTWithMinAndMax(root.left,min,root.val) && isValidBSTWithMinAndMax(root.right, root.val, max);
    }
}

class BSTIterator {

    LinkedList<Integer> list = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        performInOrderTreversal(root);
    }

    private void performInOrderTreversal(TreeNode root) {
        if (root == null) {
            return;
        }
        performInOrderTreversal(root.left);
        list.add(root.val);
        performInOrderTreversal(root.right);
    }

    /** @return the next smallest number */
    public int next() {
        return list.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !list.isEmpty();
    }
}

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.add(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}
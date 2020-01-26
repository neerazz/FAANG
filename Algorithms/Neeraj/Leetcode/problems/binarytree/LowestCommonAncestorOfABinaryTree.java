package problems.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static problems.binarytree.TraverseATree.createTreeNode;

/*
https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/932/

 */
public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = createTreeNode(new ArrayList<>(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)));
        System.out.println("Answer is: " + lowestCommonAncestor(treeNode, new TreeNode(5), new TreeNode(1)) + " should be [3].");
        System.out.println("Answer is: " + lowestCommonAncestor(treeNode, new TreeNode(5), new TreeNode(4)) + " should be [5].");
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        List<Integer> pathToP = new ArrayList<>();
        List<Integer> pathToQ = new ArrayList<>();
        if (findPath(root, p, pathToP) && findPath(root, q, pathToQ)) return findLowestCommonAncestor(pathToP, pathToQ);
        return null;
    }

    private static TreeNode findLowestCommonAncestor(List<Integer> pathToP, List<Integer> pathToQ) {
        for (int i = 0; i < pathToP.size(); i++) {
            if (pathToQ.contains(pathToP.get(i))) return new TreeNode(pathToP.get(i));
        }
        return null;
    }

    private static boolean findPath(TreeNode root, TreeNode p, List<Integer> pathList) {
        if (root == null) return false;
        if (root.val == p.val) {
            pathList.add(root.val);
            return true;
        }
        if (findPath(root.left, p, pathList)) {
            pathList.add(root.val);
            return true;
        }
        if (findPath(root.right, p, pathList)) {
            pathList.add(root.val);
            return true;
        }
        return false;
    }

    public TreeNode lowestCommonAncestor_elegent(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor_elegent(root.left, p, q);
        TreeNode right = lowestCommonAncestor_elegent(root.right, p, q);
        if (left != null) {
            if (right != null) return root;
            return left;
        }
        return right;
    }
}

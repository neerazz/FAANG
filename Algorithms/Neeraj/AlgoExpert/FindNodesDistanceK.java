import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 25, 2021
 * Questions:
 * You're given the root node of a Binary Tree, a target value of a node that's contained in the tree, and a positive integer k. Write a function that returns the values of all the nodes that are exactly distance k from the node with target value.
 * <p>
 * The distance between two nodes is defined as the number of edges that must be traversed to go from one node to the other. For example, the distance between a node and its immediate left or right child is 1. The same holds in reverse: the distance between a node and its parent is 1. In a tree of three nodes where the root node has a left and right child, the left and right children are distance 2 from each other.
 * <p>
 * Each BinaryTree node has an integer value, a left child node, and a right child node. Children nodes can either be BinaryTree nodes themselves or None / null.
 * <p>
 * Note that all BinaryTree node values will be unique, and your function can return the output values in any order.
 * <p>
 * Sample Input
 * tree = 1
 * /   \
 * 2     3
 * /   \     \
 * 4     5     6
 * /   \
 * 7     8
 * target = 3
 * k = 2
 * Sample Output
 * [2, 7, 8] // These values could be ordered differently.
 */

public class FindNodesDistanceK {

    public static void main(String[] args) {

    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static List<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        Map<BinaryTree, BinaryTree> parents = new HashMap<>();
        buildParent(tree, null, parents);
        Set<Integer> result = new HashSet<>();
        BinaryTree node = findTarget(tree, target);
        findNodes(node, null, 0, k, parents, result);
        return new ArrayList<>(result);
    }

    private static void findNodes(BinaryTree node, BinaryTree parent, int d, int k, Map<BinaryTree, BinaryTree> map, Set<Integer> result) {
        if (node == null) return;
        if (d == k) {
            result.add(node.value);
        } else {
// 			Span in three directs, with d+1.
            if (node.left != parent) findNodes(node.left, node, d + 1, k, map, result);
            if (node.right != parent) findNodes(node.right, node, d + 1, k, map, result);
            BinaryTree par = map.get(node);
            if (par != null && par != parent) findNodes(par, node, d + 1, k, map, result);
        }
    }

    private static BinaryTree findTarget(BinaryTree node, int target) {
        if (node == null) return null;
        if (node.value == target) return node;
        BinaryTree left = findTarget(node.left, target);
        if (left != null) return left;
        return findTarget(node.right, target);
    }

    private static void buildParent(BinaryTree node, BinaryTree parent, Map<BinaryTree, BinaryTree> map) {
        if (node == null) return;
        map.put(node, parent);
        buildParent(node.left, node, map);
        buildParent(node.right, node, map);
    }
}

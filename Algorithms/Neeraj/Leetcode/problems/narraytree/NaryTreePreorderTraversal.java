package problems.narraytree;

import java.util.*;

/*
https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/925/
Given an n-ary tree, return the preorder traversal of its nodes' values.
For example, given a 3-ary tree:
Return its preorder traversal as: [1,3,5,6,2,4].
Note:
Recursive solution is trivial, could you do it iteratively?
 */
public class NaryTreePreorderTraversal {
    public static void main(String[] args) {
        Node node = new Node();
        Node node3 = new Node(), node2 = new Node(), node4 = new Node(), node5 = new Node(), node6 = new Node();
        node.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;
        node5.val = 5;
        node6.val = 6;
        node3.children = Arrays.asList(node5, node6);
        node.children = Arrays.asList(node3, node2, node4);
        System.out.println("Answer is :" + preorder(node));
    }

    private static List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            if (node.children != null) {
                Collections.reverse(node.children);
                for (Node item : node.children) {
                    stack.add(item);
                }
            }
        }
        return output;
    }

    public static List<Integer> preorder_Recursive(Node root) {
        List<Integer> output = new ArrayList<>();
        if (root == null) return output;
        output.add(root.val);
        for (Node n : root.children) {
            output.addAll(preorder_Recursive(n));
        }
        return output;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", children=" + children +
                '}';
    }
}
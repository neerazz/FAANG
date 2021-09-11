import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/925/
Given an n-ary tree, return the postorder traversal of its nodes' values.
For example, given a 3-ary tree:
Return its postorder traversal as: [5,6,3,2,4,1].
Note:
Recursive solution is trivial, could you do it iteratively?
 */
public class NaryTreePostorderTraversal {
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
        System.out.println("Answer is :" + postorder_Recursive(node));
        System.out.println("Answer is :" + postorder_Iterative(node));
    }

    private static List<Integer> postorder_Iterative(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(node.val);
            if (node.children != null) {
                stack.addAll(node.children);
            }
        }
        return output;
    }

    public static List<Integer> postorder_Recursive(Node root) {
        List<Integer> output = new ArrayList<>();
        if (root == null) return output;
        if (root.children != null) {
            for (Node n : root.children) {
                output.addAll(postorder_Recursive(n));
            }
        }
        output.add(root.val);
        return output;
    }

    static class Node {
        Integer val;
        List<Node> children;

        public Node() {
        }

        public Node(int value) {
            this.val = value;
        }
    }
}
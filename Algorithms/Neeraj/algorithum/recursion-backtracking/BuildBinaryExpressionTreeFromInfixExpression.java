import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 06, 2021
 * Questions: https://leetcode.com/problems/build-binary-expression-tree-from-infix-expression/
 */

public class BuildBinaryExpressionTreeFromInfixExpression {

    public static void main(String[] args) {
        System.out.println(expTree("3*4-2*5"));
        System.out.println(expTree("2-3/(5*2)+1"));
    }

    public static Node expTree(String s) {
        Deque<Node> nodes = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                nodes.add(new Node(cur));
            } else if (cur == '(') {
//                Loop through the balanced end of ).
                int count = 1, start = i + 1, end = start;
                while (end < s.length()) {
                    cur = s.charAt(end++);
                    if (cur == '(') count++;
                    else if (cur == ')') count--;
                    if (count == 0) break;
                }
                Node temp = expTree(s.substring(start, end - 1));
                if (temp != null) nodes.add(temp);
                i = end - 1;
            } else {
//                This is a symbol
                nodes.add(new Node(cur));
            }
        }
//        Process the * and /
        Deque<Node> nodes1 = process(nodes, '*', '/');
//        Process the + and -
        Deque<Node> nodes2 = process(nodes1, '+', '-');
        return nodes2.peek();
    }

    private static Deque<Node> process(Deque<Node> nodes, char c1, char c2) {
        Deque<Node> current = new LinkedList<>();
        while (!nodes.isEmpty()) {
            Node poll = nodes.poll();
            if (poll.left == null && (poll.val == c1 || poll.val == c2)) {
//                Since we are processing from left to right, always check for the node, it should not have left.
                poll.left = current.pollLast();
                poll.right = nodes.poll();
            }
            current.add(poll);
        }
        return current;
    }

    static class Node {
        char val;
        Node left, right;

        public Node(char val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}

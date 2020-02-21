package ds.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Node node = createNode(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        System.out.println("Input is          \t:" + node);
        System.out.println("After connections \t:" + connect(node));
    }

    public static Node connect(Node root) {
        if (root == null) return null;
//        Do a level order traversal and connect the nodes.
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
//            Get all the level values into the queue.
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
//            Iterate through the level values and link the first value with second and so on.
            if (queue.size() > 0) {
                Node pre = queue.get(0);
                for (int i = 1; i < queue.size(); i++) {
                    pre.next = queue.get(i);
                    pre = pre.next;
                }
            }
        }
        return root;
    }

    public static Node createNode(ArrayList<Integer> nums) {
        Queue<Node> treeNodeQueue = new LinkedList<>();
        int index = 1;
        Node treeNode = new Node();
        treeNode.val = nums.get(0);
        treeNodeQueue.add(treeNode);

        while (index < nums.size() && !treeNodeQueue.isEmpty()) {
            Node peek = treeNodeQueue.poll();
            if (nums.get(index) != null) {
                Node left = new Node();
                left.val = nums.get(index++);
                peek.left = left;
                treeNodeQueue.add(left);
            } else index++;
            if (index < nums.size() && nums.get(index) != null) {
                Node right = new Node();
                right.val = nums.get(index++);
                peek.right = right;
                treeNodeQueue.add(right);
            } else index++;
        }
        return treeNode;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next;
    }
}
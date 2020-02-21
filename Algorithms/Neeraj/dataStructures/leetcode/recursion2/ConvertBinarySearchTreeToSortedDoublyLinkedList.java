package ds.recursion2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2899/
Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.
Let's take the following BST as an example, it may help you understand the problem better:
We want to transform this BST into a circular doubly linked list. Each node in a doubly linked list has a predecessor and successor. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.
The figure below shows the circular doubly linked list for the BST above. The "head" symbol means the node it points to is the smallest element of the linked list.
Specifically, we want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. We should return the pointer to the first element of the linked list.
The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.
 */
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    public static void main(String[] args) {
        System.out.println(treeToDoublyList(createTree(new Integer[]{4, 2, 5, 1, 3, null, null})));
    }

    public static Node treeToDoublyList_recursive(Node root) {
        if (root == null) return null;
        Node first = null, last = null;
        recursiveCall(root, first, last);
        last.right = first;
        first.left = last;
        return first;
    }

    private static void recursiveCall(Node node, Node first, Node last) {
        if (node == null) return;
        // node
        if (last != null) {
            // link the previous node (last)
            // with the current one (node)
            last.right = node;
            node.left = last;
        } else {
            // keep the smallest node
            // to close DLL later on
            first = node;
        }
        last = node;
        // right
        recursiveCall(node.right, first, last);
    }

    public static Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node node = new Node(), nodeRef = node;
        Stack<Node> nodes = new Stack<>();
        Node cur = root;
        while (cur != null || !nodes.isEmpty()) {
            while (cur != null) {
                nodes.add(cur);
                cur = cur.left;
            }
            cur = nodes.pop();
            nodeRef.val = cur.val;
            cur = cur.right;
            if (cur != null || !nodes.isEmpty()) {
                nodeRef.right = new Node();
                nodeRef = nodeRef.right;
            }
        }
        return convertToDoubleLinkedList(node);
    }

    private static Node convertToDoubleLinkedList(Node node) {
        if (node == null) return null;
        Node cur = node, next = node.right;
        while (next != null) {
            next.left = cur;
            cur = cur.right;
            next = next.right;
        }
        node.left = cur;
        cur.right = node;
        return node;
    }

    private static Node createTree(Integer[] integers) {
        if (integers.length == 0) return null;
        int index = 0;
        Node treeNode = new Node();
        treeNode.val = integers[index++];
        Queue<Node> queue = new LinkedList<>();
        queue.add(treeNode);
        while (index < integers.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
//                Create left and right child.
                Node currentHead = queue.poll();
                Node leftNode = new Node(), rightNode = new Node();
//                Create left Child.
                Integer left = integers[index++];
                if (left != null) {
                    leftNode.val = left;
                    currentHead.left = leftNode;
                    queue.add(leftNode);
                }
                if (index == integers.length) break;
//                Create Right Child.
                Integer right = integers[index++];
                if (right != null) {
                    rightNode.val = right;
                    currentHead.right = rightNode;
                    queue.add(rightNode);
                }
            }
        }
        return treeNode;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    @Override
    public String toString() {
        return "val=" + val;
    }
}
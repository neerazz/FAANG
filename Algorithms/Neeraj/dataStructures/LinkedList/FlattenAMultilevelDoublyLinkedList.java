/*
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list.
These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
Example:
Input:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
Output:
1-2-3-7-8-11-12-9-10-4-5-6-NULL
 */
public class FlattenAMultilevelDoublyLinkedList {
    public static void main(String[] args) {

        Node one = new Node(1, null, null, null);
        Node two = new Node(2, one, null, null);
        Node three = new Node(3, two, null, null);
        Node four = new Node(4, three, null, null);
        Node five = new Node(5, four, null, null);
        Node six = new Node(6, five, null, null);
        Node seven = new Node(7, null, null, null);
        Node eight = new Node(8, seven, null, null);
        Node nine = new Node(9, eight, null, null);
        Node ten = new Node(10, nine, null, null);
        Node eleven = new Node(11, null, null, null);
        Node twelve = new Node(12, eleven, null, null);

        one.next = two;
        two.next = three;
        three.next = four;
        three.child = seven;
        four.next = five;
        five.next = six;
        seven.next = eight;
        eight.child = eleven;
        eight.next = nine;
        nine.next = ten;
        eleven.next = twelve;
//        System.out.println(flatten(one));
        System.out.println(flatten_rev1(one));
    }

    public static Node flatten_rev1(Node head) {
        if (head == null) return null;
        if (head.child != null) {
            Node child = flatten_rev1(head.child);
            Node next = flatten_rev1(head.next);
            linkNode(head, child);
            Node childSLast = getLast(child);
            linkNode(childSLast, next);
        } else {
            Node next = flatten_rev1(head.next);
            linkNode(head, next);
        }
        return head;
    }

    private static Node getLast(Node node) {
        if (node == null) return null;
        Node next = getLast(node.next);
        return next == null ? node : next;
    }

    private static void linkNode(Node pre, Node next) {
        pre.next = next;
        pre.child = null;
        if (next != null) {
            next.prev = pre;
            next.child = null;
        }
    }

    public static Node flatten(Node head) {
        if (head == null) return null;
        Node headRef = head;
        Node child = null, right = null;
        if (head.child != null) {
            child = flatten(head.child);
            head.child = null;
        }
        if (head.next != null) {
            right = flatten(head.next);
        }
        if (child != null) {
            child = appendAtEnd(child, right);
        } else {
            child = right;
        }
        if (child != null) child.prev = headRef;
        headRef.next = child;
        return head;
    }

    private static Node appendAtEnd(Node child, Node right) {
        if (right == null) return child;
        Node childRef = child;
        while (childRef != null) {
            if (childRef.next != null) childRef = childRef.next;
            else {
                right.prev = childRef;
                childRef.next = right;
                break;
            }
        }
        return child;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }

        @Override
        public String toString() {
            return val +
                    ", next =" + next +
                    ", child =" + child;
        }
    }
}
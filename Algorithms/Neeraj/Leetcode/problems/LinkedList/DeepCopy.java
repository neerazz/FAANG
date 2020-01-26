package problems.LinkedList;

import java.util.HashMap;
import java.util.Map;

/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.
Example 1:
Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 */
public class DeepCopy {

    static Map<Node, Node> map = new HashMap<>();

    public static void main(String[] args) {
        Node one = new Node(1, null, null);
        Node two = new Node(2, null, null);
        Node three = new Node(3, null, null);
        one.next = two;
        one.random = two;
        two.next = null;
        two.random = two;
        System.out.println("Answer is:" + copyRandomList(one) + "should be [1,2,null]");
    }

    public static Node copyRandomList(Node head) {
        if (head == null) return head;
        if (map.containsKey(head)) {
            return map.get(head);
        }
        Node newNode = new Node();
        newNode.val = head.val;
        map.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }

        @Override
        public String toString() {
            return "val=" + val;
        }
    }
}

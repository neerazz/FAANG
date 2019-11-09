//TODO: REdo  this problem
public class FlattenMutilevelList {

    public static void main(String[] args) {
    }

    public static Node flatten(Node head) {
        if (head == null)
            return head;
        Node ptr = head;
        while (ptr != null) {
            if (ptr.child != null) {
                flatten(ptr, ptr.child);
            }
        }
        return null;
    }

    public static Node flatten(Node head, Node child) {
        if (child == null) return head;
        head.next = child;
        head.next.child = null;
        child = child.child == null ? child.next : child.child;
        return flatten(head.next, child);
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
    }

}
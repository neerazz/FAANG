public class CopyListWithRandomPointer {

    class Node {
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
    };

    public static void main(String[] args) {

    }

    public static Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Node cloneRandom = head.random;
        Node itr = cloneRandom;
        while (itr != null) {

        }
        return null;
    }
}
import java.util.HashMap;
import java.util.Map;

class CopyListWithRandomPointer {
    public static void main(String[] args) {

    }

    static Map<Node, Node> map = new HashMap<>();

    public static Node copyRandomList(Node head) {
//        if (head == null) return null;
//        if (map.containsKey(head)) return map.get(head);
//        Node newNode = new Node(head.val);
//        map.put(head, newNode);
//        newNode.random = copyRandomList(head.random);
//        newNode.next = copyRandomList(head.next);
//        return newNode;

        if (head == null) {
            return null;
        }
        // If we have already processed the current node, then we simply return the cloned version of
        // it.
        if (map.containsKey(head)) {
            return map.get(head);
        }
        // Create a new node with the value same as old node. (i.e. copy the node)
        Node node = new Node(head.val);

        // Save this value in the hash map. This is needed since there might be
        // loops during traversal due to randomness of random pointers and this would help us avoid them.
        map.put(head, node);

        // Recursively copy the remaining linked list starting once from the next pointer and then from the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

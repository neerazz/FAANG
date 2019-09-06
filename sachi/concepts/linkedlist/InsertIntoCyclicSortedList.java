public class InsertIntoCyclicSortedList {

    public static void main(String[] args) {
        Node h1 = new Node(1, null);
        Node h2 = new Node(3, null);
        Node h3 = new Node(5, null);
        // Node h4 = new Node(4, null);
        // Node h5 = new Node(5, null);
        // Assign
        // h5.next = h1;
        // h4.next = h5;
        h3.next = h1;
        h2.next = h3;
        h1.next = h2;
        // Set head
        Node head = h1;
        Util.print(head, true);
        Util.print(insert(head, 0), true);
    }

    public static Node insert(Node head, int insertVal) {
        Node elem = new Node(insertVal, null);
        if (head == null) {
            return elem;
        } else if (head.next == null) {
            head.next = elem;
        }
        Node curr = head;
        Node next = head.next;

        do{
            if (next.val < curr.val) {
                if (elem.val >= curr.val && elem.val >= next.val) {
                    elem.next = next;
                    curr.next = elem;
                    return head;
                }

        }while(next != head.next);

        do {
            if (next.val < curr.val) {
                // End of Node
                if (elem.val >= curr.val && elem.val >= next.val) {
                    elem.next = next;
                    curr.next = elem;
                    return head;
                }
            } else {
                if (elem.val >= curr.val && elem.val <= next.val) {
                    elem.next = next;
                    curr.next = elem;
                    return head;
                }
            }
            curr = curr.next;
            next = next.next;
        }while(next != head.next);
        elem.next = next;
        curr.next = elem;
        return head;
    }
}
/*
Insert into a Cyclic Sorted List
Given a node from a cyclic linked list which is sorted in ascending order, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the cyclic list.

If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the cyclic list should remain sorted.

If the list is empty (i.e., given node is null), you should create a new single cyclic list and return the reference to that single node. Otherwise, you should return the original given node.

The following example may help you understand the problem better:

 
*/
public class InsertIntoCyclicSortedList {

    public static void main(String[] args) {
        Node h1 = new Node(3, null);
        Node h2 = new Node(3, null);
        Node h3 = new Node(3, null);
        // Node h4 = new Node(0, null);
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
        if (head == null)
            return elem;
        if (head.next == null)
            head.next = elem;

        // Get the head of least elem
        Node curr = head;
        Node next = head.next;
        Node newHead = curr;
        do {
            if (curr.val < newHead.val) {
                newHead = curr;
            }
            curr = curr.next;
            next = next.next;
        } while (next != head.next);

        curr = newHead;
        next = newHead.next;
        do {
            if (elem.val >= curr.val && elem.val <= next.val) {
                elem.next = next;
                curr.next = elem;
                return head;
            }
            curr = curr.next;
            next = next.next;
        } while (next != newHead);
        elem.next = next;
        curr.next = elem;
        return head;
    }
}
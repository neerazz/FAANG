/*
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);

        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(3);
        h1.next.next.next = new ListNode(4);
        h1.next.next.next.next = new ListNode(5);
        System.out.println("\nInput");
        print(h);
        System.out.println("\nOutput");
        print(reverseList(h));
        System.out.println("\nRecusrion");
        print(reverseList(h1, null));
    }

    private static ListNode reverseList(ListNode head) {
        ListNode sol = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = sol;
            sol = head;
            head = next;
        }
        return sol;
    }

    private static ListNode reverseList(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseList(next, head);
    }

    /**
     * Print LinkedLIst
     *
     * @param head
     */
    public static void print(ListNode head) {
        if (head == null) {
            return;
        } else {
            System.out.print(head.val);
            print(head.next);
        }
    }
}
/*
Remove Nth Node From End of List
Solution
Given a linked list, remove the n-th node from the end of list and return its head.

Example:
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.

Follow up:
Could you do this in one pass?

Mistakes:
ListNode ptr1 = dummy;
ListNode ptr2 = dummy;
*/

public class RemoveNthNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l4.next = null;
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;
        head.next = l1;
        //removeNthFromEnd(head, 1).print(true);
        Util.print(removeNthFromEndElegant(head, 1));
    }

    //One Pass
    private static ListNode removeNthFromEndElegant(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (n == size) {
            return head.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int i = 1; i < size - n; i++) {
            head = head.next;
        }
        head.next = head.next.next;
        return dummy.next;
    }
}

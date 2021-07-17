package concepts.linkedlist;

import util.ListNode;
import util.Util;

/*
Reverse Linked List
Solution
Reverse a singly linked list.

Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
//TODO: Mistake - You couldnt solve it at all. 
*/
public class ReverseLinkedList1 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        l4.next = null;
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;
        head.next = l1;
        Util.print(reverseLinkedList(head));
    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

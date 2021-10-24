package linkedlist;

import util.ListNode;

/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
P

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]

 */
public class RemoveNthNodeFromEndOfList {

    //Insight - Move to len - n - 1
    //dummy.next = dummy.next.next
    //Case when len == n -> Return head.next
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        //Find the size of the linked list
        ListNode dummy = head;
        int len = 0;
        while (dummy != null) {
            dummy = dummy.next;
            len++;
        }
        if (len == n) return head.next;
        int i = 0;
        dummy = head;
        while (i++ < len - n - 1) {
            dummy = dummy.next;
        }
        dummy.next = (dummy.next == null) ? null : dummy.next.next;
        return head;
    }
}

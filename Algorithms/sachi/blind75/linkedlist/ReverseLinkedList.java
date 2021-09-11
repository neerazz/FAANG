package blind75.linkedlist;

import util.ListNode;

/*
https://leetcode.com/problems/reverse-linked-list
F
Given the head of a singly linked list, reverse the list, and return the reversed list.
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

 */
public class ReverseLinkedList {

    public static void main(String[] args) {

    }

    //Insight - use three things
    //prev , curr, next
    //Reversed will be in prev
    //We reverse a section and assign to curr
    //Next will be in curr
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

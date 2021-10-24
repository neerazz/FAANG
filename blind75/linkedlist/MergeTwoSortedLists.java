package linkedlist;

import util.ListNode;

/*
https://leetcode.com/problems/merge-two-sorted-lists/
F
Merge two sorted linked lists and return it as a sorted list.
The list should be made by splicing together the nodes of the first two lists.

Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

 */
public class MergeTwoSortedLists {

    //Insight
    //Two pointers, dummy & ref
    //Always changes ref.next  only and return dummy.next
    //Dont forget to move ref to next pos
    //At end assign ref to l1 or l2 if not null
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode ref = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ref.next = l1;
                l1 = l1.next;
            } else {
                ref.next = l2;
                l2 = l2.next;
            }
            ref = ref.next;
        }
        ref.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }
}

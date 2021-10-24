package linkedlist;

import util.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/merge-k-sorted-lists/
P

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []

 */
public class MergeKSortedLists {


    //Insight - Write a method to merge two lists
    //You can merge 1,2 -> Sol,3 -> sol,4... This will take O(NK)
    //Instead do Merge (1,2) (3,4) (5,6) then merge solutions -> Here it is O(NlogK)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Queue<ListNode> q = new LinkedList<>();
        for (ListNode listNode : lists) {
            q.add(listNode);
        }

        while (q.size() > 1) {
            ListNode l1 = q.poll();
            ListNode l2 = q.poll();
            ListNode merged = mergeTwoLists(l1, l2);
            q.add(merged);
        }
        return q.poll();
    }

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

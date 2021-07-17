package leetcode.v1.hard;

import util.ListNode;
import util.Util;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode mergeKListsNaive(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode sol = lists[0];
        for (int i = 1; i < lists.length; i++) {
            sol = merge2Lists(sol, lists[i]);
        }
        return sol;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        Queue<ListNode> pq = new PriorityQueue<> ((l1, l2) -> l1.val - l2.val);
        pq.add(lists[0]);
        while (!pq.isEmpty()) {
            for (int i = 1; i < lists.length; i++) {
                ListNode node = lists[i];
                pq.add(node);
                node = node.next;
            }
            prev.next = pq.poll();
            prev = prev.next;
        }
        return dummy.next;
    }


    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode sol = dummy;
        while (l1 != null && l2 != null) {
            int val;
            if (l1.val < l2.val) {
                val = l1.val;
                l1 = l1.next;
            } else {
                val = l1.val;
                l1 = l1.next;
            }
            sol.next = new ListNode(val);
            sol = sol.next;
        }
        sol.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node0 = Util.createLinkedListFromArray(new int[]{-1, 100, 105, 144, 145});
        ListNode node1 = Util.createLinkedListFromArray(new int[]{3, 9, 10, 13});
        ListNode node2 = Util.createLinkedListFromArray(new int[]{1, 15, 18, 23});

        ListNode sol = mergeKLists(new ListNode[]{node0, node1, node2});
        Util.print(sol);
    }

}

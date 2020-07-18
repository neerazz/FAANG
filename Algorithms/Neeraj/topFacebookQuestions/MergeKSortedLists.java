import java.util.Queue;

/**
 * Created on:  Jul 17, 2020
 * Questions: https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        while (true) {
            int len = lists.length, newLen = (len + 1) / 2, idx = 0;
            if (len == 1) return lists[0];
            ListNode[] temp = new ListNode[newLen];
            int start = 0, end = len - 1;
            while (start < end) {
                temp[idx++] = mergeTwoSortedList(lists[start++], lists[end--]);
            }
            if (len % 2 != 0) temp[idx] = lists[start];
            lists = temp;
        }
    }

    private static ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        ListNode op = new ListNode(-1), opRef = op;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                opRef.next = l1;
                opRef = opRef.next;
                l1 = l1.next;
            } else {
                opRef.next = l2;
                opRef = opRef.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            opRef.next = l1;
        } else if (l2 != null) {
            opRef.next = l2;
        }
        return op.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

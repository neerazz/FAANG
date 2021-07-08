/**
 * Created on:  Jul 06, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/N7rwVyAZl6D
 */

public class LinkedListCycleLength {

    public static void main(String[] args) {

    }

    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static int findCycleLength(ListNode head) {
        ListNode slow = new ListNode(-1), fast = new ListNode(-1);
        slow.next = head;
        fast.next = head;
        while (slow != null && fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if (slow == fast) return calculateLength(slow);
        }
        return 0;
    }

    private static int calculateLength(ListNode node) {
        int len = 1;
        ListNode cur = node.next;
        while (cur != node) {
            len++;
            cur = cur.next;
        }
        return len;
    }
}

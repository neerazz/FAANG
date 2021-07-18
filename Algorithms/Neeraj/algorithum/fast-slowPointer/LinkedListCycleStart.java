/**
 * Created on:  Jul 06, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/N7pvEn86YrN
 */

public class LinkedListCycleStart {

    public static void main(String[] args) {

    }

    public static ListNode findCycleStart(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int len = cycleLength(slow);
                return getStart(head, len);
            }
        }
        return null;
    }

    private static ListNode getStart(ListNode head, int len) {
        ListNode p1 = head, p2 = head;
//        Advance p1 pointer to len, so that p1 travels the cycle length. And by the time it completes travelling the list, both p1 and p2 will be at the start of the cycle.
        while (len-- > 0) {
            p1 = p1.next;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    private static int cycleLength(ListNode node) {
        int len = 1;
        ListNode cur = node.next;
        while (cur != node) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    " -> " + this.next;
        }
    }
}

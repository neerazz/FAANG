/**
 * Created on:  Jul 06, 2021
 * Ref:
 */

public class RearrangeList {

    public static void reorder(ListNode head) {
        if (head == null) return;
        int half = 0;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            half++;
        }
        // slow is now pointing to the middle node
        ListNode end = reverse(slow);
        ListNode start = head;
        while (start != null && end != null) {
            ListNode temp = start.next;
            start.next = end;
            start = temp;

            temp = end.next;
            end.next = start;
            end = temp;
        }
        if (start != null) start.next = null;
    }

    static ListNode reverse(ListNode node) {
        ListNode result = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = result;
            result = node;
            node = next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + ">" + next;
        }
    }
}

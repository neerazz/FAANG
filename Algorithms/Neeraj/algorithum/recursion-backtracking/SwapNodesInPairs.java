/*
Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        third.next = fourth;
        second.next = third;
        first.next = second;

        System.out.println(swapPairs(first));
    }

    public static ListNode swapPairs(ListNode head) {
        swapPairs2(head);
        return head;
    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int temp = head.val;
        head.val = head.next.val;
        head.next.val = temp;
        return swapPairs(head.next.next);
    }

    public static class ListNode {
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

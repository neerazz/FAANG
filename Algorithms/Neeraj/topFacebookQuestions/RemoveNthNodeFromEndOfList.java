/**
 * Created on:  Jul 21, 2020
 * Questions: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode op = new ListNode(-1, head), p1 = op, p2 = op.next;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return op.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}

/**
 * Created on:  Jul 14, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/qVANqMonoB2#problem-statement
 */

public class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {
        ListNode pre = null, cur = head;
        int idx = 0;
//        Fast forward the pointer till p.
        while (idx < p - 1) {
            pre = cur;
            cur = cur.next;
            idx++;
        }
        ListNode endOfFirstList = pre;
//        after reversing the LinkedList 'current' will become the last node of the sub-list
        ListNode endOfSecondList = cur;
//        Reverse the sub-list
        ListNode reverse = null;
        while (idx < q) {
            ListNode next = cur.next;
            cur.next = reverse;
            reverse = cur;
            cur = next;
            idx++;
        }
        // connect with the first part
        if (endOfFirstList != null)
            endOfFirstList.next = reverse; // 'previous' is now the first node of the sub-list
        else // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
            head = pre;
//        Append the end to this sublist;
        endOfSecondList.next = cur;
        return head;
    }

    private static ListNode reverse(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = result;
            result = head;
            head = next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Nodes of the Input LinkedList are: ");
        println(head);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.println("Nodes of the reversed LinkedList are: ");
        println(result);
    }

    private static void println(ListNode node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}

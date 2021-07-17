package concepts.recursion;

import util.ListNode;

/*
Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPair {
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        System.out.println("Input");
        print(h);
        swapPairs(h);
        System.out.println("\nOutput");
        print(h);
        System.out.println("\nOutput  2 - ");
        print(iterariveSwap(h));
    }

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = head.next;
        ListNode third = second.next;
        second.next = head;
        head.next = swapPairs(third);
        return second;
    }

    private static ListNode iterariveSwap(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

    /**
     * Print problems.LinkedList
     *
     * @param head
     */
    public static void print(ListNode head) {
        if (head == null) {
            return;
        } else {
            System.out.print(head.val);
            print(head.next);
        }
    }
}
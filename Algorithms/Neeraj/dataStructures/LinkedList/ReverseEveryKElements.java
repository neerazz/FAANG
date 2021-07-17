import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.io.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on:  Jul 16, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/RMZylvkGznR
 * <p>
 * Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.
 * <p>
 * If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 */

public class ReverseEveryKElements {

    /*
     * <p>
     * Given the head of a LinkedList and a number ‘k’, reverse every alternating ‘k’ sized sub-list starting from the head.
     * <p>
     * If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
     */
    public static ListNode reverse_2(ListNode head, int k) {
        ListNode pre = null, cur = head;
        ListNode preEnd = null;
        while (cur != null) {
            ListNode rev = null, curEnd = cur;
            for (int i = 0; i < k && cur != null; i++) {
                ListNode next = cur.next;
                cur.next = rev;
                rev = cur;
                pre = cur;
                cur = next;
            }
            if (preEnd == null) {
                head = rev;
            } else {
                preEnd.next = pre;
            }
            curEnd.next = cur;
            for (int i = 0; i < k && cur != null; i++) {
                curEnd = curEnd.next;
                pre = cur;
                cur = cur.next;
            }
            preEnd = pre;
        }
        return head;
    }

    /*
     * <p>
     * Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.
     * <p>
     * If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
     */
    public static ListNode reverse(ListNode head, int k) {
        ListNode pre = null, cur = head;
        ListNode preEnd = null;
        while (cur != null) {
            ListNode reverse = null;
            ListNode curEnd = cur;
            for (int i = 0; i < k && cur != null; i++) {
                ListNode next = cur.next;
                cur.next = reverse;
                reverse = cur;
                pre = cur;
                cur = next;
            }
            if (preEnd != null) {
                preEnd.next = reverse;
            } else {
                head = pre;
            }
            preEnd = curEnd;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println("Nodes of the reversed LinkedList are: ");
        System.out.println(reverse(buildListNode(), 2));
        System.out.println("Nodes of the Alternative reversed LinkedList are: ");
        System.out.println(reverse_2(buildListNode(), 2));
    }

    private static ListNode buildListNode() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        return head;
    }

    static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + " -> " + next;
        }
    }
}

package biweekly.biweekly40;

import java.util.*;

/**
 * Created on:  Nov 28, 2020
 * Questions:
 */

public class MergeInBetweenLinkedLists {

    public static void main(String[] args) {
        System.out.println(mergeInBetween(createListNode(Arrays.asList(0, 1, 2, 3, 4, 5)), 3, 4, createListNode(Arrays.asList(1000000, 1000001, 1000002))));
    }

    private static ListNode createListNode(List<Integer> list) {
        ListNode output = new ListNode(0), outputRef = output;
        for (int val : list) {
            outputRef.next = new ListNode(val);
            outputRef = outputRef.next;
        }
        return output.next;
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode op = new ListNode(-1, list1), start = op, end = op;
        int i = 0;
        while (i < a) {
            start = start.next;
            end = end.next;
            i++;
        }
        while (i <= b) {
            end = end.next;
            i++;
        }
        ListNode l2Ref = list2;
        while (l2Ref.next != null) {
            l2Ref = l2Ref.next;
        }
        start.next = list2;
        l2Ref.next = end.next;
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}

package ds.recursion;

import java.util.List;
import java.util.Scanner;

/*
Problem: https://leetcode.com/problems/add-two-numbers/
Sample: (3 2 4 3 5 6 4)
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCount = Integer.parseInt(scanner.next());

        Integer[] first = new Integer[totalCount];
        Integer[] second = new Integer[totalCount];
        for (int i = 0; i < totalCount; i++) first[i] = Integer.parseInt(scanner.next());
        for (int i = 0; i < totalCount; i++) second[i] = Integer.parseInt(scanner.next());
        System.out.println(addTwoNumbers(createListNodeFromArray(first), createListNodeFromArray(second)));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    static void checkNextNumberValue(List<Integer> result, ListNode l1, ListNode l2, int i) {
        if (l1.next != null && l2.next != null) {
            checkNextNumberValue(result, l1.next, l2.next, i + 1);
        }
        result.add(i, calculateValue(l1, l2));
    }

    static int calculateValue(ListNode l1, ListNode l2) {
        return (l1.val + l2.val) % 10;
    }

    public static ListNode createListNodeFromArray(Object[] array) {
        ListNode[] temp = new ListNode[array.length];
        for (int i = 0; i < array.length; i++) temp[i] = new ListNode((Integer) array[i]);
        ListNode previous = null;
        ListNode current = null;

        for (int i = array.length - 1; i >= 0; i--) {
            previous = current;
            current = temp[i];
            current.next = previous;
        }
        return current;
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
                    ", next=" + next +
                    '}';
        }
    }
}

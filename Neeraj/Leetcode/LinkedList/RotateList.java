package LinkedList;

/*
https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/
Given a linked list, rotate the list to the right by k places, where k is non-negative.
Example 1:
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:
Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode listNode = RemoveNthNodeFromEndOfList.createListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(rotateRight(listNode, 1));
        System.out.println(rotateRight(listNode, 2));
        System.out.println("===================================================");
        listNode = RemoveNthNodeFromEndOfList.createListNode(new int[]{0, 1, 2});
        System.out.println(rotateRight(listNode, 1));
        System.out.println(rotateRight(listNode, 2));
        System.out.println(rotateRight(listNode, 3));
        System.out.println(rotateRight(listNode, 4));
        System.out.println("===================================================");
        listNode = RemoveNthNodeFromEndOfList.createListNode(new int[]{1, 2, 3});
        System.out.println(rotateRight(listNode, 1));
        System.out.println(rotateRight(listNode, 2000000000));
        System.out.println("===================================================");
        listNode = RemoveNthNodeFromEndOfList.createListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(rotateRight(listNode, 10));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode headcount = head;
        int size = 0;
        while (headcount != null) {
            size++;
            headcount = headcount.next;
        }

        if (k > size) k = k % size;

        if (k < 1) return head;
        ListNode headref = head, rotateRef = new ListNode(0);
        ListNode rotate = rotateRef;

        while (headref.next != null) {
            rotate.next = new ListNode(headref.val);
            rotate = rotate.next;
            headref = headref.next;
        }
        rotateRef.val = headref.val;
        return rotateRight(rotateRef, k - 1);
    }
}

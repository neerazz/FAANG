package problems.LinkedList;

import java.util.ArrayList;
import java.util.List;

/*
Given a singly linked list, determine if it is a palindrome.
Example 1:
Input: 1->2
Output: false
Example 2:
Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode listNode = RemoveNthNodeFromEndOfList.createListNode(new int[]{1, 2});
        System.out.println("Answer is:" + isPalindrome(listNode) + " should be [false]");

        listNode = RemoveNthNodeFromEndOfList.createListNode(new int[]{1, 2, 2, 1});
        System.out.println("Answer is:" + isPalindrome(listNode) + " should be [true]");

        listNode = RemoveNthNodeFromEndOfList.createListNode(new int[]{1, 2, 3, 2, 1});
        System.out.println("Answer is:" + isPalindrome(listNode) + " should be [true]");

        listNode = RemoveNthNodeFromEndOfList.createListNode(new int[]{-129, -129});
        System.out.println("Answer is:" + isPalindrome(listNode) + " should be [true]");
    }

    //    Time : O(n), Space: O(n)
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        List<Integer> nodes = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodes.add(current.val);
            current = current.next;
        }

//        Check if this list of numbers are palindrome
        int start = 0, end = nodes.size() - 1;

        while (start <= end) {
            if (!nodes.get(start).equals(nodes.get(end))) return false;
            start++;
            end--;
        }
        return true;
    }
}

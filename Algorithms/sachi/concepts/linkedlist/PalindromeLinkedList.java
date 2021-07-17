import util.ListNode;
import util.Util;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        // ListNode l4 = new ListNode(2);
        // ListNode l5 = new ListNode(1);
        // l4.next = l5;
        // l3.next = l4;
        l2.next = l3;
        l1.next = l2;
        head.next = l1;
        System.out.println(isPalindrome(head));
        Util.print(head);
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        // Find length
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        // Break into two peices
        temp = head;
        ListNode first = head;
        ListNode last = null;
        for (int i = 0; i < (length / 2) - 1; i++) {
            temp = temp.next;
        }

        // Check middle nodes - If they are not equal, cannot be a palindrome
        last = temp.next;
        first = head;
        temp.next = null;

        // Reverse last and compare with first
        ListNode prev = null;
        ListNode curr = last;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        // Compare prev to first
        for (int i = 0; i < length / 2; i++) {
            if (prev.val != first.val) {
                return false;
            } else {
                prev = prev.next;
                first = first.next;
            }
        }
        return true;
    }
}
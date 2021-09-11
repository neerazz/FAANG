/**
 * Created on:  Nov 02, 2020
 * Questions: https://leetcode.com/problems/add-two-numbers/
 */

public class AddTwoNumbersLinkedList {

    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode op = new ListNode(-1), opRef = op;
        int carry = 0;
        while (l1 != null & l2 != null) {
            int sum = carry + l1.val + l2.val;
            opRef.next = new ListNode(sum % 10);
            carry = sum / 10;
            opRef = opRef.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = carry + l1.val;
            carry = sum / 10;
            opRef.next = new ListNode(sum % 10);
            opRef = opRef.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = carry + l2.val;
            carry = sum / 10;
            opRef.next = new ListNode(sum % 10);
            opRef = opRef.next;
            l2 = l2.next;
        }
        if (carry > 0) {
            opRef.next = new ListNode(carry);
        }
        return op.next;
    }
}

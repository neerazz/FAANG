import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 07, 2020
 * Questions: https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/564/week-1-november-1st-november-7th/3522/
 */

public class AddTwoNumbersII {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rev1 = reverse(l1), rev2 = reverse(l2);
        ListNode sumNode = new ListNode(-1), ref = sumNode;
        int carry = 0;
        while(rev1 != null && rev2 != null){
            int sum = rev1.val + rev2.val + carry;
            ref.next = new ListNode(sum %10);
            carry = sum / 10;
            ref = ref.next;
            rev1 = rev1.next;
            rev2 = rev2.next;
        }
        while(rev1 != null){
            int sum = rev1.val +carry;
            ref.next = new ListNode(sum %10);
            carry = sum / 10;
            ref = ref.next;
            rev1 = rev1.next;
        }
        while(rev2 != null){
            int sum = rev2.val + carry;
            ref.next = new ListNode(sum %10);
            carry = sum / 10;
            ref = ref.next;
            rev2 = rev2.next;
        }
        if(carry > 0){
            ref.next = new ListNode(carry);
        }
        return sumNode;
        // return reverse(sumNode.next);
    }
    private ListNode reverse(ListNode head){
        ListNode cur = head, next = null, op = null;
        while(cur != null){
            next = cur.next;
            cur.next = op;
            op = cur;
            cur = next;
        }
        return op;
    }
}

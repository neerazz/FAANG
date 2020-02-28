package topAmazonQuestions;

import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println(addTwoNumbers(createListNode(Arrays.asList(2, 4, 3)), createListNode(Arrays.asList(5, 6, 4))));
        System.out.println(addTwoNumbers(createListNode(Arrays.asList(5)), createListNode(Arrays.asList(5))));
    }

    private static ListNode createListNode(List<Integer> list) {
        ListNode output = new ListNode(0), outputRef = output;
        for (int val : list) {
            outputRef.next = new ListNode(val);
            outputRef = outputRef.next;
        }
        return output.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = new ListNode(0), outputRef = output;

        int sum = 0, carry = 0;
        while (l1 != null || l2 != null) {
            sum += l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;
            sum += carry;
            outputRef.next = new ListNode(sum % 10);
            outputRef = outputRef.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            carry = sum / 10;
            sum = 0;
        }
        if (carry > 0){
            outputRef.next = new ListNode(carry);
        }
        return output.next;
    }
}

class ListNode {
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
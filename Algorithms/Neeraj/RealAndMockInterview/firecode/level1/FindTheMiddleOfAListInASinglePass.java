package level1;

import java.util.Arrays;
import java.util.List;

/*
Given a Singly-Linked List, write a method - findMiddleNode that finds and returns the middle node of the list in a single pass.
Examples:
1 ==> 1
1->2 ==> 1
1->2->3->4 ==> 2
1->2->3->4->5 ==> 3
 */
public class FindTheMiddleOfAListInASinglePass {
    public static void main(String[] args) {
        System.out.println(findMiddleNode(createListNode(Arrays.asList(1, 2, 3, 4, 5, 6))));
        System.out.println(findMiddleNode(createListNode(Arrays.asList(1, 2, 3, 4, 5))));
        System.out.println(findMiddleNode(createListNode(Arrays.asList(1, 2, 3, 4))));
        System.out.println(findMiddleNode(createListNode(Arrays.asList(1, 2))));
    }

    public static ListNode findMiddleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) slow = slow.next;
        }
        return slow;
    }

    public static ListNode createListNode(List<Integer> nums) {
        if (nums.size() == 0) return null;
        ListNode listNode = new ListNode(nums.get(0)), listNodeRef = listNode;
        for (int i = 1; i < nums.size(); i++) {
            listNodeRef.next = new ListNode(nums.get(i));
            listNodeRef = listNodeRef.next;
        }
        return listNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return val + "," + next;
    }
}
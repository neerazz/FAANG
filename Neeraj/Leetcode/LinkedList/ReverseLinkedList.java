package LinkedList;

import static LinkedList.RemoveNthNodeFromEndOfList.createListNode;

/*
Reverse a singly linked list.
Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:
A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        System.out.println(reverseList(createListNode(new int[]{1, 2, 3, 4, 5})));
    }

    /*
        Solution:
        Step 1: Take a temporary node and the output node. Take the first number and set it next to second and set that to output. (From 1->2 to 2->1)
        Step 2: The set the output value current.next. (Current = 3-> 4, after setting the current.next to previous output it becomes 3-> 2->1)
     */
    public static ListNode reverseList(ListNode head) {
        ListNode current = head, temp = null, output = null;
        while (current != null) {
            temp = current.next;
            current.next = output;
            output = current;
            current = temp;
        }
        return output;
    }
}

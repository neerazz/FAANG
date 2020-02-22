/*
Remove all elements from a linked list of integers that have value val.
Example:
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        System.out.println(removeElements(RemoveNthNodeFromEndOfList.createListNode(new int[]{1, 2, 6, 3, 4, 5, 6}), 6));
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode current = head, outputRef = new ListNode(head.val), output = outputRef;
        while (current != null) {
            current = current.next;
            if (current != null && current.val != val) {
                output.next = new ListNode(current.val);
                output = output.next;
            }
        }
        return head.val == val ? outputRef.next : outputRef;
    }
}

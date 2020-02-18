package ds.recursion;

/*
Reverse a singly linked list.
Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        SwapNodesInPairs.ListNode first = new SwapNodesInPairs.ListNode(1);
        SwapNodesInPairs.ListNode second = new SwapNodesInPairs.ListNode(2);
        SwapNodesInPairs.ListNode third = new SwapNodesInPairs.ListNode(3);
        SwapNodesInPairs.ListNode fourth = new SwapNodesInPairs.ListNode(4);
        third.next = fourth;
        second.next = third;
        first.next = second;

        System.out.println(reverseList(first));
    }

    public static SwapNodesInPairs.ListNode reverseList(SwapNodesInPairs.ListNode head) {
        SwapNodesInPairs.ListNode current = head, next = null, previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}

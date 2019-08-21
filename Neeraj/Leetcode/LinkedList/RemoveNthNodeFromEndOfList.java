package LinkedList;

/*
https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/
Given a linked list, remove the n-th node from the end of list and return its head.

Example:
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

Note: Given n will always be valid.
Follow up: Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode listNode = createListNode(new int[]{1,2,3,4,5});
        System.out.println("Input : " + listNode);
//        System.out.println("Output: " + removeNthFromEnd(listNode,1));
        System.out.println("Output: " + removeNthFromStart(listNode,2));
        System.out.println("Output: " + removeNthFromEnd(listNode,2));
        System.out.println("Output: " + removeNthFromEnd(listNode,3));
        System.out.println("Output: " + removeNthFromEnd(listNode,4));
        System.out.println("Output: " + removeNthFromEnd(listNode,5));
        System.out.println("Output: " + removeNthFromEnd(listNode,6));
    }

    /*
        Solution: Take two pointer.
        The first pointer advances the list by n+1n+1 steps from the beginning, while the second pointer starts from the beginning of the list.
        Now, both pointers are exactly separated by nn nodes apart.
        We maintain this constant gap by advancing both pointers together until the first pointer arrives past the last node.
        The second pointer will be pointing at the nnth node counting from the last.
        We relink the next pointer of the node referenced by the second pointer to point to the node's next next node.
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    //    From the beginning.
    public static ListNode removeNthFromStart(ListNode head, int n) {
        if (n ==0) return head;
        ListNode current = head;
        if (n == 1) return head.next;

        ListNode outputHead = new ListNode(head.val), output = outputHead;

        int counter =1;
        current = current.next;
        while (current != null){
            if (counter < n-1){
                output.next = new ListNode(current.val);
                output = output.next;
            }else if (counter > n-1){
                output.next = new ListNode(current.val);
                output = output.next;
            }
            counter++;
            current = current.next;
        }
        return outputHead;
    }

    public static ListNode createListNode(int[] nums) {
        if (nums.length == 0) return null;
        ListNode output = new ListNode(nums[0]), current = output;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return output;
    }
}

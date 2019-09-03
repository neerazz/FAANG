import java.util.HashSet;
import java.util.Set;
/*

Linked List Cycle II

Solution
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
Note: Do not modify the linked list.


Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.


Mistake:
while (slow != fast)  -> Once they are equal
*/
public class LinkedListCycle2 {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(4);
        l4.next = l2;
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;
        head.next = l1;
        System.out.println(detectCycleNaive(head).val);
        System.out.println(detectCycleElegant(head).val);
    }

    private static ListNode detectCycleElegant(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    private static ListNode detectCycleNaive(ListNode head) {
        Set<ListNode> cache = new HashSet<>();
        while (head != null) {
            if (cache.contains(head)) return head;
            cache.add(head);
            head = head.next;
        }
        return null;
    }
}

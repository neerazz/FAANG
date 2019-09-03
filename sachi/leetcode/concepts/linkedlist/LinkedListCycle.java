import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
Linked List Cycle
Solution
Given a linked list, determine if it has a cycle in it.
To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.

*/
/*
Mistake -
1. fast == slow and not fast.val == slow.val
Since values can be same.

2.
head = head.next;
fast = fast.next.next;
while (head != null && fast != null && fast.next != null)
*/

public class LinkedListCycle {
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
        System.out.println(hasCycleNaive(head));
        System.out.println(hasCycleSet(head));
        System.out.println(hasCycleElegant(head));
    }

    // Two pointers - Fast method
    private static boolean hasCycleElegant(ListNode head) {
        ListNode fast = head;
        while (head != null && fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
            if (fast == head) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycleSet(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    // Using a cache. Slow method
    private static boolean hasCycleNaive(ListNode head) {
        Map<Integer, Integer> cache = new HashMap<>();
        while (head != null) {
            if (cache.get(head.hashCode()) == null) {
                cache.put(head.hashCode(), 1);
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }
}

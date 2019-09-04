import java.util.HashSet;
import java.util.Set;
/*

Intersection of Two Linked Lists
Solution
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:
begin to intersect at node c1.

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 
Mistake :
Do not use tail and worry about wether list will meet or not.
*/
public class IntersectionOfLInkedLIsts {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNodeElegant(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        Set<ListNode> cache = new HashSet<>();
        while (headA != null) {
            cache.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (cache.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}

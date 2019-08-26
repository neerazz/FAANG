import java.util.HashSet;
import java.util.Set;

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

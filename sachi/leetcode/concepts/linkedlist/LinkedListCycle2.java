import java.util.HashSet;
import java.util.Set;

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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//Mistake -
// fast == slow and not fast.val == slow.val
//Since values can be same.

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

    //Two pointers - Fast method
    private static boolean hasCycleElegant(ListNode head) {
        if (head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && slow != null & fast.next != null) {
            if (fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    private static boolean hasCycleSet(ListNode head){
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


    //Using a cache. Slow method
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

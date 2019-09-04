import java.util.HashSet;
import java.util.Set;

/*
Write code to remove duplicates from an unsorted linked list.
*/

public class CTCIRemoveDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(4);
        l4.next = null;
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;
        head.next = l1;
        print(head);
        print(removeDuplicatesLinkedList(head));
    }

    private static ListNode removeDuplicatesLinkedList(ListNode head) {
        Set<Integer> cache = new HashSet<>();
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            if (cache.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                cache.add(head.val);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void print(ListNode head) {
        System.out.println("");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
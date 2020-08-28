/**
 * Created on:  Aug 20, 2020
 * Questions: https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {
    public static void main(String[] args) {
        ListNode listNode = LinkedListCycle.createListNode(new int[]{1, 2, 3, 4});
        reorderList(listNode);
        System.out.println(listNode);
        listNode = LinkedListCycle.createListNode(new int[]{1, 2, 3, 4, 5});
        reorderList(listNode);
        System.out.println(listNode);
    }

    public static void reorderList(ListNode head) {
        ListNode p1 = head, p2 = head;
//        Get to the mid value
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
//        Reverse only the second half.
        ListNode reverse = reverse(p1.next);

//        Reorder One by one.
        p1.next = null;
        p1 = head;
        while (reverse != null) {
            ListNode temp = p1.next;
            p1.next = reverse;
            p1 = p1.next;
            reverse = reverse.next;
            p1.next = temp;
            p1 = p1.next;
        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode op = new ListNode(-1), opRef = op.next;
        while (head != null) {
            ListNode temp = opRef;
            opRef = new ListNode(head.val);
            opRef.next = temp;
            head = head.next;
        }
        return opRef;
    }
}

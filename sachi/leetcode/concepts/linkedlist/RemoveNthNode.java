public class RemoveNthNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l4.next = null;
        l3.next = l4;
        l2.next = l3;
        l1.next = l2;
        head.next = l1;
        //removeNthFromEnd(head, 1).print(true);
        removeNthFromEndElegant(head, 1).print(true);
    }

    //One Pass
    private static ListNode removeNthFromEndElegant(ListNode head, int n) {
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

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (n == size) {
            return head.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int i = 1; i < size - n; i++) {
            head = head.next;
        }
        head.next = head.next.next;
        return dummy.next;
    }
}

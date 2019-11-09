public class Merge2SortedLists {
    // TODO: Implement Recursion
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        // l1.next.next.next = new ListNode(4);
        // l1.next.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);
        // l2.next.next.next.next = new ListNode(5);
        Util.print(mergeTwoListsIt(l1, l2));
    }

    // Iteration
    private static ListNode mergeTwoListsIt(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null || l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        //Super Optimization - exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
public class SwapNodesInPair {
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        System.out.println("Input");
        print(h);
        swapPairs(h);
        System.out.println("\nOutput");
        print(h);
        System.out.println("\nOutput  2 - ");
        print(iterariveSwap(h));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = head.next;
        ListNode third = second.next;
        second.next = head;
        head.next = swapPairs(third);
        return second;
    }

    public static ListNode iterariveSwap(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }

    /**
     * Print LinkedLIst
     * 
     * @param head
     */
    public static void print(ListNode head) {
        if (head == null) {
            return;
        } else {
            System.out.print(head.val);
            print(head.next);
        }
    }
}
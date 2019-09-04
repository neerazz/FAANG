public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    void print(boolean first) {
        if (first) {
            System.out.print(val + " ");
        }
        while (next != null) {
            System.out.print(next.val + " ");
            next = next.next;
        }
    }
}
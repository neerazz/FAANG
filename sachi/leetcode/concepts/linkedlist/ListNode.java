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
            next = next.next;
            System.out.print(val + " ");
        }
    }
}
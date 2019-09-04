public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void print(boolean printFirst) {
        if(printFirst) System.out.print(val);
        if (next == null) {
            return;
        } else {
            System.out.print(next.val);
            next = next.next;
            print(false);
        }
    }
}
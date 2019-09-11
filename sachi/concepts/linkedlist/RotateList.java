public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(2);
        Util.print(rotateRight(head, 2));
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
            
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }

        k = k % len;
        if (k == 0)
            return head;
        ListNode p1 = head, p2 = head;
        while (--k >= 0) {
            p2 = p2.next;
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == p2) {
            p1.next = head;
            return p1;
        } else {
            ListNode sol = p1.next;
            p1.next = null;
            p2.next = head;
            return sol;
        }
    }
}
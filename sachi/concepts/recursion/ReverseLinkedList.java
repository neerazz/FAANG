public class ReverseLinkedList{
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);
        System.out.println("Input");
        print(h);
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
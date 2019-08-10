public class SwapNodesInPair{
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);
        System.out.println("Input");
        print(h);
        swapPairs(h);
        System.out.println("\nOutput");
        print(h);
    }

    public static ListNode swapPairs(ListNode head) {
        if(head!=null &&  head.next != null){
            ListNode first = head;
            ListNode second = head.next;
            head = second;
            head.next = first;
            if(head.next.next !=null){
                return swapPairs(head.next.next);    
            }else{
                return head;
            }
        }
        return head;
    }

    /**
     * Print LinkedLIst
     * @param head
     */
    public static void print(ListNode head){
        if(head == null){
            return;
        }else{
            System.out.print(head.val);
            print(head.next);
        }
    }
}
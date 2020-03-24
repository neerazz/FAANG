/*
Reverse a singly linked list.
Example:
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:
A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        System.out.println(reverseList(createListNode(new int[]{1, 2, 3, 4, 5})));
        System.out.println(reverseList(createListNode(new int[]{4,5,6,7,8})));
        System.out.println(reverseList2(createListNode(new int[]{1, 2, 3, 4, 5})));
        System.out.println(reverseList2(createListNode(new int[]{4,5,6,7,8})));
    }

    public static ListNode createListNode(int[] nums) {
        if (nums.length == 0) return null;
        ListNode output = new ListNode(nums[0]), current = output;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return output;
    }
    /*
        Solution:
        Step 1: Take a temporary node and the output node. Take the first number and set it next to second and set that to output. (From 1->2 to 2->1)
        Step 2: The set the output value current.next. (Current = 3-> 4, after setting the current.next to previous output it becomes 3-> 2->1)
     */
    public static ListNode reverseList(ListNode head) {
        ListNode current = head, temp = null, output = null;
        while (current != null) {
            temp = current.next;
            current.next = output;
            output = current;
            current = temp;
        }
        return output;
    }
    public static ListNode reverseList2(ListNode head) {
        ListNode output = new ListNode(-1), outputRef = output;
        while (head != null) {
            ListNode temp = outputRef.next;
            outputRef.next = new ListNode(head.data);
            outputRef.next.next = temp;
            head = head.next;
        }
        return output.next;
    }
    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "" + data + ":->"+ next;
        }
    }
}

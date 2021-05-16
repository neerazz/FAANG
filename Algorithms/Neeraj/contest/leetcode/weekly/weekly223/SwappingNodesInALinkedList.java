package weekly.weekly223;

/**
 * Created on:  Jan 09, 2021
 * Questions:
 */

public class SwappingNodesInALinkedList {

    public static void main(String[] args) {
        System.out.println(swapNodes(createListNode(new int[]{1,2,3,4,5}), 2));
        System.out.println(swapNodes(createListNode(new int[]{7,9,6,6,7,8,3,0,9,5}), 5));
        System.out.println(swapNodes(createListNode(new int[]{1}), 1));
        System.out.println(swapNodes(createListNode(new int[]{1,2}), 1));
        System.out.println(swapNodes(createListNode(new int[]{1,2,3}), 2));
    }
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode v1 = new ListNode(-1, head), v2 = head, v3 = head;
        for(int i=0; i<k; i++){
            v1 = v1.next;
            v3 = v3.next ;
        }
        while(v3 != null){
            v3 = v3.next;
            v2 = v2.next;
        }
        int temp = v1.val;
        v1.val = v2.val;
        v2.val = temp;
        return head;
    }
    public static ListNode createListNode(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode output = new ListNode(nums[0]), current = output;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return output;
    }
}
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val +
                ", " + next;
    }
}
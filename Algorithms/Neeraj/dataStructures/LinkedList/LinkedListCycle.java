/*
Given a linked list, determine if it has a cycle in it.
To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode listNode = createListNode(new int[]{3, 2, 0, -4});
        joinListNode(listNode, 1);
        System.out.println(hasCycle(listNode));
        System.out.println(detectCycle(listNode));

        listNode = createListNode(new int[]{1});
        joinListNode(listNode, -1);
        System.out.println(hasCycle(listNode));

        listNode = createListNode(new int[]{1, 2});
        joinListNode(listNode, -1);
        System.out.println(hasCycle(listNode));

        listNode = createListNode(new int[]{1, 2});
        joinListNode(listNode, 0);
        System.out.println(hasCycle(listNode));
        System.out.println(detectCycle(listNode));
    }

    private static void joinListNode(ListNode listNode, int pos) {
        int index = 0;
        ListNode current = listNode, joiningNode = null;
        while (current != null) {
            if (index == pos) {
                joiningNode = current;
            }
            if (current.next == null) {
//                This is the last node.
                current.next = joiningNode;
                break;
            }
            current = current.next;
            index++;
        }
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

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

//        Single Pointer
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == Integer.MIN_VALUE) return curr;
            curr.val = Integer.MIN_VALUE;
            curr = curr.next;
        }

//        Two Pointer
//        ListNode firstPointer = head.next;
//        ListNode secondPointer = head.next != null ? head.next.next: null;
//        while (firstPointer != null || secondPointer != null){
//            if (firstPointer != null && secondPointer!= null && firstPointer.val == secondPointer.val){
//                return firstPointer.next;
//            }
//            firstPointer = firstPointer != null ? firstPointer.next: null;
//            secondPointer = (secondPointer != null && secondPointer.next!= null) ? secondPointer.next.next: null;
//        }
        return null;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

//        Single Pointer
//        ListNode curr = head;
//        while (curr != null) {
//            if (curr.val == Integer.MIN_VALUE) return true;
//            curr.val = Integer.MIN_VALUE;
//            curr = curr.next;
//        }

//        Two Pointer
        ListNode firstPointer = head.next;
        ListNode secondPointer = head.next != null ? head.next.next : null;
        while (firstPointer != null || secondPointer != null) {
            if (firstPointer != null && secondPointer != null && firstPointer.val == secondPointer.val) {
                return true;
            }
            firstPointer = firstPointer != null ? firstPointer.next : null;
            secondPointer = (secondPointer != null && secondPointer.next != null) ? secondPointer.next.next : null;
        }
        return false;
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
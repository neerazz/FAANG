import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Oct 13, 2020
 * Questions: https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3493/
 */

public class SortList {

    public static void main(String[] args) {
        System.out.println(sortList(createListNode(Arrays.asList(-1, 5, 3, 4, 0))));
        System.out.println(sortList(createListNode(Arrays.asList(4, 2, 1, 3))));
    }

    public static ListNode createListNode(List<Integer> nums) {
        if (nums.size() == 0) return null;
        ListNode listNode = new ListNode(nums.get(0)), listNodeRef = listNode;
        for (int i = 1; i < nums.size(); i++) {
            listNodeRef.next = new ListNode(nums.get(i));
            listNodeRef = listNodeRef.next;
        }
        return listNode;
    }

    public static ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode left = head, slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
//         Make a recursive call, to further split.
        ListNode left1 = sortList(left), right1 = sortList(right);
        return merge(left1, right1);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode op = new ListNode(-1), opRef = op;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                opRef.next = new ListNode(left.val);
                left = left.next;
            } else {
                opRef.next = new ListNode(right.val);
                right = right.next;
            }
            opRef = opRef.next;
        }
        if (left != null) opRef.next = left;
        if (right != null) opRef.next = right;
        return op.next;
    }
}

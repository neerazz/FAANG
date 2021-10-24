/**
 * Created on:  Jul 31, 2020
 * Questions: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {

    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode left = new ListNode(-1), leftRef = left, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            leftRef.next = new ListNode(slow.val);
            leftRef = leftRef.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode cur = new TreeNode(slow.val);
        cur.left = sortedListToBST(left.next);
        cur.right = sortedListToBST(slow.next);
        return cur;
    }
}

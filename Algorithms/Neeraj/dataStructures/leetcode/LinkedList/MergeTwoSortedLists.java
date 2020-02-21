package ds.LinkedList;

/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = RemoveNthNodeFromEndOfList.createListNode(new int[]{1, 2, 4});
        ListNode l2 = RemoveNthNodeFromEndOfList.createListNode(new int[]{1, 3, 4});
        System.out.println("Answer is:" + mergeTwoLists(l1, l2) + " should be [1,1,2,3,4,4]");

        l1 = RemoveNthNodeFromEndOfList.createListNode(new int[]{5});
        l2 = RemoveNthNodeFromEndOfList.createListNode(new int[]{1, 3, 4});
        System.out.println("Answer is:" + mergeTwoLists(l1, l2) + " should be [1,,3,4,5]");
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 != null && l2 == null) return l1;
        if (l1 == null && l2 != null) return l2;

        ListNode outputref = new ListNode(0), output = outputref;
        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    output.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    output.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                output = output.next;
            } else {
                if (l1 != null) {
                    output.next = new ListNode(l1.val);
                    output = output.next;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    output.next = new ListNode(l2.val);
                    output = output.next;
                    l2 = l2.next;
                }
            }
        }
        return outputref.next;
    }

    public static ListNode mergeTwoLists_optimal(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 != null && l2 == null) return l1;
        if (l1 == null && l2 != null) return l2;
        ListNode result = null;

        if (l1.val <= l2.val) {
            result = l1;
            l1 = l1.next;
        } else if (l1.val > l2.val) {
            result = l2;
            l2 = l2.next;
        }

        result.next = mergeTwoLists(l1, l2);
        return result;
    }
}

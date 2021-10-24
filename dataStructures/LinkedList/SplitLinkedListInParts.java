/**
 * Created on:  Sep 29, 2021
 * Ref: https://leetcode.com/problems/split-linked-list-in-parts/
 */
public class SplitLinkedListInParts {
    public static void main(String[] args) {

    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = len(head);
        int per = len / k, rem = len - per * k;
        ListNode[] result = new ListNode[k];
        ListNode cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            ListNode start = new ListNode(-1, cur), ref = start;
            for (int j = 0; j < per && ref != null; j++) {
                ref = ref.next;
            }
            if (rem-- > 0 && ref != null) ref = ref.next;
            ListNode next = ref != null ? ref.next : null;
            if (ref != null) ref.next = null;
            result[i] = start.next;
            cur = next;
        }
        return result;
    }

    int len(ListNode node) {
        int count = 0;
        ListNode cur = node;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}

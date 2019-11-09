package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        System.out.println(mergeKLists(new ListNode[]{
                createListNode(Arrays.asList(1, 4, 5)),
                createListNode(Arrays.asList(1, 3, 4)),
                createListNode(Arrays.asList(2, 6))
        }));
    }

    private static ListNode createListNode(List<Integer> nums) {
        if (nums.size() == 0) return null;
        ListNode listNode = new ListNode(nums.get(0)), listNodeRef = listNode;
        for (int i = 1; i < nums.size(); i++) {
            listNodeRef.next = new ListNode(nums.get(i));
            listNodeRef = listNodeRef.next;
        }
        return listNode;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode current = lists[i];
            while (current != null) {
                integers.add(current.val);
                current = current.next;
            }
        }
        Collections.sort(integers);
        return createListNode(integers);
    }
}

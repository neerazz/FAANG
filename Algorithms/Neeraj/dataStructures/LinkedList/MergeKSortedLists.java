import java.util.*;

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

        System.out.println(mergeKLists_rev3(new ListNode[]{
                createListNode(Arrays.asList(1, 4, 5)),
                createListNode(Arrays.asList(1, 3, 4)),
                createListNode(Arrays.asList(2, 6))
        }));

        System.out.println(mergeKLists_rev3(new ListNode[]{
                createListNode(Arrays.asList(-1, -1, -1)),
                createListNode(Arrays.asList(-2, -2, -1))
        }));
    }

    public static ListNode mergeKLists_rev3(ListNode[] lists) {
        ListNode op = new ListNode(-1), ref = op;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.val, n2.val));
        addAllNodes(lists, pq);
        while (!pq.isEmpty()) {
            addAllNodes(lists, pq);
            ref.next = new ListNode(pq.poll().val);
            ref = ref.next;
        }
        return op.next;
    }

    private static void addAllNodes(ListNode[] lists, PriorityQueue<ListNode> pq) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            pq.add(lists[i]);
            lists[i] = lists[i].next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int len = lists.length;
        Queue<ListNode> queue = new LinkedList<>();
        for (int i = 1; i < len; i++) {
            ListNode one = lists[i];
            ListNode two = i + 1 < len ? lists[i + 1] : null;
            queue.add(mergeSorted(one, two));
            i++;
        }
        while (!queue.isEmpty()) {
            ListNode one = queue.poll();
            ListNode two = queue.isEmpty() ? null : queue.poll();
            queue.add(mergeSorted(one, two));
            if (queue.size() == 1) {
                return queue.poll();
            }
        }
        return null;
    }

    private static ListNode mergeSorted(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode newNode = new ListNode(-1), nR = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                nR.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                nR.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            nR = nR.next;
        }
        if (l1 != null) nR.next = l1;
        if (l2 != null) nR.next = l2;
        return newNode.next;
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

    public static ListNode mergeKLists2(ListNode[] lists) {
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

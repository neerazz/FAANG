import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/
 */
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode[] listNodes = createListNodes(new int[]{4, 1, 8, 4, 5}, new int[]{5, 0, 1, 8, 4, 5}, 8, 2, 3);
        System.out.println(Arrays.toString(listNodes));
        System.out.println(findCommonIntersection(listNodes[0], listNodes[1]));
        listNodes = createListNodes(new int[]{0, 9, 1, 2, 4}, new int[]{3, 2, 4}, 2, 3, 1);
        System.out.println(Arrays.toString(listNodes));
        System.out.println(findCommonIntersection(listNodes[0], listNodes[1]));
        listNodes = createListNodes(new int[]{2, 6, 4}, new int[]{1, 5}, 0, 3, 2);
        System.out.println(Arrays.toString(listNodes));
        System.out.println(findCommonIntersection(listNodes[0], listNodes[1]));
    }

    /*
    Maintain two pointers pApA and pBpB initialized at the head of A and B, respectively. Then let them both traverse through the lists, one node at a time.
    When pApA reaches the end of a list, then redirect it to the head of B (yes, B, that's right.); similarly when pBpB reaches the end of a list, redirect it the head of A.
    If at any point pApA meets pBpB, then pApA/pBpB is the intersection node.
    To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} and B = {2,4,9,11}, which are intersected at node '9'. Since B.length (=4) < A.length (=6), pBpB would reach the end of the merged list first, because pBpB traverses exactly 2 nodes less than pApA does. By redirecting pBpB to head A, and pApA to head B, we now ask pBpB to travel exactly 2 more nodes than pApA would. So in the second iteration, they are guaranteed to reach the intersection node at the same time.
    If two lists have intersection, then their last nodes must be the same one. So when pApA/pBpB reaches the end of a list, record the last element of A/B respectively. If the two last elements are not the same one, then the two lists have no intersections.
     */
    public static ListNode getIntersectionNode_elegent(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = (pa != null) ? pa.next : headB;
            pb = (pb != null) ? pb.next : headA;
        }
        return pa;
    }

    //    Time complexity : O(m+n). Space complexity : O(m)O(m) or O(n)O(n).
    private static ListNode findCommonIntersection(ListNode headA, ListNode headB) {
        List<ListNode> listNodes = new ArrayList<>();

//        Iterate through the first Node and add to list.
        while (headA != null) {
            listNodes.add(headA);
            headA = headA.next;
        }
//        Iterate through the second Node and check that value is present in the list. If present then it is common point.
        while (headB != null) {
            if (listNodes.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    private static ListNode[] createListNodes(int[] numA, int[] numB, int intersectVal, int skipA, int skipB) {
        if (numA.length == 0) {
            return null;
        }
//        First Create the common list.
        ListNode commonList = createCommonList(numA, skipA);
//        Create Individual Nodes.
        ListNode firstNode = createOneListNode(numA, skipA, commonList);
        ListNode secondNode = createOneListNode(numB, skipB, commonList);
        return new ListNode[]{firstNode, secondNode};
    }

    private static ListNode createOneListNode(int[] nums, int skipA, ListNode commonList) {
        if (skipA == nums.length - 1) return commonList;
        if (nums.length > 1) {
            ListNode output = new ListNode(nums[0]), current = output;
            for (int i = 1; i < skipA; i++) {
                current.next = new ListNode(nums[i]);
                current = current.next;
            }
            current.next = commonList;
            return output;
        }
        return null;
    }

    private static ListNode createCommonList(int[] numA, int skipA) {
        if (skipA > 0 && skipA < numA.length) {
            ListNode commonList = new ListNode(numA[skipA]);
            ListNode currcommonList = commonList;
            for (int i = skipA + 1; i < numA.length; i++) {
                currcommonList.next = new ListNode(numA[i]);
                currcommonList = currcommonList.next;
            }
            return commonList;
        }
        return null;
    }
}

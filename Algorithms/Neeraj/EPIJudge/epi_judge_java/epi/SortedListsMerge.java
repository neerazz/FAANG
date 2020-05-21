package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class SortedListsMerge {

    @EpiTest(testDataFile = "sorted_lists_merge.tsv")
    //@include
    public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1,
                                                        ListNode<Integer> L2) {
        ListNode<Integer> op = new ListNode<>(-1, null), opRef = op;
        while (L1 != null && L2 != null) {
            if (L1.data <= L2.data) {
                opRef.next = L1;
                L1 = L1.next;
            } else {
                opRef.next = L2;
                L2 = L2.next;
            }
            opRef = opRef.next;
        }
        while (L1 != null) {
            opRef.next = L1;
            L1 = L1.next;
            opRef = opRef.next;
        }
        while (L2 != null) {
            opRef.next = L2;
            L2 = L2.next;
            opRef = opRef.next;
        }
        return op.next;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "SortedListsMerge.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

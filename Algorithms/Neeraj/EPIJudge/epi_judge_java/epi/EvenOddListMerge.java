package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class EvenOddListMerge {
    @EpiTest(testDataFile = "even_odd_list_merge.tsv")

    public static ListNode<Integer> evenOddMerge(ListNode<Integer> L) {
        if (L == null) return null;
        ListNode<Integer> op = new ListNode<>(-1, null), odd = new ListNode<>(-1, null), oddRef = odd, even = op;
        while (L != null) {
            even.next = new ListNode<>(L.data, null);
            L = L.next;
            even = even.next;
            if (L != null) {
                odd.next = new ListNode<>(L.data, null);
                L = L.next;
                odd = odd.next;
            }
        }
        even.next = oddRef.next;
        return op.next;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "EvenOddListMerge.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

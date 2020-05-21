package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class ReverseSublist {
    @EpiTest(testDataFile = "reverse_sublist.tsv")

    public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start,
                                                   int finish) {
        ListNode<Integer> op = new ListNode<>(-1, L), opRef = op;
        int index = 1;
//        Fast Forward the Reference node till start;
        while (index < start) {
            opRef = opRef.next;
            index++;
        }
//        Reverse the index till end.
        ListNode<Integer> rvs = opRef.next;
        while (index < finish) {
            ListNode<Integer> temp = rvs.next;
            rvs.next = temp.next;
            temp.next = opRef.next;
            opRef.next = temp;
            index++;
        }
//        Attach the remaining to the end.
        return op.next;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "ReverseSublist.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

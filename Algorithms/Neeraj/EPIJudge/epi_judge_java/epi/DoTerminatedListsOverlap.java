package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;
public class DoTerminatedListsOverlap {

    public static ListNode<Integer> overlappingNoCycleLists(ListNode<Integer> l0, ListNode<Integer> l1) {
        ListNode<Integer> l0Ref = l0, l1Ref = l1;
        while (l0 != l1) {
            l0 = l0 == null ? l1Ref : l0.next;
            l1 = l1 == null ? l0Ref : l1.next;
        }
        return l1;
    }

    @EpiTest(testDataFile = "do_terminated_lists_overlap.tsv")
    public static void
    overlappingNoCycleListsWrapper(TimedExecutor executor, ListNode<Integer> l0,
                                   ListNode<Integer> l1, ListNode<Integer> common)
            throws Exception {
        if (common != null) {
            if (l0 != null) {
                ListNode<Integer> i = l0;
                while (i.next != null) {
                    i = i.next;
                }
                i.next = common;
            } else {
                l0 = common;
            }

            if (l1 != null) {
                ListNode<Integer> i = l1;
                while (i.next != null) {
                    i = i.next;
                }
                i.next = common;
            } else {
                l1 = common;
            }
        }

        ListNode<Integer> finalL0 = l0;
        ListNode<Integer> finalL1 = l1;
        ListNode<Integer> result =
                executor.run(() -> overlappingNoCycleLists(finalL0, finalL1));

        if (result != common) {
            throw new TestFailure("Invalid result");
        }
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "DoTerminatedListsOverlap.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

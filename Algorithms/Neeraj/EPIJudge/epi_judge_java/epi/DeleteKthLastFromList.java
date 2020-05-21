package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class DeleteKthLastFromList {

    @EpiTest(testDataFile = "delete_kth_last_from_list.tsv")
    // Assumes L has at least k nodes, deletes the k-th last node in L.
    public static ListNode<Integer> removeKthLast(ListNode<Integer> L, int k) {
        ListNode<Integer> p1 = new ListNode<Integer>(-1, L), p2 = p1, op = p1;
//        Advance p2 to k;
        int i = 0;
        while (i < k) {
            p2 = p2.next;
            i++;
        }
//        Advance both pointer.
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return op.next;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "DeleteKthLastFromList.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class IsListPalindromic {
    @EpiTest(testDataFile = "is_list_palindromic.tsv")

    public static boolean isLinkedListAPalindrome(ListNode<Integer> L) {
        if (L == null) return true;
        ListNode<Integer> slow = L, fast = L;
//        Advance to middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode<Integer> reverse = getReverse(slow), original = L;
        while (original != null && reverse != null) {
            if (!original.data.equals(reverse.data)) {
                return false;
            }
            original = original.next;
            reverse = reverse.next;
        }
        return true;
    }

    private static ListNode<Integer> getReverse(ListNode<Integer> L) {
        ListNode<Integer> pre = null;
        ListNode<Integer> cur = L;
        while (cur != null) {
            ListNode<Integer> nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IsListPalindromic.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

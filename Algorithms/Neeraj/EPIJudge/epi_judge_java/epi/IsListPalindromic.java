package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class IsListPalindromic {
    @EpiTest(testDataFile = "is_list_palindromic.tsv")

    public static boolean isLinkedListAPalindrome(ListNode<Integer> L) {
        if (L == null) return true;
        ListNode<Integer> reverse = getReverse(L);
        System.out.println("Input   : " + L.toString());
        System.out.println("Reverse : " + reverse.toString());
        while (L != null && reverse != null) {
            if (L.data != reverse.data) {
                return false;
            }
            L = L.next;
            reverse = reverse.next;
        }
        return L == reverse;
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

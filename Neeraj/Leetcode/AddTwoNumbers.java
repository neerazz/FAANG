import java.util.*;

/*
Problem: https://leetcode.com/problems/add-two-numbers/
Sample: (3 2 4 3 5 6 4)
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCount = Integer.parseInt(scanner.next());

        Integer[] first = new Integer[totalCount];
        Integer[] second = new Integer[totalCount];
        for (int i = 0; i < totalCount; i++) first[i] = Integer.parseInt(scanner.next());
        for (int i = 0; i < totalCount; i++) second[i] = Integer.parseInt(scanner.next());
        System.out.println(addTwoNumbers(createListNodeFromArray(first), createListNodeFromArray(second)));
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> sum = new ArrayList<>();
        checkNextNumberValue(sum,l1, l2,0);
        return createListNodeFromArray(sum.toArray());
    }

    static void checkNextNumberValue(List<Integer> result, ListNode l1, ListNode l2, int i) {
        if (l1.next != null && l2.next != null){
            checkNextNumberValue(result, l1.next, l2.next, i+1);
        }
        result.add(i,calculateValue(l1,l2));
    }

    static int calculateValue(ListNode l1, ListNode l2){
        return (l1.val + l2.val)%10;
    }

    public static ListNode createListNodeFromArray(Object[] array){
        ListNode[] temp = new ListNode[array.length];
        for (int i = 0; i < array.length; i++) temp[i] = new ListNode((Integer) array[i]);
        ListNode previous = null;
        ListNode current = null;

        for (int i = array.length -1; i >= 0; i--) {
            previous = current;
            current = temp[i];
            current.next = previous;
        }
        return current;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}

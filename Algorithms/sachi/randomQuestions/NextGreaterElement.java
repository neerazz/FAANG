package randomQuestions;

import util.ListNode;
import util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Input:  [2,1,5]
 * Output: [5,5,0]
 * <p>
 * Input:  [2,7,4,3,5]
 * Output: [7,0,5,5,0]
 * <p>
 * <p>
 * Input:  [1,7,5,1,9,2,5,1]
 * Output: [7,9,9,9,0,5,0,0]
 * <p>
 * <p>
 * * Input:  [1,7,5,1,9,2,5,1]
 * * Output: [7,9,9,9,0,5,0,0]
 */

public class NextGreaterElement {

    public static void main(String[] args) {
        ListNode node = Util.createLinkedListFromArray(new int[]{2, 1, 5});
        int[] sol = nextLargerNodes(node);
        Util.print(sol);

    }

    public static int[] nextLargerNodes(ListNode head) {

        List<Integer> list = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            list.add(node.val);
        }

        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < list.size(); ++i) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                res[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }

}



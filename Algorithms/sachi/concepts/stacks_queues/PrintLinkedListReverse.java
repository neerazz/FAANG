package concepts.stacks_queues;

import util.ListNode;

import java.util.Deque;
import java.util.LinkedList;

//EPI - Sample Question
public class PrintLinkedListReverse {

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);

        printLinkedListReverse(root);
    }

    private static void printLinkedListReverse(ListNode root) {
        Deque<ListNode> stack = new LinkedList<>();
        while (root != null) {
            stack.push(root);
            root = root.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().val);
        }
    }
}

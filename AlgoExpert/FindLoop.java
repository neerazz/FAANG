/**
 * Created on:  Aug 17, 2020
 * Questions: https://www.algoexpert.io/questions/Find%20Loop
 */
public class FindLoop {
    public static void main(String[] args) {

    }

    public static LinkedList findLoop(LinkedList head) {
        LinkedList slow = head.next;
        LinkedList fast = head.next.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}

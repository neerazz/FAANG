/**
 * Created on:  Sep 05, 2020
 * Questions: https://www.algoexpert.io/questions/Shift%20Linked%20List
 */
public class ShiftLinkedList {
    public static void main(String[] args) {

    }

    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        int len = getLength(head);
        k = k % len;
        if (k == 0) return head;
        if (k < 0) {
            k *= -1;
            LinkedList p1 = head;
            int i = 0;
            while (i < k - 1) {
                p1 = p1.next;
                i++;
            }
            LinkedList op = new LinkedList(-1);
            op.next = p1.next;
            LinkedList opRef = op;
            while (opRef.next != null) {
                opRef = opRef.next;
            }
            p1.next = null;
            opRef.next = head;
            return op.next;
        } else {
            LinkedList p1 = head, p2 = head;
            int i = 0;
            while (i < k) {
                p2 = p2.next;
                i++;
            }
            while (p2.next != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            LinkedList op = new LinkedList(-1);
            op.next = p1.next;
            p2.next = head;
            p1.next = null;
            return op.next;
        }
    }

    private static int getLength(LinkedList head) {
        LinkedList ref = head;
        int len = 0;
        while (ref != null) {
            ref = ref.next;
            len++;
        }
        return len;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }
}

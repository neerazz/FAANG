/**
 * Created on:  Sep 09, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=623634548182866
 */
public class ReverseOperations {
    public static void main(String[] args) {
        System.out.println(reverse(createLinkedList(new int[]{2, 18, 24, 3, 5, 7, 9, 6, 12})));
    }

    static Node createLinkedList(int[] arr) {
        Node head = null;
        Node tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }

    static Node reverse(Node head) {
        Node op = new Node(-1), opRef = op;
        while (head != null) {
//            Check if the current node is even.
            if (head.data % 2 == 0) {
                Node evenStart = new Node(-1), ref = evenStart;
                while (head != null && head.data % 2 == 0) {
                    ref.next = new Node(head.data);
                    ref = ref.next;
                    head = head.next;
                }
//                Reverse the nodes between start and end.
                Node reverse = reverseNode(evenStart.next);
//                Assign all the reversed values to opRef.
                while (reverse != null) {
                    opRef.next = reverse;
                    reverse = reverse.next;
                    opRef = opRef.next;
                }
            }
            if (head != null && head.data % 2 == 1) {
                opRef.next = head;
                opRef = opRef.next;
                head = head.next;
            }
        }
        return op.next;
    }

    private static Node reverseNode(Node head) {
        Node output = null, cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = output;
            output = cur;
            cur = next;
        }
        return output;
    }

    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }

        @Override
        public String toString() {
            return data + " -> " + next;
        }
    }
}

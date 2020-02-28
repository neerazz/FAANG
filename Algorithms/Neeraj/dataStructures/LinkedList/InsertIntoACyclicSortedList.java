/*
Given a node from a cyclic linked list which is sorted in ascending order, write a function to insert a value into the list such that it remains a cyclic sorted list.
The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the cyclic list.
If there are multiple suitable places for insertion, you may choose any place to insert the new value.
After the insertion, the cyclic list should remain sorted.
If the list is empty (i.e., given node is null), you should create a new single cyclic list and return the reference to that single node.
Otherwise, you should return the original given node.
The following example may help you understand the problem better:
 */
public class InsertIntoACyclicSortedList {
    public static void main(String[] args) {
        Node one = new Node(1, null);
        Node two = new Node(2, null);
        Node three = new Node(3, null);
        Node four = new Node(4, null);
        Node five = new Node(5, null);
        three.next = four;
        four.next = one;
        one.next = three;
        System.out.println("Answer is :" + insert(three, 2) + " should be [3,4,1,2,Loop].");
        three = new Node(3, null);
        Node three1 = new Node(3, null);
        Node three2 = new Node(3, null);
        three.next = three1;
        three1.next = three2;
        three2.next = three;
        System.out.println("Answer is :" + insert(three, 0) + " should be [0,3,3,3,Loop].");
        one.next = new Node(1, one);
        System.out.println("Answer is :" + insert(one, 0) + " should be [0,1,1,Loop].");
    }

    public static Node insert(Node head, int insertVal) {
        if (head == null) return new Node(insertVal, null);
        Node temp = head;
        while (temp.val > insertVal || temp.next.val < insertVal) {
            if ((temp.next.val < temp.val)
                    && (insertVal <= temp.next.val || insertVal >= temp.val)) break;
            temp = temp.next;
            if (head == temp) break;
        }
        Node insert = new Node(insertVal, temp.next);
        temp.next = insert;
        return head;
    }

    public static Node insert_wrong(Node head, int insertVal) {
        if (head == null) return new Node(insertVal, null);
        Node headRef = head, starting = head, next = head.next, fast = head.next;

        while (headRef != null) {
            if (insertVal <= next.val && (starting.val < insertVal || starting.val > insertVal)) {
                starting.next = new Node(insertVal, next);
                break;
            }
            if (starting == fast) {
//                Reached the last node, inserted the new node before the beginning.
                starting.next = new Node(insertVal, starting.next);
                break;
            }
            headRef = headRef.next;
            starting = next;
            next = next.next;
            fast = fast.next.next;
        }
        return head;
    }

    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}

package LinkedList;

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
        Node three = new Node(3, null);
        Node four = new Node(4, null);
        one.next = three;
        three.next = four;
        four.next = one;
        System.out.println("Answer is :" + insert(one, 2) + " should be [1,2,3,4,Loop].");
        three = new Node(3, null);
        Node three1 = new Node(3, null);
        Node three2 = new Node(3, null);
        three.next = three1;
        three1.next = three2;
        three2.next = three;
        System.out.println("Answer is :" + insert(three, 0) + " should be [0,3,3,3,Loop].");
        one.next = new Node(1, one);
        System.out.println("Answer is :" + insert(one, 0) + " should be [0,3,3,3,Loop].");
    }

    public static Node insert(Node head, int insertVal) {
        if (head == null) return new Node(insertVal, null);
        if (head.val > insertVal) {
//            Insert the new Node at the start, and loop till the last node to link it back to the newly inserted node.
            Node headRef = head, slow = head, fast = head.next;
            headRef = new Node(insertVal, head);
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast || fast == head) {
//                    This is the last node.
                    slow.next = headRef;
                    return headRef;
                }
            }
        }
        Node headRef = head, starting = head, next = head.next;
        while (next != null) {
            if (starting.val < insertVal && insertVal <= next.val) {
                starting.next = new Node(insertVal, next);
                break;
            }
            headRef = headRef.next;
            starting = next;
            next = next.next;
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

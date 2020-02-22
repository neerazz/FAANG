public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);           // linked list becomes 1->2->3
        System.out.println(linkedList.get(1));           // returns 2
        linkedList.deleteAtIndex(1);                     // now the linked list is 1->3
        System.out.println(linkedList.get(1));           // returns 3

        System.out.println("=========================================");
        linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(2));

        System.out.println("=========================================");
        linkedList = new MyLinkedList();
        linkedList.get(0);
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
    }
}

class MyLinkedList {
    int length;
    Node head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        length = 0;
        head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < length && index >= 0) {
            Node cur = head;
            while (index > 0) {
                cur = cur.next;
                index--;
            }
            return cur.val;
        } else return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newnode = new Node(val);
        newnode.next = head;
        head = newnode;
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newnode = new Node(val);
        length++;
        if (head == null) {
            head = newnode;
            /*head.next = null;*/
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newnode;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > length) return;
        if (index < 0) {
            addAtHead(val);
            length++;
        } else {
            Node dmy = new Node(-1);
            dmy.next = head;
            Node cur = dmy;
            while (index > 0) {
                cur = cur.next;
                index--;
            }
            Node newnode = new Node(val);
            Node temp = cur.next;
            cur.next = newnode;
            newnode.next = temp;
            head = dmy.next;
            length++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < length && index >= 0) {
            length--;
            Node dmy = new Node(0);
            dmy.next = head;
            Node cur = dmy;
            while (index > 0) {
                cur = cur.next;
                index--;
            }
            cur.next = cur.next.next;
            head = dmy.next;
        } else return;
    }

    class Node {
        int val;
        Node next;

        public Node(int v) {
            val = v;
        }
    }
}
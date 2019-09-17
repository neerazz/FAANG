public class DoublyLinkedList {

    private int size;
    private DoublyListNode head, tail;
    DoublyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.addAtIndex(-1, 0);
        myList.get(0);
        myList.deleteAtIndex(-1);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is
     * invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        if (index == 0)
            return head.val;
        if (index == size - 1)
            return tail.val;
        DoublyListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After
     * the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        DoublyListNode elem = new DoublyListNode(val);
        if (size == 0) {
            head = elem;
            tail = elem;
        } else if (size == 1) {
            head = elem;
            head.next = tail;
            tail.prev = head;
        } else {
            DoublyListNode temp = head;
            head = elem;
            head.next = temp;
            temp.prev = elem;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        DoublyListNode elem = new DoublyListNode(val);
        if (size == 0) {
            head = elem;
            tail = elem;
        } else if (size == 1) {
            tail = elem;
            head.next = tail;
            tail.prev = head;
        } else {
            DoublyListNode temp = tail;
            tail = elem;
            temp.next = tail;
            tail.prev = temp;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index
     * equals to the length of linked list, the node will be appended to the end of
     * linked list. If index is greater than the length, the node will not be
     * inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            DoublyListNode elem = new DoublyListNode(val);
            DoublyListNode curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            DoublyListNode second = curr.next;
            elem.next = second;
            elem.prev = curr;
            curr.next = elem;
            second.prev = elem;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        if (index == 0 && size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            DoublyListNode newHead = head.next;
            newHead.prev = null;
            head = newHead;
        } else if (index == size - 1) {
            DoublyListNode newTail = tail.prev;
            newTail.next = null;
            tail = newTail;
        } else {
            DoublyListNode remove = head;
            for (int i = 0; i < index; i++) {
                remove = remove.next;
            }
            DoublyListNode newPrev = remove.prev;
            DoublyListNode newNext = remove.next;
            newPrev.next = newNext;
            newNext.prev = newPrev;
        }
        size--;
    }

    static class DoublyListNode {
        int val;
        DoublyListNode prev, next;

        DoublyListNode(int x) {
            val = x;
        }
    }

}
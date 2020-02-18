package ds.revision;

import java.util.List;

public class LinkedListProblems {
    public static void main(String[] args) {
//        MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
//        linkedList.addAtHead(1);
//        linkedList.addAtTail(3);
//        linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
//        System.out.println(linkedList.get(1));            // returns 2
////        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
////        System.out.println(linkedList.get(1));            // returns 3
//        linkedList.deleteAtIndex(0);  // now the linked list is 2->3
//        System.out.println(linkedList.get(0));            // returns 2
//
//        linkedList = new MyLinkedList(); // Initialize empty LinkedList
//        linkedList.addAtHead(1);
//        linkedList.deleteAtIndex(1);  // now the linked list is 1->3
//        System.out.println(hasCycle(createListNode(Arrays.asList(3,2,0,-4))));
//        System.out.println(reverseList(createListNode(Arrays.asList(1,2,3,4,5))));
//        System.out.println(removeElements(createListNode(Arrays.asList(1,2,6,3,4,5,6)),6));
//        System.out.println(removeElements(createListNode(Arrays.asList(1)),1));
//        System.out.println(removeElements(createListNode(Arrays.asList(1,2)),1));
//        System.out.println(oddEvenList(createListNode(Arrays.asList(1,2,3,4,5,6,7))));
//        System.out.println(isPalindrome(createListNode(Arrays.asList(1,2))));
//        System.out.println(isPalindrome(createListNode(Arrays.asList(1,2,3,3,2,1))));
//        System.out.println(isPalindrome(createListNode(Arrays.asList(1,2,3,0,3,2,1))));
//        System.out.println(isPalindrome(createListNode(Arrays.asList(1, 2, 3, 0, 3, 3, 1))));
    }

    static String encryption(String string) {
        int row = (int) Math.floor(Math.sqrt(string.length()));
        int column = (int) Math.ceil(Math.sqrt(string.length()));
        if (row * column < string.length()) row = column;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < column; i++) {
            for (int j = i; j < string.length(); j = j + column) {
                stringBuilder.append(string.charAt(j));
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
//        Traverse the list and find length.
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
//        Traverse till half of the list.
        ListNode output = null, current = head, temp = null;
        int index = 0;
        while (index < length) {
            if (index < length / 2) {
//                Till the half point is reached reverse the list and store into output.
                temp = current.next;
                current.next = output;
                output = current;
                current = temp;
            } else if (index > length / 2) {
//                Once the half point is crossed then start comparing the reversed value with the current values.
                if (output.val != current.val) {
                    return false;
                }
                output = output.next;
                current = current.next;
            } else if (length % 2 == 1) {
//                When the list has odd number. Then ignore the center value.
                current = current.next;
            }
            index++;
        }
        return output == null || current == null || output.val == current.val;
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head, oddRef = new ListNode(0), odd = oddRef, evenRef = new ListNode(0), even = evenRef;
        while (cur != null) {
            if (cur.val % 2 == 0) {
                even.next = new ListNode(cur.val);
                even = even.next;
            } else {
                odd.next = new ListNode(cur.val);
                odd = odd.next;
            }
            cur = cur.next;
        }
        odd.next = evenRef.next;
        return oddRef.next;
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode current = head, outputRef = new ListNode(head.val), output = outputRef;
        while (current != null) {
            current = current.next;
            if (current != null && current.val != val) {
                output.next = new ListNode(current.val);
                output = output.next;
            }
        }
        return head.val == val ? outputRef.next : outputRef;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode current = head, temp = null, output = null;
        while (current != null) {
            temp = current.next;
            current.next = output;
            output = current;
            current = temp;
        }
        return output;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == Integer.MIN_VALUE) return curr;
            curr.val = Integer.MIN_VALUE;
            curr = curr.next;
        }
        return null;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast && slow != null && fast != null) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow == fast;
    }

    private static ListNode createListNode(List<Integer> nums) {
        if (nums.size() == 0) return null;
        ListNode listNode = new ListNode(nums.get(0)), listNodeRef = listNode;
        for (int i = 1; i < nums.size(); i++) {
            listNodeRef.next = new ListNode(nums.get(i));
            listNodeRef = listNodeRef.next;
        }
        return listNode;
    }
}

class MyLinkedList {

    private Node head;
    private int count;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = null;
        count = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node nodeAtIndex = getNodeAtIndex(index);
        return nodeAtIndex != null ? nodeAtIndex.val : -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        count++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newnode = new Node(val);
        count++;
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
        if (index == 0) {
            addAtHead(val);
        } else {
            Node newNode = new Node(val);
            int i = 0;
            Node headRef = head;
//        Get the Node before Index.
            while (i < index - 1) {
                headRef = headRef.next;
                i++;
            }
            newNode.next = headRef.next;
            headRef.next = newNode;
        }
        count++;
    }

    private Node getNodeAtIndex(int index) {
        int i = 0;
        Node headRef = head;
        while (i < index) {
            headRef = headRef.next;
            i++;
        }
        return headRef;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < count && index >= 0) {
            count--;
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
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        @Override
        public String toString() {
            return "val=" + val;
        }
    }
}
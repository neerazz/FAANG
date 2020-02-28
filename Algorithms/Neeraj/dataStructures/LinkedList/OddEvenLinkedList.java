/*
Given a singly linked list, group all odd nodes together followed by the even nodes.
"Please note here we are talking about the node number and not the value in the nodes".
You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:
Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:
The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode listNode = RemoveNthNodeFromEndOfList.createListNode(new int[]{1, 2, 6, 3, 4, 5, 6});
        System.out.println("Answer is: " + oddEvenList(listNode) + " should be [1,3,5,2,4]");
        listNode = RemoveNthNodeFromEndOfList.createListNode(new int[]{2, 1, 3, 5, 6, 4, 7});
        System.out.println("Answer is: " + oddEvenList(listNode) + " should be [2,3,6,7,1,5,4]");
    }

    public static ListNode oddEvenList(ListNode head) {
        return null;
    }
}

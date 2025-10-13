# Linked Lists

A linked list is a linear data structure where elements are not stored in contiguous memory locations. Instead, each element (node) contains a data field and a reference (or link) to the next node in the sequence.

## Types of Linked Lists

*   **Singly Linked List:** Each node points only to the next node.
*   **Doubly Linked List:** Each node points to both the next and the previous node.
*   **Circular Linked List:** The last node points back to the first node, forming a circle.

## Complexity Analysis

| Operation | Singly Linked List | Doubly Linked List |
| :--- | :--- | :--- |
| **Access** | O(n) | O(n) |
| **Search** | O(n) | O(n) |
| **Insertion (Head)** | O(1) | O(1) |
| **Insertion (Tail)** | O(n) / O(1)* | O(1)* |
| **Deletion (Head)** | O(1) | O(1) |
| **Deletion (Node)** | O(n) (search) | O(1) (if node is given) |

*\*With a tail pointer.*

## Problem Identification

Linked lists are useful when you need:
*   Dynamic size.
*   Frequent insertions and deletions at the beginning or end.
*   To avoid the overhead of resizing a contiguous array.

Common scenarios involve representing sequences, managing tasks, or implementing other data structures like stacks and queues.

## Common Patterns and Templates

### Template 1: Fast & Slow Pointers

This pattern is used to solve problems like finding the middle of a linked list or detecting a cycle.

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle
    }
}
```

**Example Problem:** [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
*(Solution file `LinkedListCycle.java` is in this directory)*

### Template 2: In-place Reversal

This pattern reverses the list by iterating through it and changing the `next` pointers of each node.

```java
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}
```

**Example Problem:** [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)
*(Solution file `ReverseLinkedList.java` is in this directory)*

### Template 3: Dummy Head Node

A dummy head is a placeholder node at the beginning of the list. It simplifies edge cases for insertion and deletion, especially at the head.

```java
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        // Advance first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
```

**Example Problem:** [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
*(Solution file `RemoveNthNodeFromEnd.java` is in this directory)*

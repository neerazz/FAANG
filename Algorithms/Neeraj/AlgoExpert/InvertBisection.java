import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 27, 2021
 * Questions: https://www.algoexpert.io/assessments/Inverted%20Bisection
 * Write a function that takes in the head of a Singly Linked List, inverts its bisection in place (i.e., doesn't create a brand new list), and returns its new head.
 * <p>
 * Inverting a Linked List's bisection means inverting the order of the nodes in the list's two halves; see the sample inputs and outputs for examples.
 * <p>
 * Each LinkedList node has an integer value as well as a next node pointing to the next node in the list or to None / null if it's the tail of the list.
 * <p>
 * You can assume that the input Linked List will always have at least one node; in other words, the head will never be None / null.
 * <p>
 * Sample Input #1
 * head = 0 -> 1 -> 2 -> 3 -> 4 -> 5 // the head node with value 0
 * Sample Output #1
 * 2 -> 1 -> 0 -> 5 -> 4 -> 3 // the new head node with value 2
 * Sample Input #2
 * head = 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 // the head node with value 0
 * Sample Output #2
 * 2 -> 1 -> 0 -> 3 -> 6 -> 5 -> 4 // the new head node with value 2
 */

public class InvertBisection {

    public static void main(String[] args) {

    }

    public static LinkedList invertedBisection(LinkedList head) {
        int len = 0;
        LinkedList temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int mid = len / 2;
        LinkedList first = head, second = head;
        for (int i = 0; i < mid; i++) {
            second = second.next;
        }
        // System.out.println("first : " + first);
        if (len < 2) return head;
        // System.out.println("second : " + second);
        LinkedList op = reverse(first, mid);
        LinkedList midList = null;
        if (len % 2 == 1) {
            midList = second;
            midList.next = reverse(second.next, mid);
        } else {
            midList = reverse(second, mid);
        }
        LinkedList ref = op;
        // System.out.println("op : " + op);
        int count = 0;
        while (count < mid - 1) {
            ref = ref.next;
            count++;
        }
        ref.next = midList;
        return op;
    }

    static LinkedList reverse(LinkedList head, int count) {
        // System.out.print("Reversing : " + head);
        LinkedList op = null, cur = head;
        while (cur != null && count-- > 0) {
            LinkedList next = cur.next;
            cur.next = op;
            op = cur;
            cur = next;
        }
        // System.out.print(" Result : " + op + " \n");
        return op;
    }

    // This is an input class. Do not edit.
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }

        public String toString() {
            return value + " " + (next == null ? " null" : next.toString());
        }
    }
}

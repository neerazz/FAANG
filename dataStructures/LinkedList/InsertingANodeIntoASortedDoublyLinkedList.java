/*
    Created on:  Apr 20, 2020
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Questions: https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem
 */
public class InsertingANodeIntoASortedDoublyLinkedList {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = null;                // Reading input from STDIN
        while ((first = br.readLine()) != null) {
            String[] vals = first.split("\\s+");
            System.out.println(new BigInteger(vals[0]).add(new BigInteger(vals[1])));
        }


        DoublyLinkedListNode one = new DoublyLinkedListNode(1);
        DoublyLinkedListNode two = new DoublyLinkedListNode(2);
        DoublyLinkedListNode four = new DoublyLinkedListNode(4);
        one.next = four.prev = two;
        two.next = four;
        two.prev = one;
        System.out.println(sortedInsert(one, 3));
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (head == null) return newNode;
        if (data < head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        } else {
            DoublyLinkedListNode rec = sortedInsert(head.next, data);
            head.next = rec;
            rec.prev = head;
            return head;
        }
    }

    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "DoublyLinkedListNode{" +
                    "data=" + data + '}';
        }
    }
}

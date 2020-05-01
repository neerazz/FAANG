package virtualOnline;
/*
    Created on:  Apr 30, 2020
 */

import java.util.HashMap;
import java.util.Map;

public class Question2 {
    public static void main(String[] args) {

    }

    /**
     * Lambdas & memoization:
     *  Check if the value is already processed, if not then call the evel method to process the
     * Implement an LRU Cache
     */
    public Object evel(String fnWithParams) {
        return "";
    }

    static class LRUCache {

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
        }

        private void addNode(DLinkedNode node) {
            /**
             * Always add the new node right after head.
             */
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            /**
             * Remove an existing node from the linked list.
             */
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(DLinkedNode node) {
            /**
             * Move certain node in between to the head.
             */
            removeNode(node);
            addNode(node);
        }

        private DLinkedNode popTail() {
            /**
             * Pop the current tail.
             */
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            // head.prev = null;

            tail = new DLinkedNode();
            // tail.next = null;

//        having a blank linked list
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) return -1;

            // move the accessed node to the head;
            moveToHead(node);

            return node.value;
        }

        public void evict(int key) {
            DLinkedNode tail = popTail();
            cache.remove(tail.key);
            --size;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);

            if (node == null) {
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;

                cache.put(key, newNode);
                addNode(newNode);

                ++size;

                if (size > capacity) {
                    evict(key);
                }
            } else {
                // update the value.
                node.value = value;
                moveToHead(node);
            }
        }
    }

}

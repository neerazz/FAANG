import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Aug 10, 2020
 * Questions: https://www.algoexpert.io/questions/LRU%20Cache
 */
public class LRUCacheImpl {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.insertKeyValuePair("b", 2);
        lruCache.insertKeyValuePair("a", 1);
        lruCache.insertKeyValuePair("c", 3);
        System.out.println(lruCache.getMostRecentKey());
        System.out.println(lruCache.getValueFromKey("a"));
        System.out.println(lruCache.getMostRecentKey());
        lruCache.insertKeyValuePair("d", 4);
        System.out.println(lruCache.getValueFromKey("b"));
        lruCache.insertKeyValuePair("a", 5);
        System.out.println(lruCache.getValueFromKey("a"));

        LRUCache lruCache2 = new LRUCache(1);
        lruCache2.insertKeyValuePair("b", 2);
        lruCache2.insertKeyValuePair("a", 1);
        lruCache2.insertKeyValuePair("c", 3);
        System.out.println(lruCache2.getMostRecentKey());
        System.out.println(lruCache2.getValueFromKey("a"));
        System.out.println(lruCache2.getMostRecentKey());
        lruCache2.insertKeyValuePair("d", 4);
        System.out.println(lruCache2.getValueFromKey("b"));
        lruCache2.insertKeyValuePair("a", 5);
        System.out.println(lruCache2.getValueFromKey("a"));
    }

    static class LRUCache {

        /**
         * Add a node:
         * If below size:
         * 1. If present: then get the node from map, delete the node, add to top.
         * 2. If not present: create a node, and add to top.
         * Else:
         * Delete the tail node. And then perform the above two steps.
         * <p>
         * Get Node based on key:
         * If present, get the node. delete from the current position and add to top.
         * Else: Return null
         */

        int maxSize;
        Node head, tail;
        Map<String, Node> map;

        public LRUCache(int maxSize) {
            this.maxSize = Math.max(maxSize, 1);
            map = new HashMap<>();
        }

        public void insertKeyValuePair(String key, int value) {
            if (map.size() == maxSize) {
                removeNode(map.remove(tail.key));
            }
            Node node;
            if (map.containsKey(key)) {
                node = map.get(key);
                node.value = value;
                removeNode(node);
            } else {
                node = new Node(key, value);
            }
            addFirst(node);
            map.put(key, node);
        }

        private void addFirst(Node node) {
            if (head == null && tail == null) {
                head = tail = node;
                head.next = tail;
                tail.pre = head;
            } else if (head == tail) {
                tail.pre = node;
                head = node;
                head.next = tail;
            } else {
                node.next = head;
                head.pre = node;
                head = node;
            }
        }

        private void removeNode(Node node) {
            if (head == tail) {
                head = tail = null;
            } else if (head == node) {
                head = head.next;
                head.pre = null;
            } else if (tail == node) {
                tail = tail.pre;
                tail.next = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
        }

        public LRUResult getValueFromKey(String key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                removeNode(node);
                addFirst(node);
                return new LRUResult(true, node.value);
            }
            return null;
        }

        public String getMostRecentKey() {
            return head == null ? null : head.key;
        }

        static class Node {
            Node pre, next;
            String key;
            int value;

            public Node(String key, int value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                return "Node{" +
                        ", key='" + key + '\'' +
                        ", value=" + value +
                        '}';
            }
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }

        @Override
        public String toString() {
            return "LRUResult{" +
                    "found=" + found +
                    ", value=" + value +
                    '}';
        }
    }
}

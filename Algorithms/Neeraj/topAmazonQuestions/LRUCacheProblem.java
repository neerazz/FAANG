import java.util.*;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
The cache is initialized with a positive capacity.
Follow up:
Could you do both operations in O(1) time complexity?
 */
public class LRUCacheProblem {
    public static void main(String[] args) {
        System.out.println("************************************ Method 1 ******************************");
        LRUCache cache = new LRUCache(2 /* capacity */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

        System.out.println("************************************ Method 2 ******************************");
        LRUCache_rev lruCacheRev = new LRUCache_rev(2 /* capacity */);
        lruCacheRev.put(1, 1);
        lruCacheRev.put(2, 2);
        System.out.println(lruCacheRev.get(1));       // returns 1
        lruCacheRev.put(3, 3);    // evicts key 2
        System.out.println(lruCacheRev.get(2));       // returns -1 (not found)
        lruCacheRev.put(4, 4);    // evicts key 1
        System.out.println(lruCacheRev.get(1));       // returns -1 (not found)
        System.out.println(lruCacheRev.get(3));       // returns 3
        System.out.println(lruCacheRev.get(4));       // returns 4
        System.out.println("************************************ Method 2: Ex2 ******************************");
        lruCacheRev = new LRUCache_rev(1 /* capacity */);
        lruCacheRev.put(2, 1);
        System.out.println(lruCacheRev.get(2));       // returns 1
        lruCacheRev.put(3, 2);    // evicts key 2
        System.out.println(lruCacheRev.get(2));       // returns -1 (not found)
        System.out.println(lruCacheRev.get(3));       // returns 3

        System.out.println("************************************ Method 3 ******************************");
        LRUCache_rev2 lruCacheRev2 = new LRUCache_rev2(2 /* capacity */);
//        lruCacheRev2.put(1, 1);
//        lruCacheRev2.put(2, 2);
//        System.out.println(lruCacheRev2.get(1));       // returns 1
//        lruCacheRev2.put(3, 3);    // evicts key 2
//        System.out.println(lruCacheRev2.get(2));       // returns -1 (not found)
//        lruCacheRev2.put(4, 4);    // evicts key 1
//        System.out.println(lruCacheRev2.get(1));       // returns -1 (not found)
//        System.out.println(lruCacheRev2.get(3));       // returns 3
//        System.out.println(lruCacheRev2.get(4));       // returns 4
        System.out.println("************************************ Method 3: Ex2 ******************************");
        lruCacheRev2 = new LRUCache_rev2(1 /* capacity */);
        lruCacheRev2.put(2, 1);
        System.out.println(lruCacheRev2.get(2));       // returns 1
        lruCacheRev2.put(3, 2);    // evicts key 2
        System.out.println(lruCacheRev2.get(2));       // returns -1 (not found)
        System.out.println(lruCacheRev2.get(3));       // returns 3
    }
}

class LRUCache {

    HashMap<Integer, Integer> map;
    LinkedList<Integer> linkedList;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        linkedList = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            linkedList.remove((Integer) key);
            linkedList.addFirst(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        map.put(key, value);
        linkedList.remove((Integer) key);
        linkedList.addFirst(key);
        if (linkedList.size() > capacity) {
            Integer last = linkedList.removeLast();
            map.remove(last);
        }
    }
}

class LRUCache_rev {

    class Node {
        int key;
        int val;
        Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }

    Node head, tail;
    Map<Integer, Node> cache;
    int maxSize;

    public LRUCache_rev(final int capacity) {
        cache = new HashMap<>();
        head = tail = null;
        maxSize = capacity;
    }

    private void addNode(Node node) {
//        Always add node at front.
        node.next = head;
        node.pre = null;
        if (head != null) {
            head.pre = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    private void deleteNode(Node node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }
    }

    private void removeAndAddToTop(Node node) {
        deleteNode(node);
        addNode(node);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            removeAndAddToTop(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            removeAndAddToTop(node);
        } else {
            if (cache.size() == maxSize) {
                deleteNode(cache.remove(tail.key));
            }
            Node node = new Node(key, value);
            addNode(node);
            cache.put(key, node);
        }
    }
}

class LRUCache_rev2 {

    Node head, tail;
    Map<Integer, Node> map;
    int max;
    public LRUCache_rev2(int capacity) {
        map = new HashMap<>();
        max = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteAndAddToFirst(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node newNode = map.get(key);
            newNode.val = value;
            deleteAndAddToFirst(newNode);
            map.put(key, newNode);
        } else {
            if (map.size() == max) {
                deleteNode(map.remove(tail.key));
            }
            Node newNode = new Node(key);
            newNode.val = value;
            addNode(newNode);
            map.put(key, newNode);
        }
    }

    private void addNode(Node node) {
        if (head == null && tail == null) {
//             When both the nodes are null
            head = tail = node;
            head.next = node;
            tail.pre = node;
        } else if (head == tail) {
//             If only one node is present, then add the new node to start
            head = node;
            tail.pre = node;
            head.next = tail;
        } else {
//            Add the node to start
            node.next = head;
            head.pre = node;
            head = node;
        }
    }

    private void deleteNode(Node node) {
        if (head == tail) {
//             When you have only one node
            head = tail = null;
        } else if (head == node) {
//             When you have to delete the first node.
            head.next.pre = null;
            head = head.next;
        } else if (tail == node) {
            tail = tail.pre;
            tail.next = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    private void deleteAndAddToFirst(Node node) {
        deleteNode(node);
        addNode(node);
    }

    class Node {
        int key, val;
        Node pre, next;

        Node(int key) {
            this.key = key;
            pre = next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }

}
import java.util.HashMap;
import java.util.Map;

/**
 * MAANG screen drill: LRU Cache (HashMap + doubly linked list).
 *
 * Interview signal:
 * - Do you reach for the right composite structure -- a hash map for O(1)
 *   lookup paired with a doubly linked list for O(1) eviction and reorder --
 *   instead of a TreeMap or a single LinkedHashMap one-liner?
 * - Do you handle the head/tail pointers correctly when the list is empty,
 *   has one node, or has the same node moved to the front twice in a row?
 *
 * Problem:
 * Design a data structure that supports get(key) and put(key, value) in O(1)
 * average time. The cache has a fixed capacity; when it overflows, evict the
 * least recently used entry. Both get and put count as a "use".
 *
 * Approach:
 * 1. HashMap<Integer, Node> gives O(1) lookup from key to its list node.
 * 2. A doubly linked list with sentinel head/tail nodes orders entries from
 *    most recently used (right after head) to least recently used (right
 *    before tail). Sentinels remove every null check around list edits.
 * 3. get  -> if present, unlink the node and reinsert it after head.
 *    put  -> if present, update value and move to front; else insert a new
 *            node after head and, if size > capacity, drop the node before
 *            tail and remove its key from the map.
 *
 * Complexity:
 * - Time: O(1) average for both operations -- map lookup plus constant list
 *   pointer rewires.
 * - Space: O(capacity) for the map and the list nodes.
 */
public class LRUCache {

    private static final class Node {
        final int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> index;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        this.capacity = capacity;
        this.index = new HashMap<>(capacity);
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        Node node = index.get(key);
        if (node == null) {
            return -1;
        }
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node existing = index.get(key);
        if (existing != null) {
            existing.value = value;
            moveToFront(existing);
            return;
        }

        Node node = new Node(key, value);
        index.put(key, node);
        insertAfterHead(node);

        if (index.size() > capacity) {
            Node evict = tail.prev;
            unlink(evict);
            index.remove(evict.key);
        }
    }

    public int size() {
        return index.size();
    }

    private void moveToFront(Node node) {
        unlink(node);
        insertAfterHead(node);
    }

    private void insertAfterHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    public static void main(String[] args) {
        runLeetcodeExample();
        runUpdateRefreshesRecency();
        runRepeatedGetIsIdempotent();
        runSingleSlotEvictsImmediately();
        runRejectsNonPositiveCapacity();

        System.out.println("All LRUCache drill checks passed.");
    }

    private static void runLeetcodeExample() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        expect(1, cache.get(1), "get(1) returns 1");
        cache.put(3, 3);
        expect(-1, cache.get(2), "key 2 evicted by put(3,3)");
        cache.put(4, 4);
        expect(-1, cache.get(1), "key 1 evicted by put(4,4)");
        expect(3, cache.get(3), "key 3 still present");
        expect(4, cache.get(4), "key 4 still present");
    }

    private static void runUpdateRefreshesRecency() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 11);
        cache.put(3, 3);
        expect(-1, cache.get(2), "updating key 1 made key 2 the LRU");
        expect(11, cache.get(1), "key 1 retains the updated value");
    }

    private static void runRepeatedGetIsIdempotent() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.get(1);
        cache.get(1);
        cache.put(3, 3);
        expect(-1, cache.get(2), "key 2 stays the LRU even after repeated get(1)");
        expect(1, cache.get(1), "key 1 still present");
    }

    private static void runSingleSlotEvictsImmediately() {
        LRUCache cache = new LRUCache(1);
        cache.put(1, 1);
        cache.put(2, 2);
        expect(-1, cache.get(1), "single-slot cache evicts on every new key");
        expect(2, cache.get(2), "newest key remains");
    }

    private static void runRejectsNonPositiveCapacity() {
        try {
            new LRUCache(0);
        } catch (IllegalArgumentException expected) {
            return;
        }
        throw new AssertionError("capacity 0 should throw IllegalArgumentException");
    }

    private static void expect(int expected, int actual, String label) {
        if (expected != actual) {
            throw new AssertionError(label
                    + " expected " + expected
                    + " but got " + actual);
        }
    }
}

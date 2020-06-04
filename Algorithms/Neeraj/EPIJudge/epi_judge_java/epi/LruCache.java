package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LruCache {
    class Node {
        int val;
        Node pre, next;

        public Node(int val) {
            this.val = val;
            pre = null;
            next = null;
        }
    }

    Node head, tail;
    Map<Integer, Node> cache;
    int maxSize;

    LruCache(final int capacity) {
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
        if(node.pre != null){
            node.pre.next = node.next;
        }else{
            head = node.next;
        }

        if(node.next != null){
            node.next.pre = node.pre;
        }else{
            tail = node.pre;
        }
    }

    private void removeAndAddToTop(Node node) {
        deleteNode(node);
        addNode(node);
    }

    public Integer lookup(Integer key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            removeAndAddToTop(node);
            return node.val;
        }
        return -1;
    }

    public void insert(Integer key, Integer value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            removeAndAddToTop(node);
        } else {
            if (cache.size() == maxSize) {
                cache.remove(tail.val);
                deleteNode(tail);
            }
            Node node = new Node(value);
            addNode(node);
            cache.put(key, node);
        }
    }

    public Boolean erase(Object key) {
        int keyInt = (int) key;
        if (cache.containsKey(keyInt)) {
            Node node = cache.get(keyInt);
            deleteNode(node);
            cache.remove(keyInt);
            return true;
        }
        return false;
    }

    @EpiUserType(ctorParams = {String.class, int.class, int.class})
    public static class Op {
        String code;
        int arg1;
        int arg2;

        public Op(String code, int arg1, int arg2) {
            this.code = code;
            this.arg1 = arg1;
            this.arg2 = arg2;
        }
    }

    @EpiTest(testDataFile = "lru_cache.tsv")
    public static void lruCacheTester(List<Op> commands) throws TestFailure {
        if (commands.isEmpty() || !commands.get(0).code.equals("LruCache")) {
            throw new RuntimeException("Expected LruCache as first command");
        }
        LruCache cache = new LruCache(commands.get(0).arg1);
        for (Op op : commands.subList(1, commands.size())) {
            int result;
            switch (op.code) {
                case "lookup":
                    result = cache.lookup(op.arg1);
                    if (result != op.arg2) {
                        throw new TestFailure("Lookup: expected " + String.valueOf(op.arg2) +
                                ", got " + String.valueOf(result));
                    }
                    break;
                case "insert":
                    cache.insert(op.arg1, op.arg2);
                    break;
                case "erase":
                    result = cache.erase(op.arg1) ? 1 : 0;
                    if (result != op.arg2) {
                        throw new TestFailure("Erase: expected " + String.valueOf(op.arg2) +
                                ", got " + String.valueOf(result));
                    }
                    break;
                default:
                    throw new RuntimeException("Unexpected command " + op.code);
            }
        }
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "LruCache.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}

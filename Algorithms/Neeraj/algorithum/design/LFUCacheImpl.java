import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created on:  Mar 11, 2021
 * Questions: https://leetcode.com/problems/lfu-cache/
 */

public class LFUCacheImpl {

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1) + " = 1");      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2) + " = -1");
        System.out.println(lfu.get(3) + " = 3");
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1) + " = -1");
        System.out.println(lfu.get(3) + " = 3");
        System.out.println(lfu.get(4) + " = 4");
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);      // return 4
        // cache=[3,4], cnt(4)=2, cnt(3)=3

        lfu = new LFUCache(0);
        lfu.put(0, 0);
        System.out.println(lfu.get(0) + " = -1");
    }

    static class LFUCache_2 {
        static class Node {
            int key, val, occ;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
                occ = 1;
            }
        }

        int limit, minOcc;
        Map<Integer, Node> cache = new HashMap<>();
        Map<Integer, LinkedHashSet<Integer>> occurrences = new HashMap<>();

        public LFUCache_2(int capacity) {
            this.limit = capacity;
            minOcc = -1;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node != null) {
                updateNode(node);
                return node.val;
            }
            return -1;
        }

        private void updateNode(Node node) {
            int preOcc = node.occ++;
            occurrences.get(preOcc).remove(node.key);
//            If the pre-occurrences is the min occurrence and there are no any nodes with that occurrences, then increase the minOccurance.
            if (occurrences.get(preOcc).isEmpty()) {
                if (minOcc == preOcc) minOcc++;
                occurrences.remove(preOcc);
            }
            occurrences.computeIfAbsent(node.occ, val -> new LinkedHashSet<>()).add(node.key);
        }

        public void put(int key, int value) {
            if (limit <= 0) return;
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.val = value;
                updateNode(node);
            } else {
                if (cache.size() == limit) {
                    LinkedHashSet<Integer> keySet = occurrences.get(minOcc);
                    Integer removeKey = keySet.iterator().next();
                    keySet.remove(removeKey);
                    if (keySet.isEmpty()) occurrences.remove(minOcc);
                    cache.remove(removeKey);
                }
                Node node = new Node(key, value);
                cache.put(key, node);
                occurrences.computeIfAbsent(node.occ, val -> new LinkedHashSet<>()).add(node.key);
                minOcc = 1;
            }
        }
    }

    static class LFUCache {
        int limit, minOcc = -1;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        Map<Integer, LinkedHashSet<Integer>> countMap = new TreeMap<>();

        public LFUCache(int capacity) {
            limit = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                int occ = occurrenceMap.get(key);
                countMap.get(occ).remove(key);
                if (occ == minOcc && countMap.get(occ).size() == 0) minOcc++;
                if (countMap.get(occ).size() == 0) countMap.remove(occ);
                countMap.computeIfAbsent(occ + 1, val -> new LinkedHashSet<>()).add(key);
                occurrenceMap.put(key, occ + 1);
                return map.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if (limit <= 0) return;
            if (map.containsKey(key)) {
                get(key);
            } else {
                if (map.size() >= limit) {
                    int evict = countMap.get(minOcc).iterator().next();
                    countMap.get(minOcc).remove(evict);
                    map.remove(evict);
                }
                occurrenceMap.put(key, 1);
                countMap.computeIfAbsent(1, val -> new LinkedHashSet<>()).add(key);
                minOcc = 1;
            }
            map.put(key, value);
        }
    }
}

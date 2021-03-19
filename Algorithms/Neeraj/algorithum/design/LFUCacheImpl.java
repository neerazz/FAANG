import java.util.*;

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

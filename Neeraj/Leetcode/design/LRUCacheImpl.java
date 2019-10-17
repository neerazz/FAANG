package design;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
The cache is initialized with a positive capacity.
Follow up: Could you do both operations in O(1) time complexity?
Example:
LRUCache cache = new LRUCache( 2 ); capacity
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
 */
public class LRUCacheImpl {
    public static void main(String[] args) {

//        LRUCache cache = new LRUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1) + " return 1");       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        System.out.println(cache.get(2) + " return -1");      // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        System.out.println(cache.get(1) + " return -1");       // returns -1 (not found)
//        System.out.println(cache.get(3) + " return 3");       // returns 3
//        System.out.println(cache.get(4) + " return 4");       // returns 4
        System.out.println("=============================================================");
        LRUCache cache1 = new LRUCache(2);
        System.out.println(cache1.get(2) + " return -1");
        cache1.put(2, 6);
        System.out.println(cache1.get(1) + " return -1");
        cache1.put(1, 5);
        cache1.put(1, 2);
        System.out.println(cache1.get(1) + " return 2");
        System.out.println(cache1.get(2) + " return 6");
    }
}

class LRUCache {

    LinkedHashMap<Integer, Integer> linkedHashMap;

    public LRUCache(int capacity) {
        linkedHashMap = new LinkedHashMap<Integer, Integer>(capacity) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (linkedHashMap.containsKey(key)) {
            Integer value = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        /*
         * this is added for an edge case when we put (1,1), (2,1) and then 2,3 , map puts the new entry in the old position but ideally it should be on the top
         * to keep iton top we are doing a get operation. Hence I am using a get key such that the element will be on the top
         */
        if (linkedHashMap.get(key) != null) {
            get(key);
        }
        linkedHashMap.put(key, value);
    }
}
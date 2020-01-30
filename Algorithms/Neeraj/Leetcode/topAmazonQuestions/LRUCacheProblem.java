package topAmazonQuestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

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
        LRUCache cache = new LRUCache( 2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
class LRUCache {

    HashMap<Integer, Integer> map;
    LinkedList<Integer> linkedList;
    int capacity ;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        linkedList = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            linkedList.remove((Integer) key);
            linkedList.addFirst(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        map.put(key,value);
        linkedList.remove((Integer) key);
        linkedList.addFirst(key);
        if (linkedList.size() > capacity){
            Integer last = linkedList.removeLast();
            map.remove(last);
        }
    }
}
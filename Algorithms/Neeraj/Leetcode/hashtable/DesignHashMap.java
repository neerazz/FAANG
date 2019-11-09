package hashtable;

/*
https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1140/
Design a HashMap without using any built-in hash table libraries.
To be specific, your design should include these functions:
put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
Example:
MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);
hashMap.put(2, 2);
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found)
Note: All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.
 */
public class DesignHashMap {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));             // returns 1
        System.out.println(hashMap.get(3));             // returns -1 (not found)
        hashMap.put(2, 1);                              // update the existing value
        System.out.println(hashMap.get(2));             // returns 1
        hashMap.remove(2);                         // remove the mapping for 2
        System.out.println(hashMap.get(2));             // returns -1 (not found)
    }
}

class MyHashMap {

    private Node[] bucket;
    private int range;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        range = 1000000;
        bucket = new Node[range];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hashValue = getHashValue(key);
        Node node = bucket[hashValue];
        if (node == null) bucket[hashValue] = new Node(key, value);
        else node.value = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hashValue = getHashValue(key);
        Node node = bucket[hashValue];
        if (node != null) return node.value;
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hashValue = getHashValue(key);
        Node node = bucket[hashValue];
        if (node == null) {
//            The value doesn't exit.
            System.out.println("The value doesn't exist.");
        } else if (node.next == null) {
            bucket[hashValue] = null;
        } else {
            Node ref = node;
            while (ref.next != null) {
//            Iterate to the end of the node if there is a hash collision.
                if (ref.key == key) {
                    ref = ref.next;
                    return;
                }
                ref = ref.next;
            }
        }
    }

    private int getHashValue(int key) {
        return key % range;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        Node node = bucket[getHashValue(key)];
        if (node != null) {
            while (node.next != null) {
                if (node.value == key) {
                    return true;
                } else {
                    node = node.next;
                }
            }
            return node.value == key;
        } else {
            return false;
        }
    }

    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key;
        }
    }
}
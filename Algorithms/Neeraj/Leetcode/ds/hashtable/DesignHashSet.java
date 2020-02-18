package ds.hashtable;

/*
https://leetcode.com/explore/learn/card/hash-table/182/practical-applications/1139/
Design a HashSet without using any built-in hash table libraries.
To be specific, your problems.design should include these functions:
add(value): Insert a value into the HashSet.
contains(value) : Return whether the value exists in the HashSet or not.
remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
Example:
MyHashSet hashSet = new MyHashSet();
hashSet.add(1);
hashSet.add(2);
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);
hashSet.contains(2);    // returns true
hashSet.remove(2);
hashSet.contains(2);    // returns false (already removed)
Note:
All values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashSet library.
 */
public class DesignHashSet {
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }
}

class MyHashSet {

    private Node[] bucket;
    private int range;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        range = 1000000;
        bucket = new Node[range];
    }

    public void add(int key) {
        if (!contains(key)) {
            int hashValue = getHashValue(key);
            Node node = bucket[hashValue];
            if (node != null) {
//            Then get the node from the bucket and append the current value to it.
                node.next = new Node(key);
            } else {
                bucket[hashValue] = new Node(key);
            }
        }
    }

    private int getHashValue(int key) {
        return key % range;
    }

    public void remove(int key) {
        if (contains(key)) {
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
                    ref = ref.next;
                }
                ref = null;
            }
        }
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
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value;
        }
    }
}
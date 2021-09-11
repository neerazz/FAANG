package concepts.hastable;

import java.util.ArrayList;
import java.util.List;


class MyHashSet {

    List<Integer> myData;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        myData = new ArrayList<>();
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);    // returns true
        hashSet.contains(3);    // returns false (not found)
        hashSet.add(2);
        hashSet.contains(2);    // returns true
        hashSet.remove(2);
        hashSet.contains(2);    // returns false (already removed)
    }

    public void add(int key) {
        int position = getHash(key);
        myData.set(position, key);
    }

    public void remove(int key) {
        int position = getHash(key);
        myData.set(position, null);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int position = getHash(key);
        return myData.get(position) != null;
    }

    public int getHash(int key) {
        return ((key * 31) + key) / 11;
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
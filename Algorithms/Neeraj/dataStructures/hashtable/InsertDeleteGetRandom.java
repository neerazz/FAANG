import java.util.*;

/*
https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1141/
Design a data structure that supports all following operations in average O(1) time.
insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:
// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();
// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);
// Returns false as 2 does not exist in the set.
randomSet.remove(2);
// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);
// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();
// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);
// 2 was already in the set, so return false.
randomSet.insert(2);
// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
 */
public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        System.out.println("********************** Solution 1 ***********************************");
        RandomizedSet randomSet = new RandomizedSet();
        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomSet.insert(1) + " -> true.");

// Returns false as 2 does not exist in the set.
        System.out.println(randomSet.remove(2) + " -> false.");

// Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomSet.insert(2) + " -> true.");

// getRandom should return either 1 or 2 randomly.
        System.out.println(randomSet.getRandom() + " -> [1 or 2]].");

// Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomSet.remove(1) + " -> true.");

// 2 was already in the set, so return false.
        System.out.println(randomSet.insert(2) + " -> false.");

// Since 2 is the only number in the set, getRandom always return 2.
        System.out.println(randomSet.getRandom() + " -> 2.");

        System.out.println("********************** Solution 2 ***********************************");
        RandomizedSet_Elegent randomizedSet_elegent = new RandomizedSet_Elegent();
        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomizedSet_elegent.insert(1) + " -> true.");

// Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet_elegent.remove(2) + " -> false.");

// Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomizedSet_elegent.insert(2) + " -> true.");

// getRandom should return either 1 or 2 randomly.
        System.out.println(randomizedSet_elegent.getRandom() + " -> [1 or 2]].");

// Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomizedSet_elegent.remove(1) + " -> true.");

// 2 was already in the set, so return false.
        System.out.println(randomizedSet_elegent.insert(2) + " -> false.");

// Since 2 is the only number in the set, getRandom always return 2.
        System.out.println(randomizedSet_elegent.getRandom() + " -> 2.");

        System.out.println("********************** Solution 3 ***********************************");
        RandomizedSet_Rev randomizedSet_rev = new RandomizedSet_Rev();
        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomizedSet_rev.insert(1) + " -> true.");

// Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet_rev.remove(2) + " -> false.");

// Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomizedSet_rev.insert(2) + " -> true.");

// getRandom should return either 1 or 2 randomly.
        System.out.println(randomizedSet_rev.getRandom() + " -> [1 or 2]].");

// Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomizedSet_rev.remove(1) + " -> true.");

// 2 was already in the set, so return false.
        System.out.println(randomizedSet_rev.insert(2) + " -> false.");

// Since 2 is the only number in the set, getRandom always return 2.
        System.out.println(randomizedSet_rev.getRandom() + " -> 2.");
    }
}

class RandomizedSet_Rev {

    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet_Rev() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.remove(val);
            int lastIndex = list.size() - 1;
            int lastVal = list.get(lastIndex);
            list.set(index, lastVal);
            map.put(lastVal, index);
            map.remove(val);
            list.remove(lastIndex);
            return true;
        }
        return false;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

class RandomizedSet_Elegent {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random r;


    public RandomizedSet_Elegent() {
        r = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /*
    Replace that element with last
    Remove from map
    Modify last element index in map
    Otherwise, delete in arraylist take O(n) time
    */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(idx, last);
        list.remove(list.size() - 1);
        map.put(last, idx);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}

class RandomizedSet {

    List<Integer> integers;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        integers = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (integers.contains(val)) {
            return false;
        }
        integers.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (integers.contains(val)) {
            integers.remove((Integer) val);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return integers.get(random.nextInt(integers.size()));
    }
}

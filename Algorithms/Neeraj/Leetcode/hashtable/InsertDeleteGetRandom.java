package hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
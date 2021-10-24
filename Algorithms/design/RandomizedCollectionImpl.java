import java.util.*;

/**
 * Created on:  Aug 25, 2020
 * Questions:
 */
public class RandomizedCollectionImpl {
    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(1);
        System.out.println(randomizedCollection.remove(1));
        randomizedCollection.insert(1);
    }

    static class RandomizedCollection {

        List<Integer> nums;
        Map<Integer, Set<Integer>> map;
        Random random;

        public RandomizedCollection() {
            nums = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            boolean contains = map.containsKey(val);
            map.computeIfAbsent(val, set -> new HashSet<>()).add(nums.size());
            nums.add(val);
            return !contains;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;

            int removeIdx = map.get(val).iterator().next();
            map.get(val).remove(removeIdx);

            int lastIdx = nums.size() - 1;
            int last = nums.get(lastIdx);
            nums.set(removeIdx, last);

//         Update the map with the new index of the value.
            map.get(last).add(removeIdx);
            map.get(last).remove(lastIdx);
            nums.remove(lastIdx);
            return true;
        }

        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }
}

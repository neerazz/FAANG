import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Sep 18, 2021
 * Ref: https://leetcode.com/problems/two-sum-iii-data-structure-design/
 * <p>
 * Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a particular value.
 * <p>
 * Implement the TwoSum class:
 * <p>
 * TwoSum() Initializes the TwoSum object, with an empty array initially.
 * void add(int number) Adds number to the data structure.
 * boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["TwoSum", "add", "add", "add", "find", "find"]
 * [[], [1], [3], [5], [4], [7]]
 * Output
 * [null, null, null, null, true, false]
 * <p>
 * Explanation
 * TwoSum twoSum = new TwoSum();
 * twoSum.add(1);   // [] --> [1]
 * twoSum.add(3);   // [1] --> [1,3]
 * twoSum.add(5);   // [1,3] --> [1,3,5]
 * twoSum.find(4);  // 1 + 3 = 4, return true
 * twoSum.find(7);  // No two integers sum up to 7, return false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -105 <= number <= 105
 * -231 <= value <= 231 - 1
 * At most 104 calls will be made to add and find.
 */
public class TwoSumIIIDataStructureDesign {
    public static void main(String[] args) {

    }

    static class TwoSum {

        Map<Integer, Integer> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {

        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            for (int num : map.keySet()) {
                int rem = value - num;
                if (rem == num && map.get(rem) > 1) return true;
                else if (rem != num && map.containsKey(rem)) return true;
            }
            return false;
        }
    }
}

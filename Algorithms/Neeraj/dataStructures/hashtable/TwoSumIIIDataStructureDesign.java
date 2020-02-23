import java.util.ArrayList;
import java.util.Collections;

/*
https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1179/
Design and implement a TwoSum class. It should support the following operations: add and find.
add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.
Example 1:
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
Example 2:
add(3); add(1); add(2);
find(3) -> true
find(6) -> false
 */
public class TwoSumIIIDataStructureDesign {
    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        obj.add(1);
        obj.add(3);
        obj.add(5);
        System.out.println(obj.find(4) + " -> true");
        System.out.println(obj.find(7) + " -> false");
        System.out.println("================================");
        TwoSum obj1 = new TwoSum();
        obj1.add(1);
        obj1.add(3);
        obj1.add(2);
        System.out.println(obj1.find(3) + " -> true");
        System.out.println(obj1.find(6) + " -> false");
        System.out.println("================================");
        TwoSum obj2 = new TwoSum();
        obj2.add(0);
        obj2.add(0);
        System.out.println(obj2.find(0) + " -> true");
    }

    static class TwoSum {
        ArrayList<Integer> integers;

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {
            integers = new ArrayList<>();
        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            integers.add(number);
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            Collections.sort(integers);
            int left = 0;
            int right = integers.size() - 1;
            while (left < right) {
                if (integers.get(left) + integers.get(right) < value) {
                    left++;
                } else if (integers.get(left) + integers.get(right) > value) {
                    right--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
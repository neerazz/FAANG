/*
    Created on:  Apr 28, 2020
 */

import java.util.*;

/**
 * Questions:
 */
public class FirstUniqueNumber {
    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique(new int[]{7, 7, 7, 7, 7, 7});
        System.out.println(firstUnique.showFirstUnique());  // return -1
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
        firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        System.out.println(firstUnique.showFirstUnique()); // return 17
    }

    static class FirstUnique {
        LinkedHashSet<Integer> unique = new LinkedHashSet<>();
        Set<Integer> duplicate = new HashSet<>();

        public FirstUnique(int[] nums) {
            for (int num : nums) {
                add(num);
            }
        }

        public int showFirstUnique() {
            if (unique.isEmpty()) {
                return -1;
            }
            int op = 0;
            for (int val : unique) {
                op = val;
                break;
            }
            return op;
        }

        public void add(int value) {
            if (!unique.contains(value) && !duplicate.contains(value)) {
                unique.add(value);
            } else if (unique.contains(value)) {
                unique.remove(value);
                duplicate.add(value);
            }
        }
    }
}

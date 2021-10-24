import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created on:  Jul 26, 2020
 * Questions: https://leetcode.com/problems/linked-list-random-node/
 */
public class LinkedListRandomNode {
    public static void main(String[] args) {

    }

    static class Solution {

        Random random;
        Map<Integer, Integer> map;

        public Solution(ListNode head) {
            map = new HashMap<>();
            random = new Random();
            int i = 0;
            while (head != null) {
                map.put(i++, head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            return map.get(random.nextInt(map.size()));
        }
    }
}

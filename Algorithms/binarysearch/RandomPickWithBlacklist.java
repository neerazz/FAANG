import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created on:  Sep 29, 2020
 * Questions: https://leetcode.com/problems/random-pick-with-blacklist/
 */
public class RandomPickWithBlacklist {
    public static void main(String[] args) {
    }

    static class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        Random ran = new Random();
        private int allowedNumber;

        public Solution(int N, int[] blacklist) {
//            Add all the blacklist number into map.
            for (int num : blacklist) {
                map.put(num, -1);
            }
            allowedNumber = N - blacklist.length;
//            Re-map all the blacklist number to a non blacklist number.
            for (int num : blacklist) {
                if (num >= allowedNumber) continue;
//                Remap only the blacklist number that falls below the allowedLength of number.
                while (map.containsKey(N - 1)) {
//                Start mapping from top, when you encounter a number that is in blacklist, then keep reducing, till you get an allowed number.
                    N--;
                }
                map.put(num, --N);
            }
        }

        public int pick() {
            int ranNumber = ran.nextInt(allowedNumber);
            return map.getOrDefault(ranNumber, ranNumber);
        }
    }
}

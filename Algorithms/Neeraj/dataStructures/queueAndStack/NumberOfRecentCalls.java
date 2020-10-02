import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created on:  Oct 01, 2020
 * Questions: https://leetcode.com/problems/number-of-recent-calls/
 */
public class NumberOfRecentCalls {
    public static void main(String[] args) {

    }

    static class RecentCounter_Optimal {
        Queue<Integer> queue;

        public RecentCounter_Optimal() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.add(t);
            while (!queue.isEmpty() && queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }

    static class RecentCounter {
        TreeMap<Integer, Integer> map;
        int counter;

        public RecentCounter() {
            map = new TreeMap<>();
            counter = 0;
        }

        public int ping(int t) {
            map.put(t, counter++);
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(t - 3000);
            return map.get(t) - entry.getValue() + 1;
        }
    }
}

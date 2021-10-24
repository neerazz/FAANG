import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on:  Jun 26, 2021
 * Ref:https://leetcode.com/discuss/interview-question/398023/Microsoft-Online-Assessment-Questions/987230
 */

public class StreamPairCounterImpl {

    public static void main(String[] args) {

    }

    static class StreamPairCounter {
        int dist;
        long counter;
        Map<Integer, List<Long>> map = new HashMap<>();

        /**
         * distance: neighboring distance (In the example above: 2)
         */
        StreamPairCounter(int dist) {
            this.dist = dist;
        }

        /**
         * This method will be called by the client to add a new hop
         */
        public void addHop(int number) {
//            Time: o(1)
            map.computeIfAbsent(number, val -> new ArrayList<>()).add(counter++);
        }

        /**
         * Get the count of pairs for a given number
         */
        public int getPairCountFor(int number) {
//            Time: o(n), where n is the max number of times a number can occur;
            List<Long> idxs = map.get(number);
            if (idxs == null || idxs.size() < 2) return 0;
            long pre = -1, count = 0;
            for (long cur : idxs) {
                if (pre != -1 && cur - pre <= dist) count++;
                pre = cur;
            }
            return (int) count;
        }
    }

}

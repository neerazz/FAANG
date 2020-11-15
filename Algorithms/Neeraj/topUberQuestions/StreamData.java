import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 14, 2020
 * Questions: https://leetcode.com/discuss/interview-question/928556/Uber-or-Onsite-or-Stream-Data
 */

public class StreamData {

    public static void main(String[] args) {
        MyDS myDs = new MyDS();
        myDs.newData(0, "a", 1);
        myDs.newData(0, "a", 2);
        myDs.newData(0, "b", 5);
        myDs.newData(1, "c", 6);
        myDs.newData(2, "d", 3);
        myDs.newData(3, "d", 7);
        myDs.newData(4, "d", 1);
        myDs.newData(4, "a", 2);
        myDs.newData(5, "b", 4);
        myDs.newData(5, "e", 5);
        myDs.newData(5, "e", 6);
        myDs.newData(5, "d", 4);
        myDs.newData(6, "a", 2);
        myDs.newData(6, "c", 1);
        myDs.newData(13, "c", 5);
        System.out.println(myDs.top3(6));
        System.out.println(myDs.top3(13));
    }

    static class MyDS {
        Map<Integer, Map<String, Integer>> map = new HashMap<>();

        //        Time: O(1)
        void newData(int time, String key, int value) {
            map.putIfAbsent(time, new HashMap<>());
            Map<String, Integer> curMap = map.get(time);
            curMap.put(key, curMap.getOrDefault(key, 0) + value);
        }

        //        Time: O(10*d) + O(d log 3) = O(d). Space : O(d). Where d -> distant keys.
        List<String> top3(int t) {
            Map<String, Integer> group = new HashMap<>();
//            Get all the maps between t-9 to t
            for (int i = t - 9; i <= t; i++) {
                if (map.containsKey(i)) {
                    Map<String, Integer> cur = map.get(i);
                    for (Map.Entry<String, Integer> entry : cur.entrySet()) {
                        group.put(entry.getKey(), group.getOrDefault(entry.getKey(), 0) + entry.getValue());
                    }
                }
            }
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
            for (Map.Entry<String, Integer> entry : group.entrySet()) {
                pq.add(entry);
                if (pq.size() > 3) {
                    pq.poll();
                }
            }
            LinkedList<String> top3 = new LinkedList<>();
            while (!pq.isEmpty()) {
                Map.Entry<String, Integer> poll = pq.poll();
                top3.addFirst(String.format("('%s', %d)", poll.getKey(), poll.getValue()));
            }
            return top3;
        }
    }
}

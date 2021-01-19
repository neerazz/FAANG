import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 18, 2021
 * Questions:
 */

public class PartitionString {

    public static void main(String[] args) {

    }

    public static List<String> partitionString(String input) {
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            int finalI = i;
            map.computeIfAbsent(cur, val -> new int[]{finalI, finalI})[1] = i;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((r1, r2) -> Integer.compare(r1[0], r2[0]));
        pq.addAll(map.values());
        int[] pre = pq.poll();
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (Math.max(pre[0], cur[0]) <= Math.min(pre[1], cur[1])) {
                pre[0] = Math.min(pre[0], cur[0]);
                pre[1] = Math.max(pre[1], cur[1]);
            } else {
                result.add(input.substring(pre[0], pre[1] + 1));
                pre = cur;
            }
        }
        return result;
    }
}

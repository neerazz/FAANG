import java.util.PriorityQueue;

/**
 * Created on:  Jan 15, 2021
 * Questions: https://aonecode.com/aplusplus/interviewctrl/getInterview/1189567720
 */

public class TaggingSystem {

    public static void main(String[] args) {
        System.out.println(largestScore("cbddd", 2));
    }

    private static String largestScore(String str, int limit) {
        int[] count = new int[26];
        for (char cur : str.toCharArray()) count[cur - 'a']++;
        PriorityQueue<int[]> pq = new PriorityQueue<>((c1, c2) -> c1[0] == c2[0] ? Integer.compare(c2[1], c2[1]) : Integer.compare(c2[0], c1[0]));
//        0: char, 1: count
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) pq.add(new int[]{i, count[i]});
        }
        if (pq.isEmpty()) return sb.toString();
        int[] pre = pq.poll();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
//            Take the max of limit or count from the pre.
            if (pre[1] > limit) {
                pre[1] -= limit;
                pq.add(pre);
                sb.append(getString(pre[0], limit));
            } else {
                sb.append(getString(pre[0], pre[1]));
            }
            pre = cur;
        }
        sb.append(getString(pre[0], Math.min(limit, pre[1])));
        return sb.toString();
    }

    private static String getString(int c, int count) {
        return ("" + (char) ('a' + c)).repeat(count);
    }
}

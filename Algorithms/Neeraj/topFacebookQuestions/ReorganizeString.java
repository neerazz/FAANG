import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Created on:  Jul 20, 2020
 * Questions:
 */
public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
    }

    public static String reorganizeString(String s) {
        if (s.length() == 0) return "";
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
//         0 -> char, 1 -> freq
        PriorityQueue<int[]> pq = new PriorityQueue<>((c1, c2) -> Integer.compare(c2[1], c1[1]));
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.add(new int[]{i, count[i]});
            }
        }
        int[] pre = pq.poll();
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            sb.append((char) ('a' + pre[0]));
            if (pre[1]-- > 1) {
                pq.add(pre);
            }
            pre = cur;
        }
        if (pre[1] > 1) return "";
        return sb.append((char) ('a' + pre[0])).toString();
    }
}
